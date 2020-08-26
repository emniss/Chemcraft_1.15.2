package em_niss.chemcraft.recipes;

import javax.annotation.Nonnull;

import em_niss.chemcraft.Chemcraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IElectrolyzerRecipe extends IRecipe<RecipeWrapper>
{
	ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(Chemcraft.MODID, "electrolyzer");
	
	@Nonnull
	@Override
	default IRecipeType<?> getType()
	{
		return Registry.RECIPE_TYPE.getValue(RECIPE_TYPE_ID).get();
	}
	
	@Override
	default boolean canFit(int width, int height) 
	{
		return false;
	}
	
	ItemStack getInput1();
	
	ItemStack getInput2();
}
