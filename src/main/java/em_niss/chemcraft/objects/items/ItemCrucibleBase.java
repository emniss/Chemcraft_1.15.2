package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftItemGroup;
import net.minecraft.item.Item;

public class ItemCrucibleBase extends Item
{
	public ItemCrucibleBase()
	{
		super(new Item.Properties().group(ChemcraftItemGroup.instance));
	}
}
