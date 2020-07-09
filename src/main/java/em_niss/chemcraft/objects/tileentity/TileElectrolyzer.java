package em_niss.chemcraft.objects.tileentity;

import javax.annotation.Nullable;

import em_niss.chemcraft.Config;
import em_niss.chemcraft.energy.CustomEnergyStorage;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.objects.containers.ContainerElectrolyzer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.MathHelper;

public class TileElectrolyzer extends TileGeneratorBase implements ITickableTileEntity, INamedContainerProvider
{
	private static final int inventorySize = 4;
	private static final int frontEnergyBarHeight = 10;
	private static final int maxEnergyStored = Config.ELECTROLYZER_MAXPOWER.get();
	private static final int cookTimeTotal = Config.ELECTROLYZER_TICKS.get();
	private static final TileEntityType<TileElectrolyzer> tileEntityType = ModTileEntityTypes.TILE_ELECTROLYZER.get();
	
	
	public TileElectrolyzer()
	{
		super(tileEntityType, inventorySize, maxEnergyStored, frontEnergyBarHeight, cookTimeTotal);
	}
	
	@Override
	public void tick() 
	{
		
		if (world.isRemote) { return; }
		
		if (cookTime > 0)
		{
			this.cookTime = MathHelper.clamp(this.cookTime - 1, 0, super.cookTimeTotal);
			if (cookTime <= 0)
			{
				energy.ifPresent(e -> ((CustomEnergyStorage)e).addEnergy(Config.ELECTROLYZER_GENERATE.get()));
				markDirty();
			}
		}
		
		if (cookTime <= 0) 
		{
			handler.ifPresent(h -> {
				ItemStack stack = h.getStackInSlot(0);
				if (stack.getItem() == Items.DIAMOND)
				{
					h.extractItem(0, 1, false);
					cookTime = super.cookTimeTotal;
					markDirty();
				}
			});
		}
		
		super.tick();
	}
	
	
	//Other
	@Nullable
	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) 
	{
		return new ContainerElectrolyzer(windowId, world, pos, playerInventory, playerEntity, this.machineData);
	}
}
