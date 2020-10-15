package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftMaterialsItemGroup;
import net.minecraft.item.ItemGroup;

public class ItemFormulaTestTube extends FormulaItem
{
	public ItemFormulaTestTube(String formula)
	{
		super(formula, ChemcraftMaterialsItemGroup.instance);
	}
	
	public ItemFormulaTestTube(String formula, ItemGroup group)
	{
		super(formula, group);
	}
}
