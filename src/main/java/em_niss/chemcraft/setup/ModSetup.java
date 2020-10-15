package em_niss.chemcraft.setup;

import em_niss.chemcraft.world.gen.OreGenerator;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup
{
	public static void init(final FMLCommonSetupEvent event)
	{
		OreGenerator.init();
	}
}
