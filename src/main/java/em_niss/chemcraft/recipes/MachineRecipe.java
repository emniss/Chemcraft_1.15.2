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
	protected final int energyPerTick;
	
	protected List<ItemStack> inputs;
	protected List<ItemStack> outputs;
	
	private final ResourceLocation recipeTypeId;
	private final IRecipeSerializer<?> recipeSerializer;
	
	public MachineRecipe(ResourceLocation id, List<ItemStack> inputs, List<ItemStack> outputs, ResourceLocation recipeTypeId, int requiredEnergy, int energyPerTick, IRecipeSerializer<?> recipeSerializer)
	{
		this.id = id;
		this.requiredEnergy = requiredEnergy;
		this.energyPerTick = energyPerTick;
		this.recipeTypeId = recipeTypeId;
		this.recipeSerializer = recipeSerializer;
		
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public int getRequiredEnergy() { return this.requiredEnergy; }
	public int getEnergyPerTick() { return this.energyPerTick; }
	
	public List<ItemStack> getInputs() { return this.inputs; }
	public List<ItemStack> getOutputs() { return this.outputs; }
	

	@Override
	public abstract boolean matches(RecipeWrapper inv, World worldIn);
	
	
	protected boolean findMatches(RecipeWrapper inv, List<Integer> inSlots)
	{
		boolean[] foundInputMatches = new boolean[this.inputs.size()];
		
		for (int i = 0; i < inSlots.size(); i++)
		{
			ItemStack invStack = inv.getStackInSlot(inSlots.get(i));
			for (int j = 0; j < inputs.size(); j++)
			{
				if (invStack.getItem().equals(inputs.get(j).getItem()) && invStack.getCount() >= inputs.get(j).getCount())
				{
					foundInputMatches[j] = true;
				}
			}
		}
		
		boolean isMatch = true;
		for (boolean match : foundInputMatches) { if (!match) {isMatch = false; } }
		
		return isMatch;
	}
	
	
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
