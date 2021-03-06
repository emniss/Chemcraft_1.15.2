package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.groups.ChemcraftItemGroup;
import em_niss.chemcraft.objects.blocks.BlockElectrolyzer;
import em_niss.chemcraft.objects.blocks.BlockHydrogenGenerator;
import em_niss.chemcraft.objects.blocks.BlockOreGenerated;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit 
{
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Chemcraft.MODID);
	
	public static final RegistryObject<Block> BLOCK_ELECTROLYZER = BLOCKS.register("block_electrolyzer", () -> new BlockElectrolyzer());
	public static final RegistryObject<Block> BLOCK_HYDROGEN_GENERATOR = BLOCKS.register("block_hydrogen_generator", () -> new BlockHydrogenGenerator());
	
	public static final RegistryObject<Block> BLOCK_BAUXITE = BLOCKS.register("block_bauxite", () -> new BlockOreGenerated());
	public static final RegistryObject<Block> BLOCK_CHALCOPYRITE = BLOCKS.register("block_chalcopyrite", () -> new BlockOreGenerated());
	
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Chemcraft.MODID);
	
	public static final RegistryObject<Item> ITEM_ELECTROLYZER = ITEMS.register("block_electrolyzer", () -> new BlockItem(BLOCK_ELECTROLYZER.get(), new Item.Properties().group(ChemcraftItemGroup.instance)));
	public static final RegistryObject<Item> ITEM_HYDROGEN_GENERATOR = ITEMS.register("block_hydrogen_generator", () -> new BlockItem(BLOCK_HYDROGEN_GENERATOR.get(), new Item.Properties().group(ChemcraftItemGroup.instance)));
	
	public static final RegistryObject<Item> ITEM_BAUXITE = ITEMS.register("block_bauxite", () -> new BlockItem(BLOCK_BAUXITE.get(), new Item.Properties().group(ChemcraftItemGroup.instance)));
	public static final RegistryObject<Item> ITEM_CHALCOPYRITE = ITEMS.register("block_chalcopyrite", () -> new BlockItem(BLOCK_CHALCOPYRITE.get(), new Item.Properties().group(ChemcraftItemGroup.instance)));
}
