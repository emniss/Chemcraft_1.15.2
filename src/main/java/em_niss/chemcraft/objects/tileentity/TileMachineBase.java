package em_niss.chemcraft.objects.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.util.concurrent.AtomicDouble;

import em_niss.chemcraft.energy.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileMachineBase extends TileEntity implements ITickableTileEntity
{
	private final int inventorySize;
	private int frontEnergyBarHeight;
	private int maxEnergyStored;
	private int maxEnergyReceive;
	private int maxEnergyExtract;
	
	protected ItemStackHandler itemHandler;
	protected CustomEnergyStorage energyStorage;
	
	protected LazyOptional<IItemHandler> handler;
	protected LazyOptional<IEnergyStorage> energy;
	
	protected int cookTime = 0;
	protected int cookTimeTotal = 0;
	protected boolean isCooking = false;
	protected int energyConsumption;
	
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
	

	
	public TileMachineBase(TileEntityType<?> tileEntityType, int inventorySize, int maxEnergyStored, int maxEnergyReceive, int maxEnergyExtract, int frontEnergyBarHeight)
	{
		super(tileEntityType);
		this.inventorySize = inventorySize;
		this.maxEnergyStored = maxEnergyStored;
		this.maxEnergyReceive = maxEnergyReceive;
		this.maxEnergyExtract = maxEnergyExtract;
		this.frontEnergyBarHeight = frontEnergyBarHeight;
		
		itemHandler = createHandler();
		energyStorage = createEnergy(); 
		
		handler = LazyOptional.of(() -> itemHandler);
		energy  = LazyOptional.of(() -> energyStorage);
	}
	
	@Override
	public void tick()
	{
		if (isCooking) { doCooking(); }
		if (!isCooking) { doRefueling(); }
		
		updateBlockState();
	}
	
	protected abstract void doCooking();
	protected abstract void doRefueling();
	
	private void updateBlockState()
	{		
		//Indicator on front
		BlockState blockState = world.getBlockState(pos);
		if (blockState.get(BlockStateProperties.POWERED) != cookTime > 0)
		{
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, cookTime > 0), Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
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
		
		
	@Override
	public void read(CompoundNBT tag)
	{
		itemHandler.deserializeNBT(tag.getCompound("inv"));
		energyStorage.deserializeNBT(tag.getCompound("energy"));
		super.read(tag);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT tag) 
	{
		tag.put("inv", itemHandler.serializeNBT());
		tag.put("enegry", energyStorage.serializeNBT());
		return super.write(tag);
	}
	
	
	//Items
	private ItemStackHandler createHandler() 
	{	
		return new ItemStackHandler(inventorySize)
		{
			@Override
			protected void onContentsChanged(int slot) { markDirty(); }
		};
	}
	
	
	//Energy
	protected CustomEnergyStorage createEnergy()
	{
		return new CustomEnergyStorage(maxEnergyStored, maxEnergyReceive, maxEnergyExtract) {
			@Override
			protected void onEnergyChanged() { markDirty(); }
		};
	}
	
	
		
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
	{
		if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY))
		{
			return handler.cast();
		}	
		if (cap.equals(CapabilityEnergy.ENERGY))
		{
			LazyOptional<T> cast = energy.cast();
			return cast;
		}
		return super.getCapability(cap, side);
	}
}
