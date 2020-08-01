package em_niss.chemcraft.objects.blocks;

import em_niss.chemcraft.objects.containers.ContainerHydrogenGenerator;
import em_niss.chemcraft.objects.tileentity.TileHydrogenGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockHydrogenGenerator extends BlockMachineBase
{
	public BlockHydrogenGenerator()
	{
		super();
	}
	
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return new TileHydrogenGenerator();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
		if (!world.isRemote)
		{
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof TileHydrogenGenerator)
			{
				INamedContainerProvider containerProvider = new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName()
					{
						return new TranslationTextComponent("screen.chemcraft.hydrogen_generator");
					}
					
					@Override
					public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
					{
						return new ContainerHydrogenGenerator(i, world, pos, playerInventory, playerEntity);
					}
				};
				NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
			}
			else
			{
				throw new IllegalStateException("Our named containerProvider is missing!");
			}
			return ActionResultType.SUCCESS;
		}
		return super.onBlockActivated(state, world, pos, player, hand, result);
	}
}
