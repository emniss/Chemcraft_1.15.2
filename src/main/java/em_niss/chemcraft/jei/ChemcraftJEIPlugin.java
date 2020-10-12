package em_niss.chemcraft.jei;

import javax.annotation.Nullable;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.jei.electrolyzer.ElectrolyzerCategory;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.util.ErrorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class ChemcraftJEIPlugin implements IModPlugin
{
	@Nullable
	private ElectrolyzerCategory electrolyzerCategory;
	
	
	@Override
	public ResourceLocation getPluginUid()
	{
		return new ResourceLocation(Chemcraft.MODID, "chemcraft");
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) 
	{
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		
		registration.addRecipeCategories(new ElectrolyzerCategory(guiHelper));
	}
	
	@Override
	public void registerRecipes(IRecipeRegistration registration)
	{
		//ChemcraftRecipes chemcraftRecipes = new ChemcraftRecipes();
		RecipeManager recipeManager = getRecipeManager();
		
		//registration.addRecipes(recipeManager.getRecipes(RecipeSerializerInit.ELECTROLYZER_TYPE).values(), ElectrolyzerCategory.Uid);
		registration.addRecipes(recipeManager.getRecipes(RecipeSerializerInit.ELECTROLYZER_TYPE).values(), ElectrolyzerCategory.Uid);
		//registration.addRecipes(new ArrayList<>(ElectrolyzerRecipe.recipeList.values()), ElectrolyzerCategory.Uid);
	}
	
	
	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
		registration.addRecipeClickArea(ScreenElectrolyzer.class, ScreenElectrolyzer.arrowPosX, ScreenElectrolyzer.arrowPosY, ScreenElectrolyzer.arrowWidth, ScreenElectrolyzer.arrowHeight, ElectrolyzerCategory.Uid);
	}
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime)
	{
		JeiUtil.jeiRuntimeAvailible = true;
	}
	
	
	private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
        @SuppressWarnings("resource")
		ClientWorld world = Minecraft.getInstance().world;
        ErrorUtil.checkNotNull(world, "minecraft world");
        return recipeManager;
    }
}
