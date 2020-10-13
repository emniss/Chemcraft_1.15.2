package em_niss.chemcraft.jei.machines;

import java.util.ArrayList;
import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.Config;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import em_niss.chemcraft.recipes.electrolyzer.ElectrolyzerRecipe;
import em_niss.chemcraft.util.NumberUtil;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class ElectrolyzerJEICategory extends MachineJEICategory<ElectrolyzerRecipe>
{
	public static ResourceLocation Uid = new ResourceLocation(Chemcraft.MODID, "electrolyzercategory");
	
	private static final int numberOfInputs = 2;
	private static final int numberOfOutputs = 2;
	
	public ElectrolyzerJEICategory(IGuiHelper guiHelper)
	{
		super(Uid, numberOfInputs, numberOfOutputs);
		
		ResourceLocation location = ScreenElectrolyzer.TEXTURE;
		
		background = guiHelper.drawableBuilder(location, 43, 6, 104, 75).addPadding(4, 4, 4, 4).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.BLOCK_ELECTROLYZER.get()));
		localizedName = Translator.translateToLocal("gui.jei.category.electrolyzer");
		arrow = guiHelper.drawableBuilder(location, 176, 0, 23, 16).buildAnimated(400, IDrawableAnimated.StartDirection.LEFT, false);
		energy = guiHelper.drawableBuilder(location, 176, 16, 16, 73).buildAnimated(400, IDrawableAnimated.StartDirection.TOP, true);
		energyBar = guiHelper.drawableBuilder(location, 151, 6, 18, 75).build();
	}


	@Override
	public Class<? extends ElectrolyzerRecipe> getRecipeClass() { return ElectrolyzerRecipe.class; }

	
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
			tooltip.add(NumberUtil.CommaSeparateNumber(recipe.getRequiredEnergy()) + " FE");
			tooltip.add(Config.ELECTROLYZER_ENERGY_CONSUMPTION.get() + " FE/t");
		}
		
		return tooltip;
	}
}
