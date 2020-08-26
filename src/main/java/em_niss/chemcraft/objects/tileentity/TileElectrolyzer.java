package em_niss.chemcraft.objects.tileentity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class TileElectrolyzer extends TileMachineBase
{
	public static final int inSlot1 = 0;
	public static final int inSlot2 = 1;
	
	public static final int outSlot1 = 2;
	public static final int outSlot2 = 3;
	
	
	public TileElectrolyzer()
	{
		
		super(ModTileEntityTypes.TILE_ELECTROLYZER.get(), 4, Config.ELECTROLYZER_MAXPOWER.get(), Config.MACHINE_RECEIVE.get(), 0, 10);
		energyConsumption = Config.ELECTROLYZER_ENERGY_CONSUMPTION.get();
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

	
	private boolean doOutput()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		ItemStack output1 = recipe.getOutput1();
		ItemStack output2 = recipe.getOutput2();
		if (itemHandler.insertItem(outSlot1, output1, true).isEmpty() && itemHandler.insertItem(outSlot2, output2, true).isEmpty())
		{
			itemHandler.insertItem(outSlot1, output1.copy(), false);
			itemHandler.insertItem(outSlot2, output2.copy(), false);
			
			return true;
		}
		else if (itemHandler.insertItem(outSlot1, output2, true).isEmpty() && itemHandler.insertItem(outSlot2, output1, true).isEmpty())
		{
			itemHandler.insertItem(outSlot1, output2.copy(), false);
			itemHandler.insertItem(outSlot2, output1.copy(), false);
			
			return true;
		}
		
		return false;
	}
	
	private void consumeIngredients()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe.getInput1().getItem().equals(itemHandler.getStackInSlot(inSlot1).getItem()))
		{	
			itemHandler.extractItem(inSlot1, recipe.getInput1().getCount(), false);
			itemHandler.extractItem(inSlot2, recipe.getInput2().getCount(), false);
		}
		else
		{
			itemHandler.extractItem(inSlot1, recipe.getInput2().getCount(), false);
			itemHandler.extractItem(inSlot2, recipe.getInput1().getCount(), false);
		}
	}
	
	protected void doRefueling()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null)
		{
			this.setRecipe(recipe);
		}
	}
	
	private void setRecipe(ElectrolyzerRecipe recipe)
	{
		requiredEnergyLeft = recipe.getRequiredEnergy();
		requiredEnergyTotal = recipe.getRequiredEnergy();
		
		recipeId = recipe.getId();
		
		isCooking = true;
	}
	
	@Nullable
	private ElectrolyzerRecipe getRecipe(ItemStack stack1, ItemStack stack2)
	{
		if (stack1 == null || stack2 == null)
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
		
	private boolean recipeStillValid()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null && recipe.getId().equals(recipeId))
		{
			return true;
		}
		return false;
	}
}
