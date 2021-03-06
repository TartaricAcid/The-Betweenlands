package thebetweenlands.common;

import org.apache.logging.log4j.Logger;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.InstanceFactory;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import thebetweenlands.common.capability.base.EntityCapabilityHandler;
import thebetweenlands.common.capability.base.ItemCapabilityHandler;
import thebetweenlands.common.command.CommandAspectDiscovery;
import thebetweenlands.common.command.CommandBLEvent;
import thebetweenlands.common.command.CommandResetAspects;
import thebetweenlands.common.event.handler.AnvilEventHandler;
import thebetweenlands.common.event.handler.ArmorHandler;
import thebetweenlands.common.event.handler.AspectSyncHandler;
import thebetweenlands.common.event.handler.AttackDamageHandler;
import thebetweenlands.common.event.handler.BlockBreakHandler;
import thebetweenlands.common.event.handler.EntitySpawnHandler;
import thebetweenlands.common.event.handler.EnvironmentEventHandler;
import thebetweenlands.common.event.handler.FoodSicknessHandler;
import thebetweenlands.common.event.handler.ItemEquipmentHandler;
import thebetweenlands.common.event.handler.LocationHandler;
import thebetweenlands.common.event.handler.OverworldItemHandler;
import thebetweenlands.common.event.handler.PlayerDecayHandler;
import thebetweenlands.common.event.handler.PlayerPortalHandler;
import thebetweenlands.common.event.handler.PuppetHandler;
import thebetweenlands.common.item.equipment.ItemRingOfFlight;
import thebetweenlands.common.item.tools.ItemBLShield;
import thebetweenlands.common.lib.ModInfo;
import thebetweenlands.common.proxy.CommonProxy;
import thebetweenlands.common.registries.MessageRegistry;
import thebetweenlands.common.registries.Registries;
import thebetweenlands.common.world.WorldProviderBetweenlands;
import thebetweenlands.common.world.biome.spawning.MobSpawnHandler;
import thebetweenlands.common.world.gen.feature.structure.WorldGenDruidCircle;
import thebetweenlands.common.world.storage.chunk.BetweenlandsChunkData;
import thebetweenlands.common.world.storage.chunk.ChunkDataBase;
import thebetweenlands.common.world.storage.world.global.WorldDataBase;
import thebetweenlands.common.world.teleporter.TeleporterHandler;
import thebetweenlands.core.TheBetweenlandsPreconditions;
import thebetweenlands.util.config.ConfigHandler;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, guiFactory = ModInfo.CONFIG_GUI, acceptedMinecraftVersions = ModInfo.MC_VERSIONS)
public class TheBetweenlands {
	@Instance(ModInfo.ID)
	public static TheBetweenlands INSTANCE;
	
	@SidedProxy(modId = ModInfo.ID, clientSide = ModInfo.CLIENTPROXY_LOCATION, serverSide = ModInfo.COMMONPROXY_LOCATION)
	public static CommonProxy proxy;
	
	public static final Registries REGISTRIES = new Registries();
	
	public static DimensionType dimensionType;
	public static boolean isShadersModInstalled = false;
	public static SimpleNetworkWrapper networkWrapper;
	public static Logger logger;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		
		//Configuration File
		ConfigHandler.INSTANCE.loadConfig(event);

		BetweenlandsAPI.init();

		dimensionType = DimensionType.register("Betweenlands", "", ConfigHandler.dimensionId, WorldProviderBetweenlands.class, false);
		DimensionManager.registerDimension(ConfigHandler.dimensionId, dimensionType);

		REGISTRIES.preInit();

		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);

		/// Network ///
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.CHANNEL);

		MessageRegistry.preInit();

		//Renderers
		proxy.registerItemAndBlockRenderers();
		proxy.preInit();
	}

	@InstanceFactory
	public static TheBetweenlands createInstance() {
		TheBetweenlandsPreconditions.check();
		return new TheBetweenlands();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		REGISTRIES.init();

		TeleporterHandler.init();

		proxy.init();

		this.registerEventHandlers();

		GameRegistry.registerWorldGenerator(new WorldGenDruidCircle(), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();

		/*if (ConfigHandler.DEBUG) {
			System.out.println("==================================================");
			for (String name : unlocalizedNames) {
				System.out.println("needs translation: " + name);
			}
			System.out.println("==================================================");
		}*/
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandBLEvent());
		event.registerServerCommand(new CommandResetAspects());
		//event.registerServerCommand(new CommandDecay());
		//event.registerServerCommand(new CommandFindPage());
		event.registerServerCommand(new CommandAspectDiscovery());
		/*if (ConfigHandler.DEBUG) {
			event.registerServerCommand(new CommandTickSpeed());
		}
		BLGamerules.INSTANCE.onServerStarting(event);*/
	}

	/**
	 * Register event handlers here
	 */
	private void registerEventHandlers() {
		proxy.registerEventHandlers();

		MinecraftForge.EVENT_BUS.register(ConfigHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ItemBLShield.EventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(WorldDataBase.WORLD_EVENT_HANDLER);
		MinecraftForge.EVENT_BUS.register(ChunkDataBase.CHUNK_EVENT_HANDLER);
		MinecraftForge.EVENT_BUS.register(BetweenlandsChunkData.class);
		MinecraftForge.EVENT_BUS.register(new AnvilEventHandler());
		MinecraftForge.EVENT_BUS.register(EnvironmentEventHandler.class);
		MinecraftForge.EVENT_BUS.register(EntityCapabilityHandler.class);
		MinecraftForge.EVENT_BUS.register(ItemCapabilityHandler.class);
		MinecraftForge.EVENT_BUS.register(PlayerDecayHandler.class);
		MinecraftForge.EVENT_BUS.register(AspectSyncHandler.class);
		MinecraftForge.EVENT_BUS.register(MobSpawnHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(BlockBreakHandler.class);
		MinecraftForge.EVENT_BUS.register(LocationHandler.class);
		MinecraftForge.EVENT_BUS.register(AttackDamageHandler.class);
		MinecraftForge.EVENT_BUS.register(ItemEquipmentHandler.class);
		MinecraftForge.EVENT_BUS.register(EntitySpawnHandler.class);
		MinecraftForge.EVENT_BUS.register(ArmorHandler.class);
		MinecraftForge.EVENT_BUS.register(ItemRingOfFlight.class);
		MinecraftForge.EVENT_BUS.register(PuppetHandler.class);
		MinecraftForge.EVENT_BUS.register(OverworldItemHandler.class);
		MinecraftForge.EVENT_BUS.register(PlayerPortalHandler.class);
		MinecraftForge.EVENT_BUS.register(FoodSicknessHandler.class);
	}
}
