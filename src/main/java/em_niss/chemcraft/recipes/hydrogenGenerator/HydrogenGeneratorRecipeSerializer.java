package em_niss.chemcraft.recipes.hydrogenGenerator;

import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonObject;

import em_niss.chemcraft.recipes.MachineRecipeSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

public class HydrogenGeneratorRecipeSerializer extends MachineRecipeSerializer<HydrogenGeneratorRecipe>
{
	public static final boolean hasDynamicConsumption = true;
	
	
	public HydrogenGeneratorRecipeSerializer()
	{
		super(hasDynamicConsumption);
	}
	
	@Override
	public HydrogenGeneratorRecipe read(ResourceLocation recipeId, JsonObject json) 
	{
		List<ItemStack> inputs = getItemStacks(recipeId, json, "input");
		List<ItemStack> outputs = getItemStacks(recipeId, json, "output");
		
		int energy = getEnergy(recipeId, json);
		int energyPerTick = getEnergyPerTick(recipeId, json);
		
		return new HydrogenGeneratorRecipe(recipeId, inputs, outputs, energy, energyPerTick);
	}

	@Override
	public HydrogenGeneratorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
	{
		List<ItemStack> inputs = Arrays.asList(buffer.readItemStack(), buffer.readItemStack());
		List<ItemStack> outputs = Arrays.asList(buffer.readItemStack());
		
		int energy = buffer.readInt();
		int energyPerTick = buffer.readInt();
		
		return new HydrogenGeneratorRecipe(recipeId, inputs, outputs, energy, energyPerTick);
	}
}
