package em_niss.chemcraft.objects.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.util.concurrent.AtomicDouble;

import em_niss.chemcraft.energy.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileMachineBase extends TileEntity implements ITickableTileEntity, INamedContainerProvider
{
	private int inventorySize;
	private int frontEnergyBarHeight;
	private int maxEnergyStored;
	
	protected LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	protected LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
	
	protected int cookTime;
	protected int cookTimeTotal;
	
	protected IIntArray machineData = new IIntArray() {
		public int get(int index) {
			switch(index) {
			case 0: 
				return TileMachineBase.this.cookTime;
			case 1:
				return TileMachineBase.this.cookTimeTotal;
			default:
				return 0;
			}
		}
		public void set(int index, int value) {
			switch(index) {
			case 0:
				TileMachineBase.this.cookTime = value;
				break;
			case 1:
				TileMachineBase.this.cookTimeTotal = value;
				break;
			}
		}
		public int size() {
			return 2;
		}
	};
	
	
	
	public TileMachineBase(TileEntityType<?> tileEntityType, int inventorySize, int maxEnergyStored, int frontEnergyBarHeight, int cookTimeTotal)
	{
		super(tileEntityType);
		this.inventorySize = inventorySize;
		this.maxEnergyStored = maxEnergyStored;
		this.frontEnergyBarHeight = frontEnergyBarHeight;
		this.cookTimeTotal = cookTimeTotal;
	}
	
	@Override
	public void tick()
	{
		updateBlockState();
	}
	
	
	protected void updateBlockState()
	{		
		//Indicator on front
		BlockState blockState = world.getBlockState(pos);
		if (blockState.get(BlockStateProperties.POWERED) != cookTime > 0)
		{
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, cookTime > 0), 3);
		}
		
		//Energy display on front
		AtomicDouble energyPercent = new AtomicDouble(0);
		energy.ifPresent(energy -> {
			energyPercent.set((double)energy.getEnergyStored() / (double)energy.getMaxEnergyStored());
		});
		int energyHeight = (int)Math.floor(energyPercent.get() * frontEnergyBarHeight);
		if (blockState.get(BlockStateProperties.POWER_0_15) != energyHeight)
		{
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWER_0_15, energyHeight), 3);
		}
	}
		
		
	@SuppressWarnings("unchecked")
	@Override
	public void read(CompoundNBT tag)
	{
		CompoundNBT invTag = tag.getCompound("inv");
		handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));
		CompoundNBT energyTag = tag.getCompound("energy");
		energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(energyTag));
		super.read(tag);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CompoundNBT write(CompoundNBT tag) 
	{
		handler.ifPresent(h -> {;
			CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
			tag.put("inv", compound);
		});
		energy.ifPresent(h -> {;
			CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
			tag.put("energy", compound);
		});
		return super.write(tag);
	}
	
	
	//Items
	private IItemHandler createHandler() 
	{	
		return new ItemStackHandler(inventorySize) 
		{
			@Override
			protected void onContentsChanged(int slot) { markDirty(); }
		};
	}
	
	
	//Energy
	private IEnergyStorage createEnergy()
	{
		return new CustomEnergyStorage(maxEnergyStored, 0);
	}
	
	
	//Other
	@Nullable
	@Override
	public abstract Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity);

	@Override
	public ITextComponent getDisplayName() 
	{
		return new StringTextComponent(getType().getRegistryName().getPath());
	}
		
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
	{
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return handler.cast();
		}	
		if (cap == CapabilityEnergy.ENERGY)
		{
			return energy.cast();
		}
		return super.getCapability(cap, side);
	}
}
