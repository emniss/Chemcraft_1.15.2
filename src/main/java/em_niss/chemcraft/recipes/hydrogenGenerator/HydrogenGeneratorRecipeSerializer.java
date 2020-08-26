package em_niss.chemcraft.recipes.hydrogenGenerator;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class HydrogenGeneratorRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<HydrogenGeneratorRecipe>
{

	@Override
	public HydrogenGeneratorRecipe read(ResourceLocation recipeId, JsonObject json) 
	{
		ItemStack input1 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "input1"), true);
		ItemStack input2 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "input2"), true);
		ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
		
		int energy = JSONUtils.getInt(json, "energy");
		int energyPerTick = JSONUtils.getInt(json, "energyPerTick");
		
		return new HydrogenGeneratorRecipe(recipeId, input1, input2, output, energy, energyPerTick);
	}

	@Override
	public HydrogenGeneratorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
	{
		ItemStack input1 = buffer.readItemStack();
		ItemStack input2 = buffer.readItemStack();
		ItemStack output = buffer.readItemStack();
		
		int energy = buffer.readInt();
		int energyPerTick = buffer.readInt();
		
		return new HydrogenGeneratorRecipe(recipeId, input1, input2, output, energy, energyPerTick);
	}

	@Override
	public void write(PacketBuffer buffer, HydrogenGeneratorRecipe recipe) 
	{
		buffer.writeItemStack(recipe.getInput1(), false);
		buffer.writeItemStack(recipe.getInput2(), false);
		
		buffer.writeItemStack(recipe.getOutput(), false);
		
		buffer.writeInt(recipe.getRequiredEnergy());
		buffer.writeInt(recipe.getEnergyGenerationPerTick());
	}
}
