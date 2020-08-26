package em_niss.chemcraft.objects.guis;

import com.mojang.blaze3d.systems.RenderSystem;

import em_niss.chemcraft.objects.containers.ContainerMachineBase;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class ScreenMachineBase<C extends ContainerMachineBase> extends ContainerScreen<C> 
{
	private ResourceLocation TEXTURE;
	private int[] positions;
	
	public ScreenMachineBase(C container, PlayerInventory inv, ITextComponent name, ResourceLocation texture, int[] positions)
	{
		super(container, inv, name);
		this.TEXTURE = texture;
		this.positions = positions;
	}
	
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
		this.font.drawString("" + ((C)container).getEnergy(), positions[0], positions[1], 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
		
		//Animation
		int progressArrowWidthScaled = ((ContainerMachineBase)this.container).getProgressScaled(positions[6]);
		this.blit(this.guiLeft + positions[2], this.guiTop + positions[3], positions[4], positions[5], progressArrowWidthScaled, positions[7]);
		
		int energyHeightScaled = this.getEnergyScaled(positions[13]);
		this.blit(this.guiLeft + positions[8], this.guiTop + positions[9] - energyHeightScaled, positions[10], positions[11], positions[12], energyHeightScaled);
	}
	
	private int getEnergyScaled(int pixels)
	{
		int energyStored = this.container.getEnergy();
		int maxEnergyStored = this.container.getMaxEnergy();
		
		return (maxEnergyStored != 0) ?  (int)(pixels * energyStored / (double)maxEnergyStored) : 0;
	}
}
