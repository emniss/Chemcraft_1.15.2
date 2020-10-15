package em_niss.chemcraft.objects.tileentity;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipe;
import em_niss.chemcraft.util.MachineInventorySlots;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class TileHydrogenGenerator extends TileGeneratorBase<HydrogenGeneratorRecipe>
{
	public TileHydrogenGenerator()
	{
		super(ModTileEntityTypes.TILE_HYDROGEN_GENERATOR.get(), 3, Config.HYDROGEN_GENERATOR_MAXPOWER.get(), 10);
		this.inSlots = MachineInventorySlots.HYDROGEN_GENERATOR.inSlots;
		this.outSlots = MachineInventorySlots.HYDROGEN_GENERATOR.outSlots;
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
	
	@Nullable
	protected HydrogenGeneratorRecipe getRecipe(List<ItemStack> inputs)
	{
		if (inputs.isEmpty())
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
	
	protected void setRecipe(HydrogenGeneratorRecipe recipe)
	{
		requiredEnergyLeft = recipe.getRequiredEnergy();
		requiredEnergyTotal = recipe.getRequiredEnergy();
		
		energyGenerationPerTick = recipe.getEnergyPerTick();
		
		recipeId = recipe.getId();
		
		isCooking = true;
	}
}
