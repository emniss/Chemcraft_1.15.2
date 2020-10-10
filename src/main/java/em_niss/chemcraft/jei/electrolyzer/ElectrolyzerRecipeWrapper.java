package em_niss.chemcraft.jei.electrolyzer;

import java.util.List;

import net.minecraft.item.ItemStack;

public class ElectrolyzerRecipeWrapper
{
	private List<ItemStack> inputs;
	private List<ItemStack> outputs;
	
	public ElectrolyzerRecipeWrapper(List<ItemStack> inputs, List<ItemStack> outputs)
	{
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public List<ItemStack> getInputs()
	{
		return inputs;
	}
	
	public List<ItemStack> getOutputs()
	{
		return outputs;
	}
}
