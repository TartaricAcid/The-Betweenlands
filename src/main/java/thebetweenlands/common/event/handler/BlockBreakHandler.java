package thebetweenlands.common.event.handler;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thebetweenlands.common.entity.mobs.EntityPyrad;
import thebetweenlands.common.registries.BlockRegistry;
import thebetweenlands.common.registries.SoundRegistry;
import thebetweenlands.common.world.storage.world.global.BetweenlandsWorldData;
import thebetweenlands.common.world.storage.world.shared.location.EnumLocationType;
import thebetweenlands.common.world.storage.world.shared.location.LocationStorage;

public class BlockBreakHandler {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		EntityPlayer player = event.getPlayer();
		if(player != null && !player.isCreative() && !event.getWorld().isRemote) {
			BlockPos pos = event.getPos();
			IBlockState blockState = event.getState();

			//Wake up nearby Pyrads
			if(blockState.getBlock() == BlockRegistry.WEEDWOOD || blockState.getBlock() == BlockRegistry.LOG_WEEDWOOD) {
				BetweenlandsWorldData worldStorage = BetweenlandsWorldData.forWorld(event.getWorld());
				List<LocationStorage> locations = worldStorage.getSharedStorageAt(LocationStorage.class, pos.getX(), pos.getZ());

				for(LocationStorage location : locations) {
					if(location.getType() == EnumLocationType.GIANT_TREE) {
						List<EntityPyrad> pyrads = new ArrayList<EntityPyrad>();

						for(AxisAlignedBB bounds : location.getBounds()) {
							pyrads.addAll(event.getWorld().getEntitiesWithinAABB(EntityPyrad.class, bounds));
						}

						for(EntityPyrad pyrad : pyrads) {
							if(!pyrad.isActive() && event.getWorld().rand.nextInt(10) == 0) {
								pyrad.playSound(SoundRegistry.PYRAD_HURT, 0.4F, 1.0F);
								pyrad.playSound(SoundRegistry.PYRAD_HURT, 0.4F, 0.5F);
								pyrad.playSound(SoundRegistry.PYRAD_HURT, 0.4F, 0.25F);
								pyrad.setActive(true);
								pyrad.setAttackTarget(player);
							}
						}
					}
				}
			}
		}
	}
}
