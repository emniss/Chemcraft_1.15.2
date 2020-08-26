package em_niss.chemcraft.recipes.hydrogenGenerator;

import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.objects.tileentity.TileHydrogenGenerator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class HydrogenGeneratorRecipe implements IHydrogenGeneratorRecipe
{
	private final ResourceLocation id;
	private final ItemStack input1;
	private final ItemStack input2;
	private final ItemStack output;
	private final int requiredEnergy;
	private final int energyGenerationPerTick;
	
	public HydrogenGeneratorRecipe(ResourceLocation id, ItemStack input1, ItemStack input2, ItemStack output, int requiredEnergy, int energyGenerationPerTick)
	{
		this.id = id;
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
		this.requiredEnergy = requiredEnergy;
		this.energyGenerationPerTick = energyGenerationPerTick;
	}
	
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn)
	{
		if (this.input1.getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getItem()) && this.input2.getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getItem()))
		{
			if (this.input1.getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getCount() && this.input2.getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getCount())
			{
				return true;
			}
		}
		else if (this.input1.getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getItem()) && this.input2.getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getItem()))
		{
			if (this.input1.getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getCount() && this.input2.getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getCount())
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
		return RecipeSerializerInit.HYDROGEN_GENERATOR_SERIALIZER.get();
	}

	public ItemStack getInput1() { return this.input1; }
	public ItemStack getInput2() { return this.input2; }
	
	public ItemStack getOutput() { return this.output; }
	
	public int getRequiredEnergy() { return this.requiredEnergy; }
	
	public int getEnergyGenerationPerTick() { return this.energyGenerationPerTick; }
	
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
