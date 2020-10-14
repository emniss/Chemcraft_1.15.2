package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import em_niss.chemcraft.objects.tileentity.TileHydrogenGenerator;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes
{
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Chemcraft.MODID);
	
	//Types
	public static final RegistryObject<TileEntityType<TileElectrolyzer>> TILE_ELECTROLYZER = TILES.register("electrolyzer", () -> TileEntityType.Builder.create(TileElectrolyzer::new, BlockInit.BLOCK_ELECTROLYZER.get()).build(null));
	public static final RegistryObject<TileEntityType<TileHydrogenGenerator>> TILE_HYDROGEN_GENERATOR = TILES.register("hydrogen_generator", () -> TileEntityType.Builder.create(TileHydrogenGenerator::new, BlockInit.BLOCK_HYDROGEN_GENERATOR.get()).build(null));
}
