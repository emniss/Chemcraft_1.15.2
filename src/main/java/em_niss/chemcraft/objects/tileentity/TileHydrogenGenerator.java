package em_niss.chemcraft.objects.tileentity;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.recipes.lists.HydrogenGeneratorRecipes;
import em_niss.chemcraft.recipes.types.HydrogenGeneratorRecipe;
import net.minecraft.item.ItemStack;

public class TileHydrogenGenerator extends TileGeneratorBase
{
	private static final int inSlot1 = 0;
	private static final int inSlot2 = 1;
	
	private static final int outSlot = 2;
	
	private ItemStack ingredient1;
	private ItemStack ingredient2;
	private ItemStack result;
	
	public TileHydrogenGenerator()
	{
		super(ModTileEntityTypes.TILE_HYDROGEN_GENERATOR.get(), 3, Config.HYDROGEN_GENERATOR_MAXPOWER.get(), 10);
	}
	
	protected void doCooking()
	{
		if (cookTime > 0 && energyStorage.getEnergyStored() + energyGeneration <= energyStorage.getMaxEnergyStored() && recipeStillValid())
		{
			energyStorage.addEnergy(energyGeneration);
			cookTime--;
		}
		else if (cookTime == 0) //Finished cooking
		{
			if (itemHandler.insertItem(outSlot, result, true).isEmpty())
			{
				//Outputslot empty
				itemHandler.insertItem(outSlot, result, false);
		
				itemHandler.extractItem(inSlot1, ingredient1.getCount(), false);
				itemHandler.extractItem(inSlot2, ingredient2.getCount(), false);
				
				isCooking = false;
			}		
		}
	}

	
	protected CustomEnergyStorage createEnergy()
	{
		return new CustomEnergyStorage(100000, 0, 1000) {
		//return new CustomEnergyStorage(maxEnergyStored, 0) {
			@Override
			protected void onEnergyChanged() { markDirty(); }
		};
	}
	
	protected void doRefueling()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		if (!input1.isEmpty() && !input2.isEmpty() && isItemsIngredients(input1, input2))
		{
			HydrogenGeneratorRecipe recipe = HydrogenGeneratorRecipes.getRecipe(input1.getItem(), input2.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount() && input2.getCount() >= recipe.getInput2().getCount()) 
			{
				setRecipe(recipe);
			}
		}
		else if (!input1.isEmpty() && isItemIngredient(input1))
		{
			HydrogenGeneratorRecipe recipe = HydrogenGeneratorRecipes.getRecipe(input1.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount())
			{
				setRecipe(recipe);
			}
		}
		else if (!input1.isEmpty() && isItemIngredient(input2))
		{
			HydrogenGeneratorRecipe recipe = HydrogenGeneratorRecipes.getRecipe(input2.getItem());
			if (input2.getCount() >= recipe.getInput1().getCount())
			{
				setRecipe(recipe);
			}
		}
	}
	
	private void setRecipe(HydrogenGeneratorRecipe recipe)
	{
		cookTime = recipe.getBurnTime();
		cookTimeTotal = recipe.getBurnTime();
		energyGeneration = recipe.getEnergyGeneration();
		
		ingredient1 = new ItemStack(recipe.getInput1().getItem(), recipe.getInput1().getCount());
		ingredient2 = new ItemStack(recipe.getInput2().getItem(), recipe.getInput2().getCount());
		result = new ItemStack(recipe.getOutput().getItem(), recipe.getOutput().getCount());

		isCooking = true;
	}
	
	private boolean isItemsIngredients(ItemStack stack1, ItemStack stack2) 
	{
		return HydrogenGeneratorRecipes.getRecipe(stack1.getItem(), stack2.getItem()) != null;
	}
	
	private boolean isItemIngredient(ItemStack stack)
	{
		return HydrogenGeneratorRecipes.getRecipe(stack.getItem()) != null;
	}
	
	private boolean recipeStillValid()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		
		return (input1.getItem().equals(ingredient1.getItem()) && input2.getItem().equals(ingredient2.getItem())
				&& input1.getCount() >= ingredient1.getCount() && input2.getCount() >= ingredient1.getCount());
	}
}
