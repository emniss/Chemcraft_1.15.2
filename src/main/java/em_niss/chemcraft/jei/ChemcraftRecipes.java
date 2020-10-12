package em_niss.chemcraft.jei;

import java.util.List;
import java.util.stream.Collectors;

import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.util.ErrorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;

public class ChemcraftRecipes 
{
	/*private final RecipeManager recipeManager;
	
	public ChemcraftRecipes()
	{
		ClientWorld world = Minecraft.getInstance().world;
		ErrorUtil.checkNotNull(world, "minecraft world");
		this.recipeManager = world.getRecipeManager();
	}
	
	public List<ElectrolyzerRecipe> getElectrolyzerRecipes(IRecipeCategory<ElectrolyzerRecipe> electrolyzerCategory)
	{
		CategoryRecipeValidator<ElectrolyzerRecipe> validator = new CategoryRecipeValidator<>(electrolyzerCategory, 1);
		return getValidRecipes(recipeManager, IRecipeType.ELECTROLYZER, validator);
	}
	
	private static <C extends IInventory, T extends IRecipe<C>> List<T> getValidRecipes(RecipeManager recipeManager, IRecipeType<T> recipeType, CategoryRecipeValidator<T> validator)
	{
		return getRecipes(recipeManager, recipeType).stream().filter(validator::isRecipeValid).collect(Collectors.toList());
	}
	
	private static <C extends IInventory, T extends IRecipe<C>> Collection<T> getRecipes(RecipeManager recipeManager, IRecipeType<T> recipeType)
	{
		Map<ResourceLocation, IRecipe<C>> recipes = recipeManager.getRecipes(recipeType);
		return (Collection<T>) recipes.values();
	}*/
}
