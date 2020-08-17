package em_niss.chemcraft.objects.tileentity;

import em_niss.chemcraft.Config;
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
		super(ModTileEntityTypes.TILE_ELECTROLYZER.get(), 4, Config.ELECTROLYZER_MAXPOWER.get(), Config.MACHINE_RECEIVE.get(), 0, 10);
	}
	
	
	protected void doCooking()
	{
		if (recipeStillValid())
		{
			if (cookTime > 0)
			{
				if (this.energyStorage.consumeEnergy(energyConsumption))
				{
					cookTime--;
				}
			}
			
			if (cookTime == 0) //Finished cooking
			{
				if (itemHandler.insertItem(outSlot1, result1, true).isEmpty() && itemHandler.insertItem(outSlot2, result2, true).isEmpty())
				{								
					itemHandler.setStackInSlot(outSlot1, new ItemStack(result1.getItem(), result1.getCount() + itemHandler.getStackInSlot(outSlot1).getCount()));
					itemHandler.setStackInSlot(outSlot2, new ItemStack(result2.getItem(), result2.getCount() + itemHandler.getStackInSlot(outSlot2).getCount()));
					
					isCooking = false;
				}
				else if (itemHandler.insertItem(outSlot1, result2, true).isEmpty() && itemHandler.insertItem(outSlot2, result1, true).isEmpty())
				{					
					itemHandler.setStackInSlot(outSlot1, new ItemStack(result2.getItem(), result2.getCount() + itemHandler.getStackInSlot(outSlot1).getCount()));
					itemHandler.setStackInSlot(outSlot2, new ItemStack(result1.getItem(), result1.getCount() + itemHandler.getStackInSlot(outSlot2).getCount()));
					
					isCooking = false;
				}
			}
		}
		else
		{
			clearRecipe();
		}
	}

	
	protected void doRefueling()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		
		if ( (!input1.isEmpty() || !input2.isEmpty()) && isItemsIngredients(input1, input2))
		{
			ElectrolyzerRecipe recipe = ElectrolyzerRecipes.getRecipe(input1.getItem(), input2.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount() && input2.getCount() >= recipe.getInput2().getCount()) 
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
	
	private void clearRecipe()
	{
		cookTime = 0;
		cookTimeTotal = 0;
		
		ingredient1 = ItemStack.EMPTY;
		ingredient2 = ItemStack.EMPTY;
		result1 = ItemStack.EMPTY;
		result2 = ItemStack.EMPTY;
	}
	
	private boolean isItemsIngredients(ItemStack stack1, ItemStack stack2) 
	{
		return ElectrolyzerRecipes.getRecipe(stack1.getItem(), stack2.getItem()) != null;
	}
	
	private boolean recipeStillValid()
	{
		ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		
		boolean flagInput1 = false;
		boolean flagInput2 = false;
		
		if (input1.getItem().equals(ingredient1.getItem())) 
		{
			flagInput1 = input1.getCount() >= ingredient1.getCount();
		}
		
		if (input2.getItem().equals(ingredient2.getItem()))
		{
			flagInput2 = input2.getCount() >= ingredient2.getCount();
		}
		
		return flagInput1 && flagInput2;
	}
}
