package em_niss.chemcraft.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOreGenerated extends Block
{
	public BlockOreGenerated() 
	{
		super(Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6));
	}
}
