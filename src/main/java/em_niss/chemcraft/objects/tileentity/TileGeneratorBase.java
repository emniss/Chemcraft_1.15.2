package em_niss.chemcraft.objects.tileentity;

import java.util.concurrent.atomic.AtomicInteger;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.energy.CapabilityEnergy;

public abstract class TileGeneratorBase extends TileMachineBase implements ITickableTileEntity
{
	protected int energyGeneration;
	
	public TileGeneratorBase(TileEntityType<?> tileEntityType, int inventorySize, int maxEnergyStored, int frontEnergyBarHeight)
	{
		super(tileEntityType, inventorySize, maxEnergyStored, frontEnergyBarHeight);
	}
	

	@Override
	public void tick() 
	{
		super.tick();
		sendOutPower();
	}
	
	private void sendOutPower()
	{
		AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if (capacity.get() > 0) {
            for (Direction direction : Direction.values()) {
                TileEntity te = world.getTileEntity(pos.offset(direction));
                if (te != null) {
                	boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                                if (handler.canReceive()) {
                                    int received = handler.receiveEnergy(Math.min(capacity.get(), 100), false);
                                    capacity.addAndGet(-received);
                                    energyStorage.consumeEnergy(received);
                                    markDirty();
                                    return capacity.get() > 0;
                                } else {
                                    return true;
                                }
                            }
                    ).orElse(true);
                    if (!doContinue) {
                        return;
                    }
                }
            }
        }
        
        /*AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
		AtomicBoolean doContinue = new AtomicBoolean(false);
		
		if (capacity.get() > 0)
		{
			for (Direction direction : Direction.values())
			{
				TileEntity te = world.getTileEntity(pos.offset(direction));
				if (te != null)	
				{
					te.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(handler -> {
						if (handler.canReceive())
						{
							int received = handler.receiveEnergy(Math.min(capacity.get(), 100), false);
                        	capacity.addAndGet(-received);
                        	energyStorage.consumeEnergy(received);
                        	markDirty();
                        	doContinue.set(capacity.get() > 0);
						}
						else
						{
							doContinue.set(true);
						}
					});
				}
				else
				{
					doContinue.set(true);
				}
				
				if (!doContinue.get()) { break; }
			}
		}*/	
		
		
		
		
    
		
		/*AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
		if (capacity.get() > 0 ) 
		{
			for (Direction direction : Direction.values())
			{
				TileEntity te = world.getTileEntity(pos.offset(direction));
				if (te != null)
				{
					boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
						if (handler.canReceive())
						{
							int received = handler.receiveEnergy(Math.min(capacity.get(), Config.HYDROGEN_GENERATOR_SEND.get()), false);
							capacity.addAndGet(-received);
							energyStorage.consumeEnergy(received);
							markDirty();
							return capacity.get() > 0;
						}
						else
						{
							return true;
						}
					}
					).orElse(true);
					if (!doContinue)
					{
						return;
					}
				}
			}
		}*/
		
		/*
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
								int received = handler.receiveEnergy(Math.min(capacity.get(), 100), false);
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
		});*/
	}
}
