package em_niss.chemcraft.recipes.electrolyzer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ElectrolyzerRecipe
{
	private ItemStack input1;
	private ItemStack input2;
	private ItemStack output1;
	private ItemStack output2;
	private int energyConsumption = 20;
	private int requieredEnergy;

	public ElectrolyzerRecipe(Item input1, int sizeIn1, Item input2, int sizeIn2, Item output1, int sizeOut1, Item output2, int sizeOut2, int totalEnergy)
	{
		this.input1 = new ItemStack(input1, sizeIn1);
		this.input2 = new ItemStack(input2, sizeIn2);
		this.output1 = new ItemStack(output1, sizeOut1);
		this.output2 = new ItemStack(output2, sizeOut2);
		this.requieredEnergy = totalEnergy;
	}
	
	public ElectrolyzerRecipe(Item input, int sizeIn, Item output1, int sizeOut1, Item output2, int sizeOut2, int totalEnergy)
	{
		this.input1 = new ItemStack(input, sizeIn);
		this.input2 = ItemStack.EMPTY;
		this.output1 = new ItemStack(output1, sizeOut1);
		this.output2 = new ItemStack(output2, sizeOut2);
		this.requieredEnergy = totalEnergy;
	}

	public ElectrolyzerRecipe(Item input, int sizeIn, Item output, int sizeOut, int totalEnergy)
	{
		this.input1 = new ItemStack(input, sizeIn);
		this.input2 = ItemStack.EMPTY;
		this.output1 = new ItemStack(output, sizeOut);
		this.output2 = ItemStack.EMPTY;
		this.requieredEnergy = totalEnergy;
	}
	
	public ElectrolyzerRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, int totalEnergy)
	{
		this.input1 = input1;
		this.input2 = input2;
		this.output1 = output1;
		this.output2 = output2;
		this.requieredEnergy = totalEnergy;
	}
	
	
	/*public String getCode()
	{
		return input1.getUnlocalizedName() + ";" + input2.getUnlocalizedName();
	}*/
	
	public ItemStack getInput1() { return this.input1; }
	public ItemStack getInput2() { return this.input2; }
	public ItemStack getOutput1() { return this.output1; }
	public ItemStack getOutput2() { return this.output2; }
	public int getBurnTime() { return (this.requieredEnergy / this.energyConsumption); }
	public int getEnergyRequiered() {return this.requieredEnergy; }
	public int getEnergyConsumption() { return (int)(this.energyConsumption); }
	
	
	
	public boolean hasInput2()
	{
		return !input2.isEmpty();
	}
}
