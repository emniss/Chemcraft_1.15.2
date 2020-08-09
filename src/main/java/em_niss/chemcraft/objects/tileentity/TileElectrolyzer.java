package em_niss.chemcraft.objects.tileentity;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipes;
import net.minecraft.item.ItemStack;

public class TileElectrolyzer extends TileMachineBase
{
	private static final int inSlot1 = 0;
	private static final int inSlot2 = 1;
	
	private static final int outSlot1 = 2;
	private static final int outSlot2 = 3;
	
	private ItemStack ingredient1;
	private ItemStack ingredient2;
	private ItemStack result1;
	private ItemStack result2;
	
	
	public TileElectrolyzer()
	{
		super(ModTileEntityTypes.TILE_ELECTROLYZER.get(), 4, Config.ELECTROLYZER_MAXPOWER.get(), 0, Config.MACHINE_RECEIVE.get(), 10);
	}
	
	
	protected CustomEnergyStorage createEnergy()
	{
		return new CustomEnergyStorage(100000, 1000, 0) {
		//return new CustomEnergyStorage(maxEnergyStored, 0) {
			@Override
			protected void onEnergyChanged() { markDirty(); }
		};
	}
	
	
	protected void doCooking()
	{
		int energyAfter = this.energyStorage.getEnergyStored() - energyConsumption;
		if (cookTime > 0 && energyAfter >= 0 && recipeStillValid())
		{
			this.energyStorage.setEnergy(energyAfter);
			cookTime--;
		}
		else if (cookTime == 0) //Finished cooking
		{
			boolean hasOutput = false;
			if (itemHandler.getStackInSlot(outSlot1).isEmpty() && itemHandler.getStackInSlot(outSlot2).isEmpty())
			{
				//Both slots empty
				itemHandler.setStackInSlot(outSlot1, result1);
				if (!result2.isEmpty()) { itemHandler.setStackInSlot(outSlot2, result2); }
				isCooking = false;
			}
			else
			{		
				//Both slots not empty
				if (itemHandler.insertItem(outSlot1, result1, true).isEmpty() && itemHandler.insertItem(outSlot2, result2, true).isEmpty())
				{
					itemHandler.insertItem(outSlot1, result1, false);
					itemHandler.insertItem(outSlot2, result2, false);
					isCooking = false;
				}
				else if (itemHandler.insertItem(outSlot1, result2, true).isEmpty() && itemHandler.insertItem(outSlot2, result1, true).isEmpty())
				{
					itemHandler.insertItem(outSlot1, result2, false);
					itemHandler.insertItem(outSlot2, result1, false);
					isCooking = false;
				}
			}
			if (hasOutput)
			{
				itemHandler.extractItem(inSlot1, ingredient1.getCount(), false);
				itemHandler.extractItem(inSlot2, ingredient2.getCount(), false);
			}
		}
	}

	
	protected void doRefueling()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		if (!input1.isEmpty() && !input2.isEmpty() && isItemsIngredients(input1, input2))
		{
			ElectrolyzerRecipe recipe = ElectrolyzerRecipes.getRecipe(input1.getItem(), input2.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount() && input2.getCount() >= recipe.getInput2().getCount()) 
			{
				setRecipe(recipe);
			}
		}
		else if (!input1.isEmpty() && isItemIngredient(input1))
		{
			ElectrolyzerRecipe recipe = ElectrolyzerRecipes.getRecipe(input1.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount())
			{
				setRecipe(recipe);
			}
		}
		else if (!input1.isEmpty() && isItemIngredient(input2))
		{
			ElectrolyzerRecipe recipe = ElectrolyzerRecipes.getRecipe(input2.getItem());
			if (input2.getCount() >= recipe.getInput1().getCount())
			{
				setRecipe(recipe);
			}
		}
	}
	
	private void setRecipe(ElectrolyzerRecipe recipe)
	{
		cookTime = recipe.getBurnTime();
		cookTimeTotal = recipe.getBurnTime();
		energyConsumption = recipe.getEnergyConsumption();
		
		ingredient1 = new ItemStack(recipe.getInput1().getItem(), recipe.getInput1().getCount());
		ingredient2 = new ItemStack(recipe.getInput2().getItem(), recipe.getInput2().getCount());
		result1 = new ItemStack(recipe.getOutput1().getItem(), recipe.getOutput1().getCount());
		result2 = new ItemStack(recipe.getOutput2().getItem(), recipe.getOutput2().getCount());

		isCooking = true;
	}
	
	private boolean isItemsIngredients(ItemStack stack1, ItemStack stack2) 
	{
		return ElectrolyzerRecipes.getRecipe(stack1.getItem(), stack2.getItem()) != null;
	}
	
	private boolean isItemIngredient(ItemStack stack)
	{
		return ElectrolyzerRecipes.getRecipe(stack.getItem()) != null;
	}
	
	private boolean recipeStillValid()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		
		return (input1.getItem().equals(ingredient1.getItem()) && input2.getItem().equals(ingredient2.getItem())
				&& input1.getCount() >= ingredient1.getCount() && input2.getCount() >= ingredient1.getCount());
	}
}
