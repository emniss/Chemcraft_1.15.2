package em_niss.chemcraft.groups;

import em_niss.chemcraft.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ChemcraftItemGroup extends ItemGroup
{
	public static final ChemcraftItemGroup instance = new ChemcraftItemGroup(ItemGroup.GROUPS.length, "chemcraftgroup");
	
	private ChemcraftItemGroup(int index, String label)
	{
		super(index, label);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemInit.INGOT_ALUMINIUM.get());
	}
}
