package em_niss.chemcraft.jei;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.ItemInit;
import em_niss.chemcraft.jei.electrolyzer.ElectrolyzerCategory;
import em_niss.chemcraft.jei.electrolyzer.ElectrolyzerRecipeWrapper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.item.ItemStack;
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
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();

		registration.addRecipes(generateElectrolyzerRecipes(), ElectrolyzerCategory.Uid);
	}
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime)
	{
		JeiUtil.jeiRuntimeAvailible = true;
	}
	
	
	private List<ElectrolyzerRecipeWrapper> generateElectrolyzerRecipes()
	{
		List<ElectrolyzerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		
		int energy = 10000;
		
		inputs.add(new ItemStack(ItemInit.TEST_TUBE_HYDROGEN_CHLORIDE.get()));
		inputs.add(new ItemStack(ItemInit.TEST_TUBE_EMPTY.get()));
		
		outputs.add(new ItemStack(ItemInit.TEST_TUBE_HYDROGEN.get()));
		outputs.add(new ItemStack(ItemInit.TEST_TUBE_CHLORINE.get()));
		
		recipes.add(new ElectrolyzerRecipeWrapper(inputs, outputs, energy));
		
		return recipes;
	}
}
