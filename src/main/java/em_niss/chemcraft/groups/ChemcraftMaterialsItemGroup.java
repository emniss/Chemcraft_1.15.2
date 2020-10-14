package em_niss.chemcraft.groups;

import em_niss.chemcraft.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ChemcraftMaterialsItemGroup extends ItemGroup
{
	public static final ChemcraftMaterialsItemGroup instance = new ChemcraftMaterialsItemGroup(ItemGroup.GROUPS.length, "chemcraftmaterialsgroup");
	
	private ChemcraftMaterialsItemGroup(int index, String label)
	{
		super(index, label);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemInit.POWDER_CHARCOAL.get());
	}
}
