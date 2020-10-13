package em_niss.chemcraft.jei.electrolyzer;

import java.util.ArrayList;
import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
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


public class ElectrolyzerCategory implements IRecipeCategory<ElectrolyzerRecipe>
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
	public Class<? extends ElectrolyzerRecipe> getRecipeClass() { return ElectrolyzerRecipe.class; }

	@Override
	public String getTitle() {return localizedName; }

	@Override
	public IDrawable getBackground() { return background; }

	@Override
	public IDrawable getIcon() { return icon; }

	
	@Override
	public void setIngredients(ElectrolyzerRecipe Recipe, IIngredients ingredients)
	{
		ingredients.setInputs(VanillaTypes.ITEM, Recipe.getInputs());
		ingredients.setOutputs(VanillaTypes.ITEM, Recipe.getOutputs());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ElectrolyzerRecipe Recipe, IIngredients ingredients)
	{
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
		
		itemStacks.init(input1, true, 4, 19);
		itemStacks.init(input2, true, 4, 45);
		itemStacks.init(output1, false, 58, 19);
		itemStacks.init(output2, false, 58, 45);
		
		
		List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
		List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);
		
		for (int i = 0; i < inputs.size(); ++i)
		{
			itemStacks.set(i, inputs.get(i));
		}
		
		for (int i = 0; i < outputs.size(); ++i)
		{
			itemStacks.set(i + 2, outputs.get(i));
		}
		
		itemStacks.set(input1, ingredients.getInputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(input2, ingredients.getInputs(VanillaTypes.ITEM).get(1));
		itemStacks.set(output1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(output2, ingredients.getOutputs(VanillaTypes.ITEM).get(1));
	}
	
	@Override
	public void draw(ElectrolyzerRecipe recipe, double mouseX, double mouseY)
	{
		arrow.draw(29, 32);
		energyBar.draw(88, 4);
		energy.draw(89, 5);
	}
	
	@Override
	public List<String> getTooltipStrings(ElectrolyzerRecipe recipe, double mouseX, double mouseY)
	{
		int energyX = 88;
		int energyY = 4;
		int energyWidth = 17;
		int energyHeight = 75;
		
		
				
		List<String> tooltip = new ArrayList<>();
		
		if (mouseX >= energyX && mouseX <= energyX + energyWidth && mouseY >= energyY && mouseY <= energyY + energyHeight)
		{
			tooltip.add(recipe.getRequiredEnergy() + " FE");
			tooltip.add(Config.ELECTROLYZER_ENERGY_CONSUMPTION + " FE/t");
		}
		/*else if (mouseX >= allRecipesX && mouseX <= allRecipesX + allRecipesHeight && mouseY >= allRecipesY && mouseY <= allRecipesY + allRecipesHeight)
		{
			tooltip.add(Recipe.getallRecipes() + " ticks");
		}*/
		
		return tooltip;
	}
	
	/*
	public static List<ElectrolyzerRecipe> generateRecipes()
	{
		List<ElectrolyzerRecipe> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		
		int energy = 10000;
		
		input1 = new ItemStack(ItemInit.TEST_TUBE_HYDROGEN_CHLORIDE.get());
		input2 = new ItemStack(ItemInit.TEST_TUBE_EMPTY.get()));
		
		outputs1 = new ItemStack(ItemInit.TEST_TUBE_HYDROGEN.get()));
		outputs2 = new ItemStack(ItemInit.TEST_TUBE_CHLORINE.get()));
		
		recipes.add(new ElectrolyzerRecipe(inputs.get(0), inputs.get(1), outputs.get(0), outputs, energy));
		
		return recipes;
	}*/
}
