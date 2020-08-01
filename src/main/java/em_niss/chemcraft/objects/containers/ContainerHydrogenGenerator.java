package em_niss.chemcraft.objects.containers;

import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.init.ModContainerTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerHydrogenGenerator extends ContainerMachineBase 
{	
	private static final ContainerType<ContainerHydrogenGenerator> containerType = ModContainerTypes.CONTAINER_HYDROGEN_GENERATOR.get();
	private static final Block machineBlock = BlockInit.BLOCK_HYDROGEN_GENERATOR.get();
	
	public ContainerHydrogenGenerator(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity) 
	{
		super(containerType, windowId, world, pos, playerInventory, playerEntity, machineBlock);
	}
	
	public ContainerHydrogenGenerator(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity, IIntArray machineData)
	{
		super(containerType, windowId, world, pos, playerInventory, playerEntity, machineData, machineBlock);
	}
	
	@Override
	protected void addMachineSlots(IItemHandler handler)
	{
		addSlot(new SlotItemHandler(handler, 0, 44, 22));
		addSlot(new SlotItemHandler(handler, 1, 44, 48));
		addSlot(new SlotItemHandler(handler, 2, 104, 35));
	}
}
