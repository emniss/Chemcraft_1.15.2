package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftElementsItemGroup;
import net.minecraft.item.Item;

public class ItemTestTubeBase extends Item
{
	public ItemTestTubeBase()
	{
		super(new Item.Properties().group(ChemcraftElementsItemGroup.instance));
	}
}
