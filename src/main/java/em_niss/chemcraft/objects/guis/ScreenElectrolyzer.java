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
	private static final ResourceLocation TEXTURE = new ResourceLocation(Chemcraft.MODID, "textures/gui/electrolyzer.png");
	
	private static final int[] positions = {
			115,	//xEnergyText
			72,		//yEnergyText
			
			67,		//xArrowPos
			35,		//yArrowPos
			176,	//xArrowTexture
			14,		//yArrowTesxture
			24,		//arrowWidth
			17,		//arrowHeight
			
			152,	//xEnergyPos
			80,		//yEnergyPos
			176,	//xEnergyTexture
			31,		//yEnergyTexture
			16,		//energyWidth
			73		//energyHeight
	};
	
	public ScreenElectrolyzer(ContainerElectrolyzer container, PlayerInventory inv, ITextComponent name)
	{
		super(container, inv, name, TEXTURE, positions);
	}
}
