package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftMaterialsItemGroup;
import net.minecraft.item.Item;

public class ItemMaterial extends Item
{
	public ItemMaterial()
	{
		super(new Item.Properties().group(ChemcraftMaterialsItemGroup.instance));
	}
}
