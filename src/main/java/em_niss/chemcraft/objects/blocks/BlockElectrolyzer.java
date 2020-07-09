package em_niss.chemcraft.objects.blocks;

import em_niss.chemcraft.objects.tileentity.TileElectrolyzer;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

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
}
