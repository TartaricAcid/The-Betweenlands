package thebetweenlands.common.capability.base;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Any entity capability that saves the data to NBT implements this interface
 */
public interface ISerializableCapability {
	/**
	 * Writes the data to the nbt
	 * @param nbt
	 */
	public void writeToNBT(NBTTagCompound nbt);

	/**
	 * Reads the data from the nbt
	 * @param nbt
	 */
	public void readFromNBT(NBTTagCompound nbt);
}