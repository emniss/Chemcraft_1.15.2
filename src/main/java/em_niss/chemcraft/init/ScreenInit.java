package em_niss.chemcraft.init;

import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ScreenInit 
{
	public static void init(final FMLClientSetupEvent event)
	{
		ScreenManager.registerFactory(ModContainerTypes.CONTAINER_ELECTROLYZER.get(), ScreenElectrolyzer::new);
	}
}
