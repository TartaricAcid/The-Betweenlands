package thebetweenlands.common.item.tools;

import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import thebetweenlands.api.item.ICorrodible;
import thebetweenlands.common.item.corrosion.CorrosionHelper;


public class ItemBLAxe extends ItemAxe implements ICorrodible {
	public ItemBLAxe(ToolMaterial material) {
		super(material, 5.0F + material.getDamageVsEntity(), -3.2F);

		CorrosionHelper.addCorrosionPropertyOverrides(this);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		float str = material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
		str = CorrosionHelper.getStrVsBlock(str, stack, state);
		return str; 
	}
	
	@Override
	public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) {
		return CorrosionHelper.shouldCauseBlockBreakReset(oldStack, newStack);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return CorrosionHelper.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity holder, int slot, boolean isHeldItem) {
		CorrosionHelper.onUpdate(itemStack, world, holder, slot, isHeldItem);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        return CorrosionHelper.getAttributeModifiers(super.getAttributeModifiers(slot, stack), slot, stack, ItemTool.ATTACK_DAMAGE_MODIFIER, this.damageVsEntity);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> lines, boolean advancedItemTooltips) {
		CorrosionHelper.addInformation(itemStack, player, lines, advancedItemTooltips);
	}
}
