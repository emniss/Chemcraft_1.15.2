package em_niss.chemcraft.objects.blocks;

import em_niss.chemcraft.objects.containers.ContainerHydrogenGenerator;
import em_niss.chemcraft.objects.tileentity.TileHydrogenGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockHydrogenGenerator extends BlockMachineBase
{
	private static final VoxelShape SHAPE_NORTH = Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 16.0D, 16.0D);
	private static final VoxelShape SHAPE_WEST = Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 16.0D, 16.0D, 14.0D);
	
	
	public BlockHydrogenGenerator()
	{
		super();
	}
	
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return new TileHydrogenGenerator();
	}
	
	protected void interactWith(World world, BlockPos pos, PlayerEntity player)
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
	}
	
	//Rendering
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch ((Direction) state.get(FACING))
		{
			case UP :
			case DOWN :
			case SOUTH : 
				return SHAPE_NORTH;
			case NORTH : 
				return SHAPE_NORTH;
			case WEST : 
				return SHAPE_WEST;
			case EAST : 
				return SHAPE_WEST;
			default : 
				return SHAPE_NORTH;
		}
	}
	
	
}
