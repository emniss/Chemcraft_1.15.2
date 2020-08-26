package em_niss.chemcraft.recipes;

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
	private Ingredient input1;
	private Ingredient input2;
	private final ItemStack output1;
	private final ItemStack output2;
	private final int requiredEnergy;
	
	public ElectrolyzerRecipe(ResourceLocation id, Ingredient input1, Ingredient input2, ItemStack output1, ItemStack output2, int requiredEnergy)
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
		if( (this.input1.test(inv.getStackInSlot(TileElectrolyzer.inSlot1)) && this.input2.test(inv.getStackInSlot(TileElectrolyzer.inSlot2)))
				|| (this.input1.test(inv.getStackInSlot(TileElectrolyzer.inSlot2)) && this.input2.test(inv.getStackInSlot(TileElectrolyzer.inSlot1))) )
		{
			return true;
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

	public Ingredient getInput1() { return this.input1; }
	public Ingredient getInput2() { return this.input2; }
	
	public ItemStack getOutput1() { return this.output1; }
	public ItemStack getOutput2() { return this.output2; }
	
	public int getRequiredEnergy() { return this.requiredEnergy; }
	
	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		return NonNullList.from(null, this.input1, this.input2);
	}


	@Override
	public ItemStack getRecipeOutput() 
	{
		return ItemStack.EMPTY;
	}
}