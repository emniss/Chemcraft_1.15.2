package em_niss.chemcraft.jei;

import javax.annotation.Nullable;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.RecipeSerializerInit;
import em_niss.chemcraft.jei.machines.ElectrolyzerJEICategory;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class ChemcraftJEIPlugin implements IModPlugin
{
	@Nullable
	private ElectrolyzerJEICategory electrolyzerCategory;
	
	
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
		
		registration.addRecipeCategories(new ElectrolyzerJEICategory(guiHelper));
	}
	
	@Override
	public void registerRecipes(IRecipeRegistration registration)
	{
		//THERMAL
		RecipeManager recipeManager = getRecipeManager();
		if (recipeManager == null)
		{
			return;
		}
		
		registration.addRecipes(recipeManager.getRecipes(RecipeSerializerInit.ELECTROLYZER_TYPE).values(), ElectrolyzerJEICategory.Uid);
	}
	
		
	
	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
		registration.addRecipeClickArea(ScreenElectrolyzer.class, ScreenElectrolyzer.arrowPosX, ScreenElectrolyzer.arrowPosY, ScreenElectrolyzer.arrowWidth, ScreenElectrolyzer.arrowHeight, ElectrolyzerJEICategory.Uid);
	}
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime)
	{
		JeiUtil.jeiRuntimeAvailible = true;
	}
	
	
	@SuppressWarnings("resource")
	private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
		ClientWorld world = Minecraft.getInstance().world;
        if (world != null)
        {
        	recipeManager = world.getRecipeManager();
        }
        return recipeManager;
    }
}
