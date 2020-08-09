package em_niss.chemcraft.objects.tileentity;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipe;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipes;
import net.minecraft.item.ItemStack;

public class TileHydrogenGenerator extends TileGeneratorBase
{
	private static final int inSlot1 = 0;
	private static final int inSlot2 = 1;
	
	private static final int outSlot = 2;

	private ItemStack result;
	
	public TileHydrogenGenerator()
	{
		super(ModTileEntityTypes.TILE_HYDROGEN_GENERATOR.get(), 3, Config.HYDROGEN_GENERATOR_MAXPOWER.get(), 10);
	}
	
	protected void doCooking()
	{
		if (cookTime > 0)
		{
			if (energyStorage.getEnergyStored() + energyGeneration <= energyStorage.getMaxEnergyStored())
			{
				energyStorage.addEnergy(energyGeneration);
				cookTime--;
			}
		}
		else if (cookTime == 0)
		{
			if (itemHandler.insertItem(outSlot, result, true).isEmpty())
			{
				itemHandler.insertItem(outSlot, result, false);
				
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
		if ( (!input1.isEmpty() || !input2.isEmpty()) && isItemsIngredients(input1, input2))
		{
			HydrogenGeneratorRecipe recipe = HydrogenGeneratorRecipes.getRecipe(input1.getItem(), input2.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount() && input2.getCount() >= recipe.getInput2().getCount()) 
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
		
		itemHandler.extractItem(inSlot1, recipe.getInput1().getCount(), false);
		itemHandler.extractItem(inSlot2, recipe.getInput2().getCount(), false);
		
		result = new ItemStack(recipe.getOutput().getItem(), recipe.getOutput().getCount());

		isCooking = true;
	}
	
	private boolean isItemsIngredients(ItemStack stack1, ItemStack stack2) 
	{
		return HydrogenGeneratorRecipes.getRecipe(stack1.getItem(), stack2.getItem()) != null;
	}
}
