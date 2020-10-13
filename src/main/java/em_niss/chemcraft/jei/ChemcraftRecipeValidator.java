/*package em_niss.chemcraft.jei;

import java.util.ArrayList;
import java.util.List;

import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.crafting.RecipeManager;

public class ChemcraftRecipeValidator
{
	public static class Results
	{
		private final List<ElectrolyzerRecipe> electrolyzerRecipes = new ArrayList<>();
		
		public List<ElectrolyzerRecipe> getElectrolyzerRecipes()
		{
			return electrolyzerRecipes;
		}
	}
	
	
	private ChemcraftRecipeValidator()
	{
		
	}
	
	
	public static Results getValidRecipes(IRecipeCategory<ElectrolyzerRecipe> electrolyzerCategory)
	{
		CategoryRecipeValidator<ElectrolyzerRecipe> electrolyzerRecipesValidator = new CategoryRecipeValidator<>(electrolyzerCategory, 2);
		
		Results results = new Results();
		ClientWorld world = Minecraft.getInstance().world;
		RecipeManager recipeManager = world.getRecipeManager();
		
		for (ElectrolyzerRecipe recipe : getRecipes(recipeManager, RecipeSerializerInit.ELECTROLYZER_TYPE))
		{
			
		}
	}
}*/
