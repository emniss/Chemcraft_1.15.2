package em_niss.chemcraft.jei.electrolyzer;

import java.util.ArrayList;
import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class ElectrolyzerCategory implements IRecipeCategory<ElectrolyzerRecipeWrapper>
{
	public static ResourceLocation Uid = new ResourceLocation(Chemcraft.MODID, "electrolyzercategory");
	
	private static final int input1 = 0;
	private static final int input2 = 1;
	private static final int output1 = 2;
	private static final int output2 = 3;
	
	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;
	private final IDrawableAnimated arrow;
	private final IDrawableAnimated energy;
	private final IDrawable energyBar;

	
	public ElectrolyzerCategory(IGuiHelper guiHelper)
	{
		ResourceLocation location = ScreenElectrolyzer.TEXTURE;
		
		background = guiHelper.drawableBuilder(location, 43, 6, 104, 75).addPadding(4, 4, 4, 4).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.BLOCK_ELECTROLYZER.get()));
		localizedName = Translator.translateToLocal("gui.jei.category.electrolyzer");
		arrow = guiHelper.drawableBuilder(location, 176, 0, 23, 16).buildAnimated(400, IDrawableAnimated.StartDirection.LEFT, false);
		energy = guiHelper.drawableBuilder(location, 176, 16, 16, 73).buildAnimated(400, IDrawableAnimated.StartDirection.TOP, true);
		energyBar = guiHelper.drawableBuilder(location, 151, 6, 18, 75).build();
	}


	@Override
	public ResourceLocation getUid() { return Uid; }

	@Override
	public Class<? extends ElectrolyzerRecipeWrapper> getRecipeClass() { return ElectrolyzerRecipeWrapper.class; }

	@Override
	public String getTitle() {return localizedName; }

	@Override
	public IDrawable getBackground() { return background; }

	@Override
	public IDrawable getIcon() { return icon; }

	
	@Override
	public void setIngredients(ElectrolyzerRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		ingredients.setInputs(VanillaTypes.ITEM, recipeWrapper.getInputs());
		ingredients.setOutputs(VanillaTypes.ITEM, recipeWrapper.getOutputs());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ElectrolyzerRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
		
		itemStacks.init(input1, true, 4, 19);
		itemStacks.init(input2, true, 4, 45);
		itemStacks.init(output1, false, 58, 19);
		itemStacks.init(output2, false, 58, 45);
		
		//itemStacks.setBackground(output1, slotDrawable);
		
		itemStacks.set(input1, ingredients.getInputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(input2, ingredients.getInputs(VanillaTypes.ITEM).get(1));
		itemStacks.set(output1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(output2, ingredients.getOutputs(VanillaTypes.ITEM).get(1));
	}
	
	@Override
	public void draw(ElectrolyzerRecipeWrapper recipeWrapper, double mouseX, double mouseY)
	{
		arrow.draw(29, 32);
		energyBar.draw(88, 4);
		energy.draw(89, 5);
	}
	
	@Override
	public List<String> getTooltipStrings(ElectrolyzerRecipeWrapper recipeWrapper, double mouseX, double mouseY)
	{
		int energyX = 88;
		int energyY = 4;
		int energyWidth = 17;
		int energyHeight = 75;
		
		
				
		List<String> tooltip = new ArrayList<>();
		
		if (mouseX >= energyX && mouseX <= energyX + energyWidth && mouseY >= energyY && mouseY <= energyY + energyHeight)
		{
			tooltip.add(recipeWrapper.getEnergy() + " FE");
			tooltip.add(recipeWrapper.getEnergyPerTick() + " FE/t");
		}
		/*else if (mouseX >= allRecipesX && mouseX <= allRecipesX + allRecipesHeight && mouseY >= allRecipesY && mouseY <= allRecipesY + allRecipesHeight)
		{
			tooltip.add(recipeWrapper.getallRecipes() + " ticks");
		}*/
		
		return tooltip;
	}
	
	/*	
	@Override
	public boolean handleClick(ElectrolyzerRecipeWrapper recipe, double mouseX, double mouseY, int mouseButton)
	{
		if (this.theButton)
		int allRecipesX = 29;
		int allRecipesY = 32;
		int allRecipesWidth = 22;
		int allRecipesHeight = 16;
		
		if (mouseX >= allRecipesX && mouseX <= allRecipesX + allRecipesHeight && mouseY >= allRecipesY && mouseY <= allRecipesY + allRecipesHeight)
		{
			IRecipeCategoryExtension extension = this.extendableHelper.getRecipeExtension(recipe);
			return true;
		}
	}*/
	
}
