package em_niss.chemcraft.objects.tileentity;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import em_niss.chemcraft.util.MachineInventorySlots;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class TileElectrolyzer extends TileMachineBase<ElectrolyzerRecipe>
{
	public TileElectrolyzer()
	{
		super(ModTileEntityTypes.TILE_ELECTROLYZER.get(), 4, Config.ELECTROLYZER_MAXPOWER.get(), Config.MACHINE_RECEIVE.get(), 0, 10);
		energyConsumption = Config.ELECTROLYZER_ENERGY_CONSUMPTION.get();
		
		this.inSlots = MachineInventorySlots.ELECTROLYZER.inSlots;
		this.outSlots = MachineInventorySlots.ELECTROLYZER.outSlots;
	}
	
	
	protected void doCooking()
	{
		if (recipeStillValid())
		{
			if (requiredEnergyLeft > 0) 
			{
				int energyToConsume = (requiredEnergyLeft < energyConsumption) ? requiredEnergyLeft : energyConsumption;
			
				if (this.energyStorage.consumeEnergy(energyToConsume))
				{
					requiredEnergyLeft -= energyToConsume;
					markDirty();
				}
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
	protected ElectrolyzerRecipe getRecipe(List<ItemStack> inputs)
	{
		if (inputs.isEmpty())
		{
			return null;
		}
		
		Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.ELECTROLYZER_TYPE, this.world);
		for (IRecipe<?> iRecipe : recipes)
		{
			ElectrolyzerRecipe recipe = (ElectrolyzerRecipe) iRecipe;
			if (recipe.matches(new RecipeWrapper(itemHandler), this.world))
			{
				return recipe;
			}
		}
		return null;
	}
	
	protected void setRecipe(ElectrolyzerRecipe recipe)
	{
		requiredEnergyLeft = recipe.getRequiredEnergy();
		requiredEnergyTotal = recipe.getRequiredEnergy();
		
		recipeId = recipe.getId();
		
		isCooking = true;
	}
}
