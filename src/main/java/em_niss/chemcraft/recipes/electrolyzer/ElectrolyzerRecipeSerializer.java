package em_niss.chemcraft.recipes.electrolyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonObject;

import em_niss.chemcraft.Chemcraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
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
		//Ingredient input1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input1"));
		//Ingredient input2 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input2"));
		//ItemStack input1 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "input1"), true);
		//ItemStack input2 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "input2"), true);
		//ItemStack output1 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output1"), true);
		//ItemStack output2 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output2"), true);
		
		List<ItemStack> inputs = getItemStacks(recipeId, json, "input");
		List<ItemStack> outputs = getItemStacks(recipeId, json, "output");
		
		int energy = getEnergy(recipeId, json);
		
		return new ElectrolyzerRecipe(recipeId, inputs, outputs, energy);
	}

	private List<ItemStack> getItemStacks(ResourceLocation recipeId, JsonObject json, String type)
	{
		List<ItemStack> itemStacks = new ArrayList<>();
		
		if (json.has(type))
		{
			itemStacks.add(CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, type), true));
			System.out.print("Has Input");
		}
		else if (json.has(type + "1"))
		{
			for (int i = 1; i <= 10; i++)
			{
				if (json.has(type + i))
				{
					itemStacks.add(CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, type + i), true));
					System.out.print("Has Input" + i);
				}
				else break;
			}
		}
		else
		{
			Chemcraft.LOGGER.debug("Recipe " + recipeId + " is missing " + type + "(s)");
		}
		return itemStacks;
	}
	
	private int getEnergy(ResourceLocation recipeId, JsonObject json)
	{
		if (json.has("energy")) 
		{
			return JSONUtils.getInt(json, "energy");
		}
		else
		{
			Chemcraft.LOGGER.debug("Recipe " + recipeId + " is missing energy-field");
			return 1;
		}
	}

	@Override
	public ElectrolyzerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
	{
		//Ingredient input1 = Ingredient.read(buffer);
		//Ingredient input2 = Ingredient.read(buffer);
		//ItemStack input1 = buffer.readItemStack();
		//ItemStack input2 = buffer.readItemStack();
		//ItemStack output1 = buffer.readItemStack();
		//ItemStack output2 = buffer.readItemStack();
		
		List<ItemStack> inputs = Arrays.asList(buffer.readItemStack(), buffer.readItemStack());
		List<ItemStack> outputs = Arrays.asList(buffer.readItemStack(), buffer.readItemStack());
		
		int energy = buffer.readInt();
		
		return new ElectrolyzerRecipe(recipeId, inputs, outputs, energy);
	}

	@Override
	public void write(PacketBuffer buffer, ElectrolyzerRecipe recipe) 
	{
		//Ingredient input1 = recipe.getIngredients().get(TileElectrolyzer.inSlot1);
		//Ingredient input2 = recipe.getIngredients().get(TileElectrolyzer.inSlot2);
		//input1.write(buffer);
		//input2.write(buffer);
		
		buffer.writeItemStack(recipe.getInputs().get(0), false);
		buffer.writeItemStack(recipe.getInputs().get(1), false);
		
		buffer.writeItemStack(recipe.getOutputs().get(0), false);
		buffer.writeItemStack(recipe.getOutputs().get(1), false);
	}
}
