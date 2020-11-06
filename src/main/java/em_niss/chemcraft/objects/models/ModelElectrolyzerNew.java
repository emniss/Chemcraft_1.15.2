package em_niss.chemcraft.objects.models;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Optional;

import em_niss.chemcraft.util.ModBlockStateProperties;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelProperty;

public class ModelElectrolyzerNew implements IBakedModel
{
	private IBakedModel baseModel;
	private int power = 0;
	private boolean powered = false;
	
	
	public ModelElectrolyzerNew(IBakedModel baseModel)
	{
		this.baseModel = baseModel;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData)
	{
		if (state.has(BlockStateProperties.POWERED)) { powered = state.get(BlockStateProperties.POWERED); }
		if (state.has(ModBlockStateProperties.POWER_0_10)) { power = state.get(ModBlockStateProperties.POWER_0_10); }
		
		
	}

	private List<BakedQuad> getBakedQuadsFromIModelData(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData data)
	{
		if (!data.hasProperty(POWERED))
		{
			
		}
	}
	
}
