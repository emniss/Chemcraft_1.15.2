package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftItemGroup;
import net.minecraft.item.Item;

public class ItemBase extends Item
{

	public ItemBase(Properties properties)
	{
		super(properties);
	}
	
	public ItemBase()
	{
		super(new Item.Properties().group(ChemcraftItemGroup.instance));
	}

}
