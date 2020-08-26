package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.recipes.ElectrolyzerRecipe;
import em_niss.chemcraft.recipes.ElectrolyzerRecipeSerializer;
import em_niss.chemcraft.recipes.IElectrolyzerRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit 
{
	public static final IRecipeSerializer<ElectrolyzerRecipe> ELECTROLYZER_RECIPE_SERIALIZER = new ElectrolyzerRecipeSerializer();
	public static final IRecipeType<IElectrolyzerRecipe> ELECTROLYZER_TYPE = registerType(IElectrolyzerRecipe.RECIPE_TYPE_ID);
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
			ForgeRegistries.RECIPE_SERIALIZERS, Chemcraft.MODID);
	
	public static final RegistryObject<IRecipeSerializer<?>> ELECTROLYZER_SERIALIZER = RECIPE_SERIALIZERS.register("electrolyzer", () -> ELECTROLYZER_RECIPE_SERIALIZER);

	
	
	
	
	@SuppressWarnings("unchecked")
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) 
	{
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
	
	
	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> 
	{
		@Override
		public String toString()
		{
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
}
