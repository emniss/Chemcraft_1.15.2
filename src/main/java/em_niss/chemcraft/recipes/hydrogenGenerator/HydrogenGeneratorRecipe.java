package em_niss.chemcraft.recipes.hydrogenGenerator;

import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.objects.tileentity.TileHydrogenGenerator;
import em_niss.chemcraft.recipes.MachineRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class HydrogenGeneratorRecipe extends MachineRecipe
{
	public static final ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(Chemcraft.MODID, "hydrogen_generator");
	
	public HydrogenGeneratorRecipe(ResourceLocation id, List<ItemStack> inputs, List<ItemStack> outputs, int requiredEnergy, int energyPerTick)
	{
		super(id, RECIPE_TYPE_ID, requiredEnergy, energyPerTick, RecipeSerializerInit.HYDROGEN_GENERATOR_SERIALIZER.get());

		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn)
	{
		if (this.inputs.get(0).getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getItem()) && this.inputs.get(1).getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getItem()))
		{
			if (this.inputs.get(0).getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getCount() && this.inputs.get(1).getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getCount())
			{
				return true;
			}
		}
		else if (this.inputs.get(0).getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getItem()) && this.inputs.get(1).getItem().equals(inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getItem()))
		{
			if (this.inputs.get(0).getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot2).getCount() && this.inputs.get(1).getCount() <= inv.getStackInSlot(TileHydrogenGenerator.inSlot1).getCount())
			{
				return true;
			}
		}
		return false;
	}

	public List<ItemStack> getInputs() { return inputs; }
	
	public List<ItemStack> getOutputs() { return outputs; }
}

