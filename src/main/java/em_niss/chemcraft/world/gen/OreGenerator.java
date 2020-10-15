package em_niss.chemcraft.world.gen;

import em_niss.chemcraft.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator
{
	public static void init()
	{
		generateOre(BlockInit.BLOCK_BAUXITE.get());
		generateOre(BlockInit.BLOCK_CHALCOPYRITE.get());
	}
	
	
	private static void generateOre(Block block)
	{
		for (Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, block.getDefaultState(), 15))
					.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128))));

			// if (biome == Biomes.PLAINS)
		}
	}
}
