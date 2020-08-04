package em_niss.chemcraft.recipes.lists;

import em_niss.chemcraft.init.ItemInit;
import em_niss.chemcraft.recipes.types.HydrogenGeneratorRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class HydrogenGeneratorRecipes
{
	private static HydrogenGeneratorRecipe[] hydrogenGeneratorRecipes = {
			new HydrogenGeneratorRecipe(ItemInit.TEST_TUBE_HYDROGEN.get(), 2, ItemInit.TEST_TUBE_OXYGEN.get(), 1, ItemInit.TEST_TUBE_WATER.get(), 2, 10, 24200),
			new HydrogenGeneratorRecipe(ItemInit.TEST_TUBE_OXYHYDROGEN.get(), 1, ItemInit.TEST_TUBE_WATER.get(), 2, 10, 24200)
	};
	
	
	public static HydrogenGeneratorRecipe getRecipe(Item input1, Item input2)
	{
		if (input1 == input2) return getRecipe(input1);
		
		for (int i = 0; i < hydrogenGeneratorRecipes.length; i++)
		{
			if (hydrogenGeneratorRecipes[i].getInput1().getItem().equals(input1) && hydrogenGeneratorRecipes[i].getInput2().getItem().equals(input2))
			{
				return hydrogenGeneratorRecipes[i];
			}
			else if (hydrogenGeneratorRecipes[i].getInput1().getItem().equals(input2) && hydrogenGeneratorRecipes[i].getInput2().getItem().equals(input1))
			{
				HydrogenGeneratorRecipe recipe = hydrogenGeneratorRecipes[i];
				return new HydrogenGeneratorRecipe(recipe.getInput2(), recipe.getInput1(), recipe.getOutput(), recipe.getBurnTime(), recipe.getTotalEnergy());
			}
		}
		return null;
	}
	
	public static HydrogenGeneratorRecipe getRecipe(Item input)
	{
		for (int i = 0; i < hydrogenGeneratorRecipes.length; i++)
		{
			if (hydrogenGeneratorRecipes[i].getInput1().getItem().equals(input) && hydrogenGeneratorRecipes[i].getInput2().getItem().equals(ItemStack.EMPTY.getItem()))
			{
				return hydrogenGeneratorRecipes[i];
			}
		}
		return null;
	}
}
