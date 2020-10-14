package em_niss.chemcraft.objects.tileentity;

import java.util.Set;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class TileHydrogenGenerator extends TileGeneratorBase
{
	public static final int inSlot1 = 0;
	public static final int inSlot2 = 1;
	
	private static final int outSlot = 2;

	//private ItemStack result;
	
	public TileHydrogenGenerator()
	{
		super(ModTileEntityTypes.TILE_HYDROGEN_GENERATOR.get(), 3, Config.HYDROGEN_GENERATOR_MAXPOWER.get(), 10);
	}
	
	protected void doCooking()
	{
		if (recipeStillValid())
		{
			if (requiredEnergyLeft > 0)
			{
				int energyToCreate = (requiredEnergyLeft < energyGenerationPerTick) ? requiredEnergyLeft : energyGenerationPerTick;
				int energyNotCreated = this.energyStorage.addEnergy(energyToCreate);
				
				requiredEnergyLeft = requiredEnergyLeft - energyToCreate + energyNotCreated;
				
				markDirty();
			}
			else if (doOutput())
			{
				consumeIngredients();
				clearRecipe();
				
				markDirty();
			}
		}
		else
		{
			clearRecipe();
			
			markDirty();
		}
	}

	
	private boolean doOutput()
	{
		HydrogenGeneratorRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));	
		ItemStack output = recipe.getOutputs().get(0);
		
		if (itemHandler.insertItem(outSlot, output.copy(), true).isEmpty())
		{
			itemHandler.insertItem(outSlot, output.copy(), false);
			
			return true;
		}
		
		return false;
	}
	
	private void consumeIngredients()
	{
		HydrogenGeneratorRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe.getInputs().get(0).getItem().equals(itemHandler.getStackInSlot(inSlot1).getItem()))
		{
			itemHandler.extractItem(inSlot1, recipe.getInputs().get(0).getCount(), false);
			itemHandler.extractItem(inSlot2, recipe.getInputs().get(1).getCount(), false);
		}
		else
		{
			itemHandler.extractItem(inSlot1, recipe.getInputs().get(1).getCount(), false);
			itemHandler.extractItem(inSlot2, recipe.getInputs().get(0).getCount(), false);
		}
	}
	
	protected void doRefueling()
	{
		HydrogenGeneratorRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null)
		{
			this.setRecipe(recipe);
		}
	}
	
	private void setRecipe(HydrogenGeneratorRecipe recipe)
	{
		requiredEnergyLeft = recipe.getRequiredEnergy();
		requiredEnergyTotal = recipe.getRequiredEnergy();
		
		energyGenerationPerTick = recipe.getEnergyPerTick();
		
		recipeId = recipe.getId();
		
		isCooking = true;
	}
	
	@Nullable
	private HydrogenGeneratorRecipe getRecipe(ItemStack stack1, ItemStack stack2)
	{
		if (stack1 == null || stack2 == null)
		{
			return null;
		}
		
		Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.HYDROGEN_GENERATOR_TYPE, this.world);
		for (IRecipe<?> iRecipe : recipes)
		{
			HydrogenGeneratorRecipe recipe = (HydrogenGeneratorRecipe) iRecipe;
			if (recipe.matches(new RecipeWrapper(itemHandler), this.world))
			{
				return recipe;
			}
		}
		return null;
	}
	
	private boolean recipeStillValid()
	{
		HydrogenGeneratorRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null && recipe.getId().equals(recipeId))
		{
			return true;
		}
		return false;
	}
}
