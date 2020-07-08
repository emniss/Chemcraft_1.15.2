package em_niss.chemcraft.util;

import em_niss.chemcraft.init.ModContainerTypes;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup 
{
	public static void init(final FMLClientSetupEvent event)
	{
		ScreenManager.registerFactory(ModContainerTypes.CONTAINER_ELECTROLYZER.get(), ScreenElectrolyzer::new);
	}
}
