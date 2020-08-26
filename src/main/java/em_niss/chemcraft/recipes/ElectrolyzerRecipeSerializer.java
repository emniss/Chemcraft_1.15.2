package em_niss.chemcraft.recipes;

import com.google.gson.JsonObject;

import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ElectrolyzerRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ElectrolyzerRecipe>
{

	@Override
	public ElectrolyzerRecipe read(ResourceLocation recipeId, JsonObject json) 
	{
		Ingredient input1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input1"));
		Ingredient input2 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input2"));
		ItemStack output1 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output1"), true);
		ItemStack output2 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output2"), true);
		
		int energy = JSONUtils.getInt(json, "energy");
		
		return new ElectrolyzerRecipe(recipeId, input1, input2, output1, output2, energy);
	}

	@Override
	public ElectrolyzerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
	{
		Ingredient input1 = Ingredient.read(buffer);
		Ingredient input2 = Ingredient.read(buffer);
		ItemStack output1 = buffer.readItemStack();
		ItemStack output2 = buffer.readItemStack();
		
		int energy = buffer.readInt();
		
		return new ElectrolyzerRecipe(recipeId, input1, input2, output1, output2, energy);
	}

	@Override
	public void write(PacketBuffer buffer, ElectrolyzerRecipe recipe) 
	{
		Ingredient input1 = recipe.getIngredients().get(TileElectrolyzer.inSlot1);
		Ingredient input2 = recipe.getIngredients().get(TileElectrolyzer.inSlot2);
		input1.write(buffer);
		input2.write(buffer);
		
		buffer.writeItemStack(recipe.getOutput1(), false);
		buffer.writeItemStack(recipe.getOutput2(), false);
	}
}