package em_niss.chemcraft.recipes.hydrogenGenerator;

import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.recipes.MachineRecipe;
import em_niss.chemcraft.util.MachineInventorySlots;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class HydrogenGeneratorRecipe extends MachineRecipe
{
	public static final ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(Chemcraft.MODID, "hydrogen_generator");
	
	
	public HydrogenGeneratorRecipe(ResourceLocation id, List<ItemStack> inputs, List<ItemStack> outputs, int requiredEnergy, int energyPerTick)
	{
		super(id, inputs, outputs, RECIPE_TYPE_ID, requiredEnergy, energyPerTick, RecipeSerializerInit.HYDROGEN_GENERATOR_SERIALIZER.get());
	}
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn)
	{
		return findMatches(inv, MachineInventorySlots.HYDROGEN_GENERATOR.inSlots);
	}
}

