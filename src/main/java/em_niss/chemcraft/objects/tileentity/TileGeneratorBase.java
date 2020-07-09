package em_niss.chemcraft.objects.tileentity;

import java.util.concurrent.atomic.AtomicInteger;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.energy.CustomEnergyStorage;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.energy.CapabilityEnergy;

public abstract class TileGeneratorBase extends TileMachineBase implements ITickableTileEntity, INamedContainerProvider
{
	public TileGeneratorBase(TileEntityType<?> tileEntityType, int inventorySize, int maxEnergyStored, int frontEnergyBarHeight, int cookTimeTotal)
	{
		super(tileEntityType, inventorySize, maxEnergyStored, frontEnergyBarHeight, cookTimeTotal);
	}
	

	@Override
	public void tick() 
	{
		super.tick();
		sendOutPower();
	}
	
	private void sendOutPower()
	{
		energy.ifPresent(energy -> {
			AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());
			if (capacity.get() > 0)
			{
				for (Direction direction : Direction.values())
				{
					TileEntity te = world.getTileEntity(pos.offset(direction));
					if (te != null)
					{
						boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
							if (handler.canReceive())
							{
								int received = handler.receiveEnergy(Math.min(capacity.get(), Config.ELECTROLYZER_SEND.get()), false);
								capacity.addAndGet(-received);
								((CustomEnergyStorage)energy).consumeEnergy(received);
								markDirty();
								return capacity.get() > 0;
							}
							else
							{ 
								return true; 
							}
						}).orElse(true);
						if (!doContinue)
						{
							return;
						}
					}
				}
			}
		});
	}
}
