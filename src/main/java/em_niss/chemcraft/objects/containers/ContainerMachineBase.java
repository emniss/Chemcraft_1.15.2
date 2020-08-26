package em_niss.chemcraft.objects.containers;

import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.objects.tileentity.TileMachineBase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public abstract class ContainerMachineBase extends Container 
{
	private TileMachineBase tileEntity;
	private PlayerEntity playerEntity;
	private IItemHandler playerInventory;
	
	private IntReferenceHolder requiredEnergyLeft;
	private IntReferenceHolder requiredEnergyTotal;
	
	private Block machineBlock;
	public IIntArray machineData;
	
	public ContainerMachineBase(ContainerType<?> containerType, int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity, Block machineBlock) 
	{
		this(containerType, windowId, world, pos, playerInventory, playerEntity, new IntArray(2), machineBlock);
	}
	
	public ContainerMachineBase(ContainerType<?> containerType, int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity, IIntArray machineData, Block machineBlock)
	{
		super(containerType, windowId);
		tileEntity = (TileMachineBase) world.getTileEntity(pos);
		this.playerEntity = playerEntity;
		this.playerInventory = new InvWrapper(playerInventory);
		this.machineData = machineData;
		this.machineBlock = machineBlock;
		
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> { addMachineSlots(h); });
	
		layoutPlayerInventorySlots(8, 84);
		
		//Energy
		trackInt(new IntReferenceHolder() {
			@Override
			public int get() { return getEnergy(); }

			@Override
			public void set(int value) { tileEntity.getCapability(CapabilityEnergy.ENERGY).ifPresent(h -> ((CustomEnergyStorage)h).setEnergy(value)); }
		});
	
		//Progress
		//trackIntArray(machineData);
		trackInt(requiredEnergyLeft = new IntReferenceHolder() {
			@Override
			public int get() { return tileEntity.getRequiredEnergyLeft(); }

			@Override
			public void set(int value) { tileEntity.setRequiredEnergyLeft(value); }
		});
		
		trackInt(requiredEnergyTotal = new IntReferenceHolder() {
			@Override
			public int get() { return tileEntity.getRequiredEnergyTotal(); }

			@Override
			public void set(int value) { tileEntity.setRequiredEnergyTotal(value); }
		});
	}
	
	//Energy
	public int getEnergy() 
	{
		return tileEntity.getCapability(CapabilityEnergy.ENERGY).map(h -> h.getEnergyStored()).orElse(0);
	}
	
	public int getMaxEnergy()
	{
		return tileEntity.getCapability(CapabilityEnergy.ENERGY).map(h -> h.getMaxEnergyStored()).orElse(0);
	}
	
	public int getRequiredEnergyLeft()
	{
		return ((TileMachineBase)tileEntity).getRequiredEnergyLeft();
	}
	
	public int getRequiredEnergyTotal()
	{
		return ((TileMachineBase)tileEntity).getRequiredEnergyTotal();
	}

	
	@OnlyIn(Dist.CLIENT)
	public int getProgressScaled(int pixels)
	{
		int requiredEnergyLeft = this.requiredEnergyLeft.get();
		int requiredEnergyTotal = this.requiredEnergyTotal.get();
		
		return (requiredEnergyTotal != 0) ? (int)((pixels - 1) * (1 - requiredEnergyLeft / (double)requiredEnergyTotal)) + 1: 0;
	}
	
	//Machine Slots
	protected abstract void addMachineSlots(IItemHandler handler);
	
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
		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerEntity, machineBlock);
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
