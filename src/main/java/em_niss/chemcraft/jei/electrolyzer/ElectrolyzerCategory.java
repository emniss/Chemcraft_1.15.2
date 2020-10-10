package em_niss.chemcraft.jei.electrolyzer;

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
	//private final IDrawable slotDrawable;
	private final String localizedName;
	private final IDrawableAnimated arrow;

	
	public ElectrolyzerCategory(IGuiHelper guiHelper)
	{
		ResourceLocation location = ScreenElectrolyzer.TEXTURE;
		
		background = guiHelper.drawableBuilder(location, 39, 17, 80, 54).addPadding(0, 0, 0, 0).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.BLOCK_ELECTROLYZER.get()));
		localizedName = Translator.translateToLocal("gui.jei.category.electrolyzer");
		arrow = guiHelper.drawableBuilder(location, 176, 0, 23, 16).buildAnimated(400, IDrawableAnimated.StartDirection.LEFT, false);
		
		//slotDrawable = guiHelper.createDrawable(location, 64, 29, 18, 4);
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

	
	@SuppressWarnings("unchecked")
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
		
		itemStacks.init(input1, true, 4, 4);
		itemStacks.init(input2, true, 4, 30);
		itemStacks.init(output1, false, 58, 4);
		itemStacks.init(output2, false, 58, 30);
		
		//itemStacks.setBackground(output1, slotDrawable);
		
		itemStacks.set(input1, ingredients.getInputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(input2, ingredients.getInputs(VanillaTypes.ITEM).get(1));
		itemStacks.set(output1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
		itemStacks.set(output2, ingredients.getOutputs(VanillaTypes.ITEM).get(1));
	}
	
	@Override
	public void draw(ElectrolyzerRecipeWrapper recipeWrapper, double mouseX, double mouseY)
	{
		arrow.draw(29, 17);
	}
	
	
	
}
