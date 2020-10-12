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
	public static final ResourceLocation TEXTURE = new ResourceLocation(Chemcraft.MODID, "textures/gui/hydrogen_generator.png");
		
	public static final int energyTextX = 115;
	public static final int energyTextY = 72;

	public static final int arrowPosX = 68;
	public static final int arrowPosY = 34;
	public static final int arrowTextureX = 176;
	public static final int arrowTextureY = 0;
	public static final int arrowWidth = 23;
	public static final int arrowHeight = 16;

	public static final int energyPosX = 152;
	public static final int energyPosY = 80;
	public static final int energyTextureX = 176;
	public static final int energyTextureY = 16;
	public static final int energyWidth = 16;
	public static final int energyHeight = 73;
	
	
	public ScreenHydrogenGenerator(ContainerHydrogenGenerator container, PlayerInventory inv, ITextComponent name)
	{
		super(container, inv, name, TEXTURE, arrowPosX, arrowPosY, arrowTextureX, arrowTextureY, arrowWidth, arrowHeight, energyTextX, energyTextY, energyPosX, energyPosY, energyTextureX, energyTextureY, energyWidth, energyHeight);
	}
}
