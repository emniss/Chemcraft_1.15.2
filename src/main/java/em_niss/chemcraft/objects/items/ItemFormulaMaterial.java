package em_niss.chemcraft.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemFormulaMaterial extends ItemMaterial
{
	private final String formula;
	
	public ItemFormulaMaterial(String formula)
	{
		super();
		this.formula = formula;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(formula));
	}
}
