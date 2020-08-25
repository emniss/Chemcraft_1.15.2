package em_niss.chemcraft.objects.blocks;

import em_niss.chemcraft.objects.containers.ContainerElectrolyzer;
import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockElectrolyzer extends BlockMachineBase
{
	public BlockElectrolyzer()
	{
		super();
	}
	
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return new TileElectrolyzer();
	}
	
	protected void interactWith(World world, BlockPos pos, PlayerEntity player)
	{
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileElectrolyzer)
		{
			INamedContainerProvider containerProvider = new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName()
				{
					return new TranslationTextComponent("screen.chemcraft.electrolyzer");
				}
				
				@Override
				public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
				{
					return new ContainerElectrolyzer(i, world, pos, playerInventory, playerEntity);
				}
			};
			NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
		}
		else
		{
			throw new IllegalStateException("Our named containerProvider is missing!");
		}
	}
}
