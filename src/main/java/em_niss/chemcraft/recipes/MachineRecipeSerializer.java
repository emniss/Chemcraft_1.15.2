package em_niss.chemcraft.recipes;

import java.util.ArrayList;
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

public abstract class MachineRecipeSerializer<T extends MachineRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T>
{
	protected final boolean hasDynamicConsumption;
	
	public MachineRecipeSerializer(boolean hasDynamicConsumption)
	{
		this.hasDynamicConsumption = hasDynamicConsumption;
	}
	
	@Override
	public abstract T read(ResourceLocation recipeId, JsonObject json);
	
	@Override
	public abstract T read(ResourceLocation recipeId, PacketBuffer buffer);
	
	@Override
	public void write(PacketBuffer buffer, T recipe)
	{
		for (int i = 0; i < recipe.getInputs().size(); i++)
		{
			buffer.writeItemStack(recipe.getInputs().get(i), false);
		}
		
		for (int i = 0; i < recipe.getOutputs().size(); i++)
		{
			buffer.writeItemStack(recipe.getOutputs().get(i), false);
		}
		
		buffer.writeInt(recipe.getRequiredEnergy());
		if (hasDynamicConsumption) { buffer.writeInt(recipe.getEnergyPerTick()); }
	}
	
	
	
	protected List<ItemStack> getItemStacks(ResourceLocation recipeId, JsonObject json, String type)
	{
		List<ItemStack> itemStacks = new ArrayList<>();
		
		if (json.has(type))
		{
			itemStacks.add(CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, type), true));
		}
		else if (json.has(type + "1"))
		{
			for (int i = 1; i <= 10; i++)
			{
				if (json.has(type + i))
				{
					itemStacks.add(CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, type + i), true));
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
	
	protected int getEnergy(ResourceLocation recipeId, JsonObject json)
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
	
	protected int getEnergyPerTick(ResourceLocation recipeId, JsonObject json)
	{
		if (json.has("energyPerTick")) 
		{
			return JSONUtils.getInt(json, "energyPerTick");
		}
		else
		{
			Chemcraft.LOGGER.debug("Recipe " + recipeId + " is missing energyPerTick-field");
			return 1;
		}
	}
}
