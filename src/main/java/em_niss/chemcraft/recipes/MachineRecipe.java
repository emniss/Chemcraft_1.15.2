package em_niss.chemcraft.recipes;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public abstract class MachineRecipe implements IRecipe<RecipeWrapper>
{
	protected final ResourceLocation id;
	protected final int requiredEnergy;
	
	private final ResourceLocation recipeTypeId;
	private final IRecipeSerializer<?> recipeSerializer;
	
	public MachineRecipe(ResourceLocation id, ResourceLocation recipeTypeId, int requiredEnergy, IRecipeSerializer<?> recipeSerializer)
	{
		this.id = id;
		this.requiredEnergy = requiredEnergy;
		this.recipeTypeId = recipeTypeId;
		this.recipeSerializer = recipeSerializer;
	}
	
	public int getRequiredEnergy() { return this.requiredEnergy; }
	
	public abstract List<ItemStack> getInputs();
	public abstract List<ItemStack> getOutputs();
	

	@Override
	public abstract boolean matches(RecipeWrapper inv, World worldIn);
	
	@Override
	public ItemStack getCraftingResult(RecipeWrapper inv) { return ItemStack.EMPTY; }
	
	@Override
	public ResourceLocation getId() { return this.id; }
	
	@Override
	public NonNullList<Ingredient> getIngredients() { return NonNullList.from(null); }
	
	@Override
	public ItemStack getRecipeOutput() { return ItemStack.EMPTY; }
	
	@Override
	public boolean canFit(int width, int height) { return false; }
	
	@Nonnull
	@Override
	public IRecipeType<?> getType()
	{
		return Registry.RECIPE_TYPE.getValue(recipeTypeId).get();
	}
	
	@Override
	public IRecipeSerializer<?> getSerializer()
	{
		return recipeSerializer;
	}
}
