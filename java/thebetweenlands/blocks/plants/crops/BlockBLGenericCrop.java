package thebetweenlands.blocks.plants.crops;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import thebetweenlands.blocks.BLBlockRegistry;
import thebetweenlands.blocks.terrain.BlockFarmedDirt;
import thebetweenlands.creativetabs.ModCreativeTabs;
import thebetweenlands.items.BLItemRegistry;
import thebetweenlands.items.ItemMaterialsBL.EnumMaterialsBL;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBLGenericCrop extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	@SideOnly(Side.CLIENT)
	private IIcon decayedTexture;
	private String type;

	public BlockBLGenericCrop(String blockName) {
		setStepSound(soundTypeGrass);
		setCreativeTab(ModCreativeTabs.blocks);
		type = blockName;
		setBlockName("thebetweenlands." + type);
		setBlockTextureName("thebetweenlands:" + type);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

		if (metadata >= 7) {
			for (int i = 0; i < 1 + fortune; ++i)
				if (world.rand.nextInt(15) <= metadata)
					ret.add(getSeedDrops());
			ret.add(getCropDrops());
		}
		return ret;
	}
	
	public ItemStack getSeedDrops() {
		if(type.equals("middleFruitBush"))
			return new ItemStack(BLItemRegistry.middleFruitSeeds, 1, 0);	
		return null;	
	}
		
	public ItemStack getCropDrops() {
		if(type.equals("middleFruitBush"))
			return new ItemStack(BLItemRegistry.middleFruit, 1, 0);	
		return null;	
	}
	
	@Override
	protected Item func_149866_i() { //disabled for custom BL bits
		return null;
	}

	@Override
	protected Item func_149865_P() { //disabled for custom BL bits
		return null;
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		int meta = world.getBlockMetadata(x, y -1, z);
		return soil != null && soil instanceof BlockFarmedDirt && meta >= 4 && meta <= 8;
	}

	@Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == BLBlockRegistry.farmedDirt;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return false;
		int meta = world.getBlockMetadata(x, y, z);
		System.out.println("Crop Meta is: " + meta + " Crop:" + getCropDrops() + " Seed: "+ getSeedDrops());
		//TODO Temp Compost will end up being plant tonic
		ItemStack stack = player.getCurrentEquippedItem();
		if (stack != null && !(meta >= 8)) {
			if (stack.getItem() == BLItemRegistry.materialsBL && stack.getItemDamage() == EnumMaterialsBL.COMPOST.ordinal()) {
				if (ItemDye.applyBonemeal(stack, world, x, y, z, player))
					if (!world.isRemote)
						world.playAuxSFX(2005, x, y, z, 0);
				return true;
			}
		}
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta < 7) {
			if (meta == 6)
				meta = 5;
			return iconArray[meta >> 1];
		} else if (meta == 8)
			return decayedTexture;
		else
			return iconArray[3];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		iconArray = new IIcon[4];
		decayedTexture = iconRegister.registerIcon("thebetweenlands:" + type + "Decay");
		for (int i = 0; i < iconArray.length; ++i)
			iconArray[i] = iconRegister.registerIcon("thebetweenlands:" + type + i);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}
}