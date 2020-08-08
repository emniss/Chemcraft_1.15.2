package em_niss.chemcraft.recipes.types;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HydrogenGeneratorRecipe
{
	private ItemStack input1;
	private ItemStack input2;
	private ItemStack output;
	private int burnTime;
	private int totalEnergy;
	private int energyGeneration;

	public HydrogenGeneratorRecipe(Item input1, int sizeIn1, Item input2, int sizeIn2, Item output, int sizeOut, int burnTime, int totalEnergy)
	{
		this.input1 = new ItemStack(input1, sizeIn1);
		this.input2 = new ItemStack(input2, sizeIn2);
		this.output = new ItemStack(output, sizeOut);
		this.burnTime = burnTime;
		this.totalEnergy = totalEnergy;
		this.energyGeneration = totalEnergy / burnTime;
	}
	
	public HydrogenGeneratorRecipe(Item input, int sizeIn, Item output, int sizeOut, int burnTime, int totalEnergy)
	{
		this.input1 = new ItemStack(input, sizeIn);
		this.input2 = ItemStack.EMPTY;
		this.output = new ItemStack(output, sizeOut);
		this.burnTime = burnTime;
		this.totalEnergy = totalEnergy;
		this.energyGeneration = totalEnergy / burnTime;
	}
	

	public HydrogenGeneratorRecipe(ItemStack input1, ItemStack input2, ItemStack output, int burnTime, int totalEnergy)
	{
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
		this.burnTime = burnTime;
		this.totalEnergy = totalEnergy;
		this.energyGeneration = totalEnergy / burnTime;
	}
	
	public ItemStack getInput1() { return this.input1; }
	public ItemStack getInput2() { return this.input2; }
	public ItemStack getOutput() { return this.output; }
	public int getBurnTime() { return this.burnTime; }
	public int getTotalEnergy() {return this.totalEnergy; }
	public int getEnergyGeneration() { return this.energyGeneration; }
	
	
	
	public boolean hasInput2()
	{
		return !input2.isEmpty();
	}
}
