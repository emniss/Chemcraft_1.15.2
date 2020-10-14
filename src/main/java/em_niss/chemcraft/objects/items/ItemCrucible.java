package em_niss.chemcraft.objects.items;

import java.util.List;

import em_niss.chemcraft.groups.ChemcraftItemGroup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCrucible extends Item
{
	private final String formula;
	
	public ItemCrucible(String formula)
	{
		super(new Item.Properties().group(ChemcraftItemGroup.instance));
		this.formula = formula;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(formula));
	}
}
