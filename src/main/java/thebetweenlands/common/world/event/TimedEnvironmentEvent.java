package thebetweenlands.common.world.event;

import java.util.Random;

import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

public abstract class TimedEnvironmentEvent extends EnvironmentEvent {
	public TimedEnvironmentEvent(EnvironmentEventRegistry registry) {
		super(registry);
	}

	protected int ticks = 0;
	protected int startTicks = 0;

	@Override
	public void update(World world) {
		if(!this.getRegistry().isDisabled()) {
			this.ticks--;

			if(!world.isRemote && this.ticks % 20 == 0) {
				this.setDirty(true);
			}

			if(!world.isRemote && this.ticks <= 0) {
				if(this.isActive()) {
					this.startTicks = this.ticks = this.getOffTime(world.rand);
				} else {
					this.startTicks = this.ticks = this.getOnTime(world.rand);
				}
				this.setActive(!this.isActive(), true);
			}
		}
	}

	/**
	 * Returns the time in ticks this event stays on/off
	 * @return
	 */
	public int getTicks() {
		return this.ticks;
	}

	/**
	 * Returns the maximum ticks
	 * @return
	 */
	public int getStartTicks() {
		return this.startTicks;
	}

	/**
	 * Returns how many ticks have elapsed since changing state
	 * @return
	 */
	public int getTicksElapsed() {
		return this.startTicks - this.ticks;
	}

	@Override
	public void setActive(boolean active, boolean markDirty) {
		super.setActive(active, false);
		if(!this.getWorld().isRemote) {
			if(!this.isActive()) {
				this.startTicks = this.ticks = this.getOffTime(this.getWorld().rand);
			} else {
				this.startTicks = this.ticks = this.getOnTime(this.getWorld().rand);
			}
			if(markDirty) {
				this.markDirty();
			}
		}
	}

	@Override
	public void saveEventData() {
		super.saveEventData();
		this.getData().setInteger("ticks", this.ticks);
		this.getData().setInteger("startTicks", this.startTicks);
	}

	@Override
	public void loadEventData() {
		super.loadEventData();
		this.ticks = this.getData().getInteger("ticks");
		this.startTicks = this.getData().getInteger("startTicks");
	}

	@Override
	public void loadEventPacket(PacketBuffer buffer) {
		super.loadEventPacket(buffer);
		this.ticks = buffer.readInt();
		this.startTicks = buffer.readInt();
	}

	@Override
	public void sendEventPacket(PacketBuffer buffer) {
		super.sendEventPacket(buffer);
		buffer.writeInt(this.ticks);
		buffer.writeInt(this.startTicks);
	}

	@Override
	public void setDefaults() {
		this.ticks = this.getOffTime(new Random());
	}

	/**
	 * Returns how many ticks the event is not active.
	 * @param rnd
	 * @return
	 */
	public abstract int getOffTime(Random rnd);

	/**
	 * Returns how many ticks the event is active.
	 * @param rnd
	 * @return
	 */
	public abstract int getOnTime(Random rnd);
}
