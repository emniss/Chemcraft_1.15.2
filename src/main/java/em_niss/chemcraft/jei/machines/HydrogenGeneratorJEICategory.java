package em_niss.chemcraft.jei.machines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.jei.JeiUtil;
import em_niss.chemcraft.objects.guis.ScreenHydrogenGenerator;
import em_niss.chemcraft.recipes.hydrogenGenerator.HydrogenGeneratorRecipe;
import em_niss.chemcraft.util.NumberUtil;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class HydrogenGeneratorJEICategory extends MachineJEICategory<HydrogenGeneratorRecipe>
{
	private static final int numberOfInputs = 2;
	private static final int numberOfOutputs = 1;
	
	public HydrogenGeneratorJEICategory(IGuiHelper guiHelper)
	{
		super(JeiUtil.HYDROGEN_GENERATOR_CATEGORY_UID, numberOfInputs, numberOfOutputs);
		
		ResourceLocation location = ScreenHydrogenGenerator.TEXTURE;
		
		background = guiHelper.drawableBuilder(location, 43, 6, 104, 75).addPadding(4, 4, 4, 4).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.BLOCK_HYDROGEN_GENERATOR.get()));
		localizedName = Translator.translateToLocal("gui.jei.category.hydrogen_generator");
		arrow = guiHelper.drawableBuilder(location, 176, 0, 23, 16).buildAnimated(400, IDrawableAnimated.StartDirection.LEFT, false);
		energy = guiHelper.drawableBuilder(location, 176, 16, 16, 73).buildAnimated(400, IDrawableAnimated.StartDirection.TOP, true);
		energyBar = guiHelper.drawableBuilder(location, 151, 6, 18, 75).build();
		
		itemPositionsX = Arrays.asList(4, 4, 58);
		itemPositionsY = Arrays.asList(19, 45, 32);
	}


	@Override
	public Class<? extends HydrogenGeneratorRecipe> getRecipeClass() { return HydrogenGeneratorRecipe.class; }

	
	@Override
	public void draw(HydrogenGeneratorRecipe recipe, double mouseX, double mouseY)
	{
		arrow.draw(29, 32);
		energyBar.draw(88, 4);
		energy.draw(89, 5);
	}
	
	@Override
	public List<String> getTooltipStrings(HydrogenGeneratorRecipe recipe, double mouseX, double mouseY)
	{
		int energyX = 88;
		int energyY = 4;
		int energyWidth = 17;
		int energyHeight = 75;
				
		List<String> tooltip = new ArrayList<>();
		
		if (mouseX >= energyX && mouseX <= energyX + energyWidth && mouseY >= energyY && mouseY <= energyY + energyHeight)
		{
			tooltip.add(NumberUtil.CommaSeparateNumber(recipe.getRequiredEnergy()) + " FE");
			tooltip.add(recipe.getEnergyPerTick() + " FE/t");
		}
		
		return tooltip;
	}
}
