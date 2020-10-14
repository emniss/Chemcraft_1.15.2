package em_niss.chemcraft.recipes.electrolyzer;

import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonObject;

import em_niss.chemcraft.recipes.MachineRecipeSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;


public class ElectrolyzerRecipeSerializer extends MachineRecipeSerializer<ElectrolyzerRecipe>
{
	public static final boolean hasDynamicConsumption = false;
	
	
	public ElectrolyzerRecipeSerializer()
	{
		super(hasDynamicConsumption);
	}

	@Override
	public ElectrolyzerRecipe read(ResourceLocation recipeId, JsonObject json) 
	{
		List<ItemStack> inputs = getItemStacks(recipeId, json, "input");
		List<ItemStack> outputs = getItemStacks(recipeId, json, "output");
		
		int energy = getEnergy(recipeId, json);
		
		return new ElectrolyzerRecipe(recipeId, inputs, outputs, energy);
	}

	@Override
	public ElectrolyzerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
	{
		List<ItemStack> inputs = Arrays.asList(buffer.readItemStack(), buffer.readItemStack());
		List<ItemStack> outputs = Arrays.asList(buffer.readItemStack(), buffer.readItemStack());
		
		int energy = buffer.readInt();
		
		return new ElectrolyzerRecipe(recipeId, inputs, outputs, energy);
	}
}
