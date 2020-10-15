package em_niss.chemcraft.objects.tileentity;

import java.util.concurrent.atomic.AtomicInteger;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.recipes.MachineRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.energy.CapabilityEnergy;

public abstract class TileGeneratorBase<R extends MachineRecipe> extends TileMachineBase<R>
{
	protected int energyGenerationPerTick;
	
	public TileGeneratorBase(TileEntityType<?> tileEntityType, int inventorySize, int maxEnergyStored, int frontEnergyBarHeight)
	{
		super(tileEntityType, inventorySize, maxEnergyStored, 0, Config.GENERATOR_SEND.get(), frontEnergyBarHeight);
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
                	boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite()).map(handler -> {
                                if (handler.canReceive()) {
                                    int received = handler.receiveEnergy(Math.min(capacity.get(), Config.MACHINE_RECEIVE.get()), false);
                                    capacity.addAndGet(-received);
                                    energyStorage.removeEnergy(received);
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
	}
	
	@Override
	protected void clearRecipe() 
	{
		super.clearRecipe();
		energyGenerationPerTick = 0;
	}
}
