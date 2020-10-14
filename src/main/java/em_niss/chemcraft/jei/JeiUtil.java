package em_niss.chemcraft.jei;

import em_niss.chemcraft.Chemcraft;
import net.minecraft.util.ResourceLocation;

public class JeiUtil 
{
	public static final ResourceLocation CHEMCRAFT_PLUGIN_UID = new ResourceLocation(Chemcraft.MODID, "chemcraft");
	
	public static final ResourceLocation ELECTROLYZER_CATEGORY_UID = new ResourceLocation(Chemcraft.MODID + "electrolyzercategory");
	public static final ResourceLocation HYDROGEN_GENERATOR_CATEGORY_UID = new ResourceLocation(Chemcraft.MODID + "hydrogengeneratorcategory");
	
	
	public static boolean jeiRuntimeAvailible = false;
	
	public static boolean isJeiRuntimeAvailible()
	{
		return jeiRuntimeAvailible;
	}
}
