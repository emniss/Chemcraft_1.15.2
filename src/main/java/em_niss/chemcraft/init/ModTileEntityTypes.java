package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes
{
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Chemcraft.MODID);
	
	//Types
	public static final RegistryObject<TileEntityType<TileElectrolyzer>> TILE_ELECTROLYZER = TILES.register("electrolyser", () -> TileEntityType.Builder.create(TileElectrolyzer::new, BlockInit.BLOCK_ELECTROLYZER.get()).build(null));
}
