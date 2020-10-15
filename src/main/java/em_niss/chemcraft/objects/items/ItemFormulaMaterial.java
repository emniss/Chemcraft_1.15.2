package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftMaterialsItemGroup;
import net.minecraft.item.ItemGroup;

public class ItemFormulaMaterial extends FormulaItem
{
	public ItemFormulaMaterial(String formula)
	{
		super(formula, ChemcraftMaterialsItemGroup.instance);
	}
	
	public ItemFormulaMaterial(String formula, ItemGroup group)
	{
		super(formula, group);
	}
}
