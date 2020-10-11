package em_niss.chemcraft.jei.electrolyzer;

import java.util.List;

import em_niss.chemcraft.Config;
import net.minecraft.item.ItemStack;

public class ElectrolyzerRecipeWrapper
{
	private List<ItemStack> inputs;
	private List<ItemStack> outputs;
	private int energy;
	private int energyPerTick;
	
	public ElectrolyzerRecipeWrapper(List<ItemStack> inputs, List<ItemStack> outputs, int energy)
	{
		this.inputs = inputs;
		this.outputs = outputs;
		this.energy = energy;
		this.energyPerTick = Config.ELECTROLYZER_ENERGY_CONSUMPTION.get();
	}
	
	public List<ItemStack> getInputs()
	{
		return inputs;
	}
	
	public List<ItemStack> getOutputs()
	{
		return outputs;
	}
	
	public int getEnergy()
	{
		return energy;
	}
	
	public int getEnergyPerTick()
	{
		return energyPerTick;
	}
	
	public int getTime()
	{
		return energy / energyPerTick;
	}
}
