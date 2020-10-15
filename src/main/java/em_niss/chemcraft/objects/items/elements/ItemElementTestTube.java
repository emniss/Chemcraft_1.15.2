package em_niss.chemcraft.objects.items.elements;

import em_niss.chemcraft.groups.ChemcraftElementsItemGroup;
import em_niss.chemcraft.objects.items.ItemFormulaTestTube;

public class ItemElementTestTube extends ItemFormulaTestTube
{
	public ItemElementTestTube(String formula)
	{
		super(formula, ChemcraftElementsItemGroup.instance);
	}
}
