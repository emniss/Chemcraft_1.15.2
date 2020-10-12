package em_niss.chemcraft.recipes.electrolyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ElectrolyzerRecipe implements IElectrolyzerRecipe
{
	private final ResourceLocation id;
	private final ItemStack input1;
	private final ItemStack input2;
	private final ItemStack output1;
	private final ItemStack output2;
	private final int requiredEnergy;
	
	public ElectrolyzerRecipe(ResourceLocation id, ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, int requiredEnergy)
	{
		this.id = id;
		this.input1 = input1;
		this.input2 = input2;
		this.output1 = output1;
		this.output2 = output2;
		this.requiredEnergy = requiredEnergy;
	}
	
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn)
	{
		/*if( (this.input1.test(inv.getStackInSlot(TileElectrolyzer.inSlot1)) && this.input2.test(inv.getStackInSlot(TileElectrolyzer.inSlot2)))
				|| (this.input1.test(inv.getStackInSlot(TileElectrolyzer.inSlot2)) && this.input2.test(inv.getStackInSlot(TileElectrolyzer.inSlot1))) )
		{
			return true;
		}*/
		
		if (this.input1.getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot1).getItem()) && this.input2.getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot2).getItem()))
		{
			if (this.input1.getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot1).getCount() && this.input2.getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot2).getCount())
			{
				return true;
			}
		}
		else if (this.input1.getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot2).getItem()) && this.input2.getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot1).getItem()))
		{
			if (this.input1.getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot2).getCount() && this.input2.getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot1).getCount())
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(RecipeWrapper inv) 
	{
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() 
	{
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() 
	{
		return RecipeSerializerInit.ELECTROLYZER_SERIALIZER.get();
	}

	public ItemStack getInput1() { return this.input1; }
	public ItemStack getInput2() { return this.input2; }
	public List<ItemStack> getInputs() { return new ArrayList<>(Arrays.asList(this.input1, this.input2)); }
				
	public ItemStack getOutput1() { return this.output1; }
	public ItemStack getOutput2() { return this.output2; }
	public List<ItemStack> getOutputs() { return new ArrayList<>(Arrays.asList(this.output1, this.output2)); }
	
	public int getRequiredEnergy() { return this.requiredEnergy; }
	
	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		return NonNullList.from(null);
	}


	@Override
	public ItemStack getRecipeOutput() 
	{
		return ItemStack.EMPTY;
	}
}
