package em_niss.chemcraft.datagen;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class Items extends ItemModelProvider
{
	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper)
	{
		super(generator, Chemcraft.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels()
	{
		registerItem(ItemInit.TEST_TUBE_EMPTY.get(), "test_tube_empty");
		//registerBlockItems();
	}
	
	
	private void registerItem(Item item, String txtName)
	{
		singleTexture(item.getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(Chemcraft.MODID, "items/" + txtName));
	}
	
	/*private void registerBlockItems()
	{
		for (RegistryObject<Item> item : BlockInit.ITEMS.getEntries())
		{
			withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation(Chemcraft.MODID, "block/" + item.get()));
		}
	}*/
	
}
