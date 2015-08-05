package thebetweenlands.blocks.container;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thebetweenlands.creativetabs.ModCreativeTabs;
import thebetweenlands.tileentities.TileEntityLootPot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLootPot extends BlockContainer {

	public BlockLootPot() {
		super(Material.glass);
		setCreativeTab(ModCreativeTabs.blocks);
		setBlockName("thebetweenlands.lootPot");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.stained_hardened_clay.getIcon(side, 3);
	}

	@Override
	public int getRenderType() {
		return -1;
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
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return null;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLootPot();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack is) {
		if (world.getTileEntity(x, y, z) instanceof TileEntityLootPot) {
			TileEntityLootPot tile = (TileEntityLootPot) world.getTileEntity(x,y, z);
			if (tile != null && !world.isRemote) {
				tile.setPotModelType((byte) world.rand.nextInt(3));
				tile.setModelRotationOffset(world.rand.nextInt(41) - 20);
				world.markBlockForUpdate(x, y, z);
			}
		}
		byte rotationMeta = 0;
		int rotation = MathHelper.floor_double(entityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		if (rotation == 0)
			rotationMeta = 2;
		if (rotation == 1)
			rotationMeta = 5;
		if (rotation == 2)
			rotationMeta = 3;
		if (rotation == 3)
			rotationMeta = 4;
		world.setBlockMetadataWithNotify(x, y, z, rotationMeta, 3);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		IInventory tile = (IInventory) world.getTileEntity(x, y, z);
		if (tile != null)
			for (int i = 0; i < tile.getSizeInventory(); i++) {
				ItemStack stack = tile.getStackInSlot(i);
				if (stack != null) {
					if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
						float f = 0.7F;
						double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
						double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
						double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
						EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
						entityitem.delayBeforeCanPickup = 10;
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
		super.breakBlock(world, x, y, z, block, meta);
	}
}