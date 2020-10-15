package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item
{
	public ItemBase()
	{
		super(new Item.Properties().group(ChemcraftItemGroup.instance));
	}

	public ItemBase(ItemGroup group)
	{
		super(new Item.Properties().group(group));
	}
	
	public ItemBase(ItemGroup group, Properties properties)
	{
		super(properties.group(group));
	}

}
