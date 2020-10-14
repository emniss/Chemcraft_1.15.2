package em_niss.chemcraft.recipes.electrolyzer;

import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import em_niss.chemcraft.recipes.MachineRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ElectrolyzerRecipe extends MachineRecipe
{
	public static final ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(Chemcraft.MODID, "electrolyzer");
	
	
	public ElectrolyzerRecipe(ResourceLocation id, List<ItemStack> inputs, List<ItemStack> outputs, int requiredEnergy)
	{
		super(id, RECIPE_TYPE_ID, requiredEnergy, Config.ELECTROLYZER_ENERGY_CONSUMPTION.get(), RecipeSerializerInit.ELECTROLYZER_SERIALIZER.get());

		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn)
	{
		/*if( (this.inputs.get(0).test(inv.getStackInSlot(TileElectrolyzer.inSlot1)) && this.inputs.get(1).test(inv.getStackInSlot(TileElectrolyzer.inSlot2)))
				|| (this.inputs.get(0).test(inv.getStackInSlot(TileElectrolyzer.inSlot2)) && this.inputs.get(1).test(inv.getStackInSlot(TileElectrolyzer.inSlot1))) )
		{
			return true;
		}*/
		
		if (this.inputs.get(0).getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot1).getItem()) && this.inputs.get(1).getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot2).getItem()))
		{
			if (this.inputs.get(0).getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot1).getCount() && this.inputs.get(1).getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot2).getCount())
			{
				return true;
			}
		}
		else if (this.inputs.get(0).getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot2).getItem()) && this.inputs.get(1).getItem().equals(inv.getStackInSlot(TileElectrolyzer.inSlot1).getItem()))
		{
			if (this.inputs.get(0).getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot2).getCount() && this.inputs.get(1).getCount() <= inv.getStackInSlot(TileElectrolyzer.inSlot1).getCount())
			{
				return true;
			}
		}
		return false;
	}


	//public ItemStack getinputs.get(0)() { return this.inputs.get(0); }
	//public ItemStack getinputs.get(1)() { return this.inputs.get(1); }
	public List<ItemStack> getInputs() { return inputs; }//return new ArrayList<>(Arrays.asList(this.inputs.get(0), this.inputs.get(1))); }
				
	//public ItemStack getOutput1() { return this.output1; }
	//public ItemStack getOutput2() { return this.output2; }
	public List<ItemStack> getOutputs() { return outputs; }//new ArrayList<>(Arrays.asList(this.output1, this.output2)); }
}
