package em_niss.chemcraft.groups;

import em_niss.chemcraft.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ChemcraftElementsItemGroup extends ItemGroup
{
	public static final ChemcraftElementsItemGroup instance = new ChemcraftElementsItemGroup(ItemGroup.GROUPS.length, "chemcraftelementsgroup");
	
	private ChemcraftElementsItemGroup(int index, String label)
	{
		super(index, label);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemInit.TEST_TUBE_EMPTY.get());
	}
}
