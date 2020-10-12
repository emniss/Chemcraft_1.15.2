package em_niss.chemcraft.objects.guis;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import em_niss.chemcraft.jei.JeiUtil;
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
	protected int arrowPosX, arrowPosY, arrowTextureX, arrowTextureY, arrowWidth, arrowHeight;
	protected int energyTextX, energyTextY, energyPosX, energyPosY, energyTextureX, energyTextureY, energyWidth, energyHeight;
	
	private ResourceLocation texture;
	
	public ScreenMachineBase(C container, PlayerInventory inv, ITextComponent name, ResourceLocation texture, int arrowPosX, int arrowPosY, int arrowTextureX, int arrowTextureY, int arrowWidth, int arrowHeight, int energyTextX, int energyTextY, int energyPosX, int energyPosY, int energyTextureX, int energyTextureY, int energyWidth, int energyHeight)
	{
		super(container, inv, name);
		this.texture = texture;
		
		this.arrowPosX = arrowPosX;
		this.arrowPosY = arrowPosY;
		this.arrowTextureX = arrowTextureX;
		this.arrowTextureY = arrowTextureY;
		this.arrowWidth = arrowWidth;
		this.arrowHeight = arrowHeight;
		
		this.energyTextX = energyTextX;
		this.energyTextY = energyTextY;
		this.energyPosX = energyPosX;
		this.energyPosY = energyPosY;
		this.energyTextureX = energyTextureX;
		this.energyTextureY = energyTextureY;
		this.energyWidth = energyWidth;
		this.energyHeight = energyHeight;
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
		this.font.drawString("" + ((C)container).getEnergy(), energyTextX, energyTextY, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(texture);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
		
		//Animation
		int progressArrowWidthScaled = ((ContainerMachineBase)this.container).getProgressScaled(arrowWidth);
		this.blit(this.guiLeft + arrowPosX, this.guiTop + arrowPosY, arrowTextureX, arrowTextureY, progressArrowWidthScaled, arrowHeight);
		
		int energyHeightScaled = this.getEnergyScaled(energyHeight);
		this.blit(this.guiLeft + energyPosX, this.guiTop + energyPosY - energyHeightScaled, energyTextureX, energyTextureY, energyWidth, energyHeightScaled);
	}
	
	@Override
	protected void renderHoveredToolTip(int mouseX, int mouseY)
	{
		if (mouseX >= this.guiLeft + energyPosX - 1 && mouseX < this.guiLeft + energyPosX + energyWidth + 1 && mouseY >= this.guiTop + energyPosY - energyHeight - 1 && mouseY < this.guiTop + energyPosY + 1)
		{
			List<String> tooltip = new ArrayList<>();
			tooltip.add(this.container.getEnergy() + "/" + this.container.getMaxEnergy() + " FE");
			
			this.renderTooltip(tooltip, mouseX, mouseY);
		}
		else if (JeiUtil.isJeiRuntimeAvailible() && mouseX >= this.guiLeft + arrowPosX && mouseX < this.guiLeft + arrowPosX + arrowWidth - 1 && mouseY >= this.guiTop + arrowPosY && mouseY < this.guiTop + arrowPosY + arrowHeight)
		{
			List<String> tooltip = new ArrayList<>();
			tooltip.add("Show recipes");
			
			this.renderTooltip(tooltip, mouseX, mouseY);
		}
		
		super.renderHoveredToolTip(mouseX, mouseY);
	}
	
	private int getEnergyScaled(int pixels)
	{
		int energyStored = this.container.getEnergy();
		int maxEnergyStored = this.container.getMaxEnergy();
		
		return (maxEnergyStored != 0) ?  (int)(pixels * energyStored / (double)maxEnergyStored) : 0;
	}
}
