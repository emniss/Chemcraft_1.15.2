package em_niss.chemcraft.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.util.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;

public class BlockStates extends BlockStateProvider
{
	public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
	{
		super(gen, Chemcraft.MODID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() 
	{
		registerBlockOre(BlockInit.BLOCK_BAUXITE.get(), "bauxite");
		registerBlockOre(BlockInit.BLOCK_CHALCOPYRITE.get(), "chalcopyrite");
		
		registerBlockMachineBase(BlockInit.BLOCK_ELECTROLYZER.get(), "electrolyzer");
	}
	
	
	
	private void registerBlockMachineBase(Block block, String name)
	{
		ResourceLocation txtDown = new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_down");
		ResourceLocation txtSide = new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_side");
		ResourceLocation txtUp = new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_up");
		ResourceLocation txtFrontOn = new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_front_on_0");
		ResourceLocation txtFrontOff = new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_front_off_0");
		
		List<BlockModelBuilder> modelsBlockMachineOn = new ArrayList<>();
		List<BlockModelBuilder> modelsBlockMachineOff = new ArrayList<>();
		
		for (int i = 0; i <= 10; i++)
		{
			modelsBlockMachineOn.add(models().cube("block/block_" + name + "/block_" + name + "_on_" + i, txtDown, txtUp, new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_front_on_" + i), txtSide, txtSide, txtSide));
			modelsBlockMachineOff.add(models().cube("block/block_" + name + "/block_" + name + "_off_" + i, txtDown, txtUp, new ResourceLocation(Chemcraft.MODID, "blocks/" + name + "/" + name + "_front_off_" + i), txtSide, txtSide, txtSide));
		}
		
		horizontalFaceBlock(block, state -> {
			int power = state.get(ModBlockStateProperties.POWER_0_10);
			if (state.get(BlockStateProperties.POWERED))
			{
				return modelsBlockMachineOn.get(power);
			}
			else
			{
				return modelsBlockMachineOff.get(power);
			}
		});
	}
	
	private void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.get(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir.getAxis() == Direction.Axis.Y ?  dir.getAxisDirection().getOffset() * -90 : 0)
                            .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.getHorizontalIndex() + 2) % 4) * 90 : 0)
                            .build();
                });
    }
	
	
	
	
	private void registerBlockOre(Block block, String name)
	{
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cubeAll("block/block_" + name, new ResourceLocation(Chemcraft.MODID, "blocks/" + name))));
		
		//simpleBlock(block);
	}
}
