package em_niss.chemcraft.objects.tileentity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.ElectrolyzerRecipe;
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
	
	/*private ItemStack ingredient1;
	private ItemStack ingredient2;
	private ItemStack result1;
	private ItemStack result2;*/
	
	ResourceLocation recipeId;
	
	
	public TileElectrolyzer()
	{
		super(ModTileEntityTypes.TILE_ELECTROLYZER.get(), 4, Config.ELECTROLYZER_MAXPOWER.get(), Config.MACHINE_RECEIVE.get(), 0, 10);
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
				}
			}
			else if (doOutput()) 
			{
				consumeIngredients();
				
				clearRecipe();
			}
		}
		else
		{
			clearRecipe();	
		}
			
		
		
		/*if (recipeStillValid())
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
		}*/
	}

	
	private boolean doOutput()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (itemHandler.insertItem(outSlot1, recipe.getOutput1(), true).isEmpty() && itemHandler.insertItem(outSlot2, recipe.getOutput2(), true).isEmpty())
		{
			itemHandler.insertItem(outSlot1, recipe.getOutput1(), false);
			itemHandler.insertItem(outSlot2, recipe.getOutput2(), false);
			
			return true;
		}
		else if (itemHandler.insertItem(outSlot1, recipe.getOutput2(), true).isEmpty() && itemHandler.insertItem(outSlot2, recipe.getOutput1(), true).isEmpty())
		{
			itemHandler.insertItem(outSlot1, recipe.getOutput2(), false);
			itemHandler.insertItem(outSlot2, recipe.getOutput1(), false);
			
			return true;
		}
		
		return false;
	}
	
	private void consumeIngredients()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe.getInput1().test(itemHandler.getStackInSlot(inSlot1)))
		{
			itemHandler.extractItem(inSlot1, 1, false);
		}
	}
	
	protected void doRefueling()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null)
		{
			this.setRecipe(recipe);
		}
		
		/*ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
		ItemStack input2 = itemHandler.getStackInSlot(inSlot2);
		
		if ( (!input1.isEmpty() || !input2.isEmpty()) && isItemsIngredients(input1, input2))
		{
			ElectrolyzerRecipe recipe = ElectrolyzerRecipes.getRecipe(input1.getItem(), input2.getItem());
			if (input1.getCount() >= recipe.getInput1().getCount() && input2.getCount() >= recipe.getInput2().getCount()) 
			{
				setRecipe(recipe);
			}
		}*/
	}
	
	private void setRecipe(ElectrolyzerRecipe recipe)
	{
		requiredEnergyLeft = recipe.getRequiredEnergy();
		requiredEnergyTotal = recipe.getRequiredEnergy();
		
		recipeId = recipe.getId();
		
		isCooking = true;
		
		/*cookTime = recipe.getBurnTime();
		cookTimeTotal = recipe.getBurnTime();
		energyConsumption = recipe.getEnergyConsumption();
		
		ingredient1 = new ItemStack(recipe.getInput1().getItem(), recipe.getInput1().getCount());
		ingredient2 = new ItemStack(recipe.getInput2().getItem(), recipe.getInput2().getCount());
		result1 = new ItemStack(recipe.getOutput1().getItem(), recipe.getOutput1().getCount());
		result2 = new ItemStack(recipe.getOutput2().getItem(), recipe.getOutput2().getCount());

		isCooking = true;*/
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
	
	
	/*
	@Override
	public void tick()
	{
		boolean dirty = false;
		
		if (this.world != null && !this.world.isRemote)
		{
			if (this.world.isBlockPowered(this.getPos())) 
			{
				if (this.getRecipe(this.inventory.getStackInslot(0)) != null)
				{
					if (this.currentSmeltTime != this.maxSmeltTime)
					{
						this.currentSmeltTime++;
						dirty = true;
					}
					else
					{
						this.currentSmeltTime = 0;
						ItemStack output = this.getRecipe(this.inventory.getStackInslot(0)).getRecipeOutput();
						this.inventory.insertItem(1, output.copy(), false);
						this.inventory.decreseStackSize(0, 1);
					}
				}
			}
		}
		
		if (dirty)
		{
			this.markDirty();
		}
	}*/
	
	public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn, World world)
	{
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}
	
	@OnlyIn(Dist.CLIENT)
	public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn)
	{
		@SuppressWarnings("resource")
		ClientWorld world = Minecraft.getInstance().world;
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}
	
	public static Set<ItemStack> getAllRecipeInputs(IRecipeType<?> typeIn, World world)
	{
		Set<ItemStack> inputs = new HashSet<ItemStack>();
		Set<IRecipe<?>> recipes = findRecipesByType(typeIn, world);
		
		for (IRecipe<?> recipe : recipes)
		{
			NonNullList<Ingredient> ingredients = recipe.getIngredients();
			ingredients.forEach(ingredient -> {
				for (ItemStack stack : ingredient.getMatchingStacks())
				{
					inputs.add(stack);
				}
			});
		}
		return inputs;
	}


	private void clearRecipe()
	{
		requiredEnergyLeft = 0;
		requiredEnergyTotal = 0;
		recipeId = null;
		
		isCooking = false;
		
		/*cookTime = 0;
		cookTimeTotal = 0;
		
		ingredient1 = ItemStack.EMPTY;
		ingredient2 = ItemStack.EMPTY;
		result1 = ItemStack.EMPTY;
		result2 = ItemStack.EMPTY;*/
	}
	
	/*private boolean isItemsIngredients(ItemStack stack1, ItemStack stack2) 
	{
		return ElectrolyzerRecipes.getRecipe(stack1.getItem(), stack2.getItem()) != null;
	}*/
	
	private boolean recipeStillValid()
	{
		ElectrolyzerRecipe recipe = this.getRecipe(itemHandler.getStackInSlot(inSlot1), itemHandler.getStackInSlot(inSlot2));
		if (recipe != null && recipe.getId().equals(recipeId))
		{
			return true;
		}
		return false;
		
		/*ItemStack input1 = itemHandler.getStackInSlot(inSlot1);
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
		
		return flagInput1 && flagInput2;*/
	}
}
