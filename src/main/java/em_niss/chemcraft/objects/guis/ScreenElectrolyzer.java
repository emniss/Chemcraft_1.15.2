package em_niss.chemcraft.objects.guis;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.containers.ContainerElectrolyzer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenElectrolyzer extends ScreenMachineBase<ContainerElectrolyzer>
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Chemcraft.MODID, "textures/gui/electrolyzer.png");
	
	public ScreenElectrolyzer(ContainerElectrolyzer container, PlayerInventory inv, ITextComponent name)
	{
		super(container, inv, name, TEXTURE);
		
		energyTextX = 115;
		energyTextY = 72;
	
		arrowPosX = 68;
		arrowPosY = 34;
		arrowTextureX = 176;
		arrowTextureY = 0;
		arrowWidth = 23;
		arrowHeight = 16;
	
		energyPosX = 152;
		energyPosY = 80;
		energyTextureX = 176;
		energyTextureY = 16;
		energyWidth = 16;
		energyHeight = 73;
	}
}
