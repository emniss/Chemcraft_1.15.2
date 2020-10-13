package em_niss.chemcraft.recipes.hydrogenGenerator;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	private final ItemStack input1;
	private final ItemStack input2;
	private final ItemStack output;
	
	private final int energyGenerationPerTick;
	
	public HydrogenGeneratorRecipe(ResourceLocation id, ItemStack input1, ItemStack input2, ItemStack output, int requiredEnergy, int energyGenerationPerTick)
	{
		super(id, RECIPE_TYPE_ID, requiredEnergy, RecipeSerializerInit.HYDROGEN_GENERATOR_SERIALIZER.get());
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
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



	public ItemStack getInput1() { return this.input1; }
	public ItemStack getInput2() { return this.input2; }
	public List<ItemStack> getInputs() { return new ArrayList<>(Arrays.asList(this.input1, this.input2)); }
	
	public ItemStack getOutput() { return this.output; }
	public List<ItemStack> getOutputs() { return new ArrayList<>(Arrays.asList(this.output)); }
		
	public int getEnergyGenerationPerTick() { return this.energyGenerationPerTick; }
}

