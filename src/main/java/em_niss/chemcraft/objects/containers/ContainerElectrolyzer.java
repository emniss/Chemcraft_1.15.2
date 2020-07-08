package em_niss.chemcraft.objects.containers;

import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.init.ModContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerElectrolyzer extends Container 
{
	private TileEntity tileEntity;
	private PlayerEntity playerEntity;
	private IItemHandler playerInventory;
	
	public ContainerElectrolyzer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity)
	{
		super(ModContainerTypes.CONTAINER_ELECTROLYZER.get(), windowId);
		tileEntity = world.getTileEntity(pos);
		this.playerEntity = playerEntity;
		this.playerInventory = new InvWrapper(playerInventory);
		
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> { addMachineSlots(h); });
	
		layoutPlayerInventorySlots(8, 84);
		
		//Energy
		trackInt(new IntReferenceHolder() {
			@Override
			public int get() { return getEnergy(); }

			@Override
			public void set(int value) { tileEntity.getCapability(CapabilityEnergy.ENERGY).ifPresent(h -> ((CustomEnergyStorage)h).setEnergy(value)); }
		});
	}
	
	public int getEnergy() 
	{
		return tileEntity.getCapability(CapabilityEnergy.ENERGY).map(h -> h.getEnergyStored()).orElse(0);
	}
	
	private void addMachineSlots(IItemHandler handler)
	{
		addSlot(new SlotItemHandler(handler, 0, 44, 22));
		addSlot(new SlotItemHandler(handler, 1, 44, 48));
		addSlot(new SlotItemHandler(handler, 2, 98, 22));
		addSlot(new SlotItemHandler(handler, 3, 98, 48));
	}
	
	//ItemSlots
	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx)
	{
		for (int i = 0; i < amount; i++)
		{
			addSlot(new SlotItemHandler(handler, index, x, y));
			x += dx;
			index++;
		}
		return index;
	}
	
	private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy)
	{
		for (int j = 0; j < verAmount; j++)
		{
			index = addSlotRange(handler, index, x, y, horAmount, dx);
			y += dy;
		}
		return index;
	}
	
	private void layoutPlayerInventorySlots(int leftCol, int topRow)
	{
		//Player inventory
		addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
		
		//Hotbar
		topRow += 58;
		addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
	}
	

	//GUI
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) 
	{
		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerEntity, BlockInit.BLOCK_ELECTROLYZER.get());
	}
	
	
	//TransferStackInSlot
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack.copy();
			if (index < 4)
			{
				if (!this.mergeItemStack(itemstack1, 4, this.inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, 4, false))
			{
				return ItemStack.EMPTY;
			}
		}
		return itemstack;
	}

}
