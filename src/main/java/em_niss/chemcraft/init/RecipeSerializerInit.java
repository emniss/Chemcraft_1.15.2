package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipeSerializer;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipe;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipeSerializer;
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
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
			ForgeRegistries.RECIPE_SERIALIZERS, Chemcraft.MODID);
	
	//Electrolyzer
	public static final IRecipeSerializer<ElectrolyzerRecipe> ELECTROLYZER_RECIPE_SERIALIZER = new ElectrolyzerRecipeSerializer();
	public static final IRecipeType<ElectrolyzerRecipe> ELECTROLYZER_TYPE = registerType(ElectrolyzerRecipe.RECIPE_TYPE_ID);
	public static final RegistryObject<IRecipeSerializer<?>> ELECTROLYZER_SERIALIZER = RECIPE_SERIALIZERS.register("electrolyzer", () -> ELECTROLYZER_RECIPE_SERIALIZER);
	
	//HydrogenGenerator
	public static final IRecipeSerializer<HydrogenGeneratorRecipe> HYDROGEN_GENERATOR_RECIPE_SERIALIZER = new HydrogenGeneratorRecipeSerializer();
	public static final IRecipeType<HydrogenGeneratorRecipe> HYDROGEN_GENERATOR_TYPE = registerType(HydrogenGeneratorRecipe.RECIPE_TYPE_ID);
	public static final RegistryObject<IRecipeSerializer<?>> HYDROGEN_GENERATOR_SERIALIZER = RECIPE_SERIALIZERS.register("hydrogen_generator", () -> HYDROGEN_GENERATOR_RECIPE_SERIALIZER);

	
	
	
	
	@SuppressWarnings("unchecked")
	private static <T extends IRecipeType<?>> T registerType(ResourceLocation recipeTypeId) 
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
