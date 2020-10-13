package em_niss.chemcraft.jei.machines;

import java.util.Arrays;
import java.util.List;

import em_niss.chemcraft.recipes.MachineRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class MachineJEICategory<T extends MachineRecipe> implements IRecipeCategory<T>
{	
	protected final ResourceLocation uid;
	protected IDrawable background;
	protected IDrawable icon;
	protected IDrawableAnimated arrow;
	protected IDrawableAnimated energy;
	protected IDrawable energyBar;	
	protected String localizedName;
	
	private final int numberOfInputs;
	private final int numberOfOutputs;
	
	public MachineJEICategory(ResourceLocation uid, int numberOfInputs, int numberOfOutputs)
	{
		this.uid = uid;
		this.numberOfInputs = numberOfInputs;
		this.numberOfOutputs = numberOfOutputs;
	}
	
	
	@Override
	public ResourceLocation getUid() { return uid; }

	@Override
	public String getTitle() { return localizedName; }

	@Override
	public IDrawable getBackground() { return background; }

	@Override
	public IDrawable getIcon() { return icon; }


	@Override
	public void setIngredients(T recipe, IIngredients ingredients) 
	{
		ingredients.setInputs(VanillaTypes.ITEM, recipe.getInputs());
		ingredients.setOutputs(VanillaTypes.ITEM, recipe.getOutputs());
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, T recipe, IIngredients ingredients)
	{
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
		
		List<Integer> xPositions = Arrays.asList(4, 4, 58, 58);
		List<Integer> yPositions = Arrays.asList(19, 45, 19, 45);
		
		for (int i = 0; i < numberOfInputs; i++)
		{
			itemStacks.init(i, true, xPositions.get(i), yPositions.get(i));
		}
		
		for (int i = 0; i < numberOfOutputs; i++)
		{
			itemStacks.init(i + numberOfInputs, false, xPositions.get(i + numberOfInputs), yPositions.get(i + numberOfInputs));
		}
		
		List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
		List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);
		
		for (int i = 0; i < inputs.size(); i++)
		{
			itemStacks.set(i, inputs.get(i));
		}
		
		for (int i = 0; i < outputs.size(); i++)
		{
			itemStacks.set(i + numberOfInputs, outputs.get(i));
		}
	}
}