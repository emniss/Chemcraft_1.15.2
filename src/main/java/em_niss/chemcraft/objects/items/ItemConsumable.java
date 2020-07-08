package em_niss.chemcraft.objects.items;

import em_niss.chemcraft.groups.ChemcraftElementsItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemConsumable extends Item
{
	public ItemConsumable(int uses)
	{
		super(new Item.Properties().group(ChemcraftElementsItemGroup.instance).maxDamage(uses));
	}
	
	@Override
	public boolean hasContainerItem()
	{
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		if (itemStack.getDamage() >= itemStack.getMaxDamage())
		{
			return ItemStack.EMPTY;
		}
		else
		{
			ItemStack newItemStack = itemStack.copy();
			newItemStack.setDamage(itemStack.getDamage() + 1);
			return newItemStack;
		}
	}
}
