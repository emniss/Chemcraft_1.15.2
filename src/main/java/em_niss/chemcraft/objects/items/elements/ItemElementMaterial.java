package em_niss.chemcraft.objects.items.elements;

import em_niss.chemcraft.groups.ChemcraftElementsItemGroup;
import em_niss.chemcraft.objects.items.ItemFormulaMaterial;

public class ItemElementMaterial extends ItemFormulaMaterial
{
	public ItemElementMaterial(String formula)
	{
		super(formula, ChemcraftElementsItemGroup.instance);
	}
}
