package em_niss.chemcraft.recipes.electrolyzer;

import em_niss.chemcraft.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ElectrolyzerRecipes
{
	public static final ElectrolyzerRecipe[] electrolyzerRecipes = {
		new ElectrolyzerRecipe(ItemInit.TEST_TUBE_WATER.get(), 2, ItemInit.TEST_TUBE_HYDROGEN.get(), 2, ItemInit.TEST_TUBE_OXYGEN.get(), 1, 48400),
		new ElectrolyzerRecipe(ItemInit.TEST_TUBE_HYDROGEN_CHLORIDE.get(), 2, ItemInit.TEST_TUBE_HYDROGEN.get(), 1, ItemInit.TEST_TUBE_CHLORINE.get(), 1, 18500),
		new ElectrolyzerRecipe(ItemInit.TEST_TUBE_ALUMINIUM_OXIDE.get(), 1, ItemInit.POWDER_ALUMINIUM.get(), 2, 168000),
		new ElectrolyzerRecipe(ItemInit.POWDER_CHALCOPYRITE.get(), 1, ItemInit.TEST_TUBE_SULFURIC_ACID.get(), 1, ItemInit.POWDER_COPPER.get(), 2, ItemInit.TEST_TUBE_ANODE_MUD.get(), 1, 149000),
		new ElectrolyzerRecipe(ItemInit.CRUCIBLE_LITHIUM_CARBONATE_MOLTEN.get(), 1, ItemStack.EMPTY.getItem(), ItemStack.EMPTY.getCount(), ItemInit.POWDER_LITHIUM.get(), 1, ItemInit.CRUCIBLE.get(), 1, 10000),
		new ElectrolyzerRecipe(ItemInit.CRUCIBLE_BORON_TRICHLORIDE_MOLTEN.get(), 1, ItemStack.EMPTY.getItem(), ItemStack.EMPTY.getCount(), ItemInit.POWDER_BORON.get(), 1, ItemInit.CRUCIBLE.get(), 1, 10000)
	};
	
	
	
	public static ElectrolyzerRecipe getRecipe(Item input1, Item input2)
	{
		//if (input1 == input2) return getRecipe(input1);
		
		for (int i = 0; i < electrolyzerRecipes.length; i++)
		{
			if (electrolyzerRecipes[i].getInput1().getItem().equals(input1) && electrolyzerRecipes[i].getInput2().getItem().equals(input2))
			{
				return electrolyzerRecipes[i];
			}
			else if (electrolyzerRecipes[i].getInput1().getItem().equals(input2) && electrolyzerRecipes[i].getInput2().getItem().equals(input1))
			{
				ElectrolyzerRecipe recipe = electrolyzerRecipes[i];
				return new ElectrolyzerRecipe(recipe.getInput2(), recipe.getInput1(), recipe.getOutput1(), recipe.getOutput2(), recipe.getEnergyRequiered());
			}
		}
		return null;
	}
	
	public static ElectrolyzerRecipe getRecipe(Item input)
	{
		return getRecipe(input, ItemStack.EMPTY.getItem());
		/*ElectrolyzerRecipe[] electrolyzerRecipes = ElectrolyzerRecipes.electrolyzerRecipes;
		
		for (int i = 0; i < electrolyzerRecipes.length; i++)
		{
			if (electrolyzerRecipes[i].getInput1().getItem().equals(ItemStack.EMPTY.getItem()));
			{
				return electrolyzerRecipes[i];
			}
		}
		return null;*/
	}
	
	/*public static ElectrolyzerRecipe getRecipe(Item input1, Item input2)
	{
		if (input1 == input2) return getRecipe(input1);
		
		for (int i = 0; i < electrolyzerRecipes.length; i++)
		{
			if (electrolyzerRecipes[i].getCode().equals(input1.getRegistryName() + ";" + input2.getRegistryName()))
			{
				return electrolyzerRecipes[i];
			}
			else if (electrolyzerRecipes[i].getCode().equals(input2.getRegistryName() + ";" + input1.getRegistryName()))
			{
				ElectrolyzerRecipe recipe = electrolyzerRecipes[i];
				return new ElectrolyzerRecipe(recipe.getInput2(), recipe.getInput1(), recipe.getOutput1(), recipe.getOutput2(), recipe.getEnergyRequiered());
			}
		}
		return null;
	}
	
	public static ElectrolyzerRecipe getRecipe(Item input)
	{
		for (int i = 0; i < electrolyzerRecipes.length; i++)
		{
			if (electrolyzerRecipes[i].getCode().equals(input.getRegistryName() + ";" + ItemStack.EMPTY.getRe()));
			{
				return electrolyzerRecipes[i];
			}
		}
		return null;
	}
	*/
	public static ElectrolyzerRecipe[] getRecipes()
	{
		return electrolyzerRecipes;
	}
}
