package em_niss.chemcraft.energy;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT>
{
	public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract)
	{
		super(capacity, maxReceive, maxExtract);
	}
	
	protected void onEnergyChanged() {};
	
	public void setEnergy(int energy)
	{
		this.energy = energy;
		onEnergyChanged();
	}
	
	public int addEnergy(int energy)
	{
		int returnEnergy = 0;
		
		if (this.energy + energy <= getMaxEnergyStored())
		{
			this.energy += energy;
		}
		else
		{
			returnEnergy = this.energy + energy - getMaxEnergyStored();
			this.energy = getMaxEnergyStored();
		}
		onEnergyChanged();
		
		return returnEnergy;
	}
	
	public boolean consumeEnergy(int energy)
	{
		if (this.energy - energy >= 0) 
		{
			this.energy -= energy;
			onEnergyChanged();
			return true;
		}
		return false;	
	}
	
	//Used for sendOutPower() in TileGeneratorBase
	public void removeEnergy(int energy)
	{
		this.energy -= energy;
		if (this.energy < 0)
		{
			this.energy = 0;
		}
		onEnergyChanged();
	}
	
	public int getMaxExtract()
	{
		return this.maxExtract;
	}
	
	@Override
	public CompoundNBT serializeNBT()
	{
		CompoundNBT tag = new CompoundNBT();
		tag.putInt("energy", getEnergyStored());
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt)
	{		
		setEnergy(nbt.getInt("energy"));
	}
}
