package em_niss.chemcraft.objects.guis;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.containers.ContainerHydrogenGenerator;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenHydrogenGenerator extends ScreenMachineBase<ContainerHydrogenGenerator>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Chemcraft.MODID, "textures/gui/hydrogen_generator.png");
	
	private static final int[] positions = {
			115,	//xEnergyText
			72,		//yEnergyText
			
			67,		//xArrowPos
			35,		//yArrowPos
			176,	//xArrowTexture
			0,		//yArrowTexture
			24,		//arrowWidth
			17,		//arrowHeight
			
			152,	//xEnergyPos
			80,		//yEnergyPos
			176,	//xEnergyTexture
			17,		//yEnergyTexture
			16,		//energyWidth
			73		//energyHeight
	};
	
	public ScreenHydrogenGenerator(ContainerHydrogenGenerator container, PlayerInventory inv, ITextComponent name)
	{
		super(container, inv, name, TEXTURE, positions);
	}
}
