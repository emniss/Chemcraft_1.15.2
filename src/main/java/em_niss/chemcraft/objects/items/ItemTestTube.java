package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftElementsItemGroup;
import net.minecraft.item.Item;

public class ItemTestTube extends Item
{
	public ItemTestTube()
	{
		super(new Item.Properties().group(ChemcraftElementsItemGroup.instance));
	}
}
