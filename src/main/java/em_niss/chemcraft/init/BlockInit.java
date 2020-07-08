package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.groups.ChemcraftItemGroup;
import em_niss.chemcraft.objects.blocks.BlockElectrolyzer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit 
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Chemcraft.MODID);
	
	public static final RegistryObject<Block> BLOCK_ELECTROLYZER = BLOCKS.register("block_electrolyzer", () -> new BlockElectrolyzer());
	
	
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Chemcraft.MODID);
	
	public static final RegistryObject<Item> ITEM_ELECTROLYZER = ITEMS.register("block_electrolyzer", () -> new BlockItem(BLOCK_ELECTROLYZER.get(), new Item.Properties().group(ChemcraftItemGroup.instance)));
}
