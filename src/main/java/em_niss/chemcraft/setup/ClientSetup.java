package em_niss.chemcraft.setup;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.init.ModContainerTypes;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import em_niss.chemcraft.objects.guis.ScreenHydrogenGenerator;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Chemcraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
	public static void init(final FMLClientSetupEvent event)
	{
		ScreenManager.registerFactory(ModContainerTypes.CONTAINER_ELECTROLYZER.get(), ScreenElectrolyzer::new);
		ScreenManager.registerFactory(ModContainerTypes.CONTAINER_HYDROGEN_GENERATOR.get(), ScreenHydrogenGenerator::new);
		
		RenderTypeLookup.setRenderLayer(BlockInit.BLOCK_HYDROGEN_GENERATOR.get(), RenderType.getSolid());

	}
}
