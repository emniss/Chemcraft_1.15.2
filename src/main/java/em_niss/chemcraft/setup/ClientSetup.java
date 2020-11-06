package em_niss.chemcraft.setup;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.init.ModContainerTypes;
import em_niss.chemcraft.objects.guis.ScreenElectrolyzer;
import em_niss.chemcraft.objects.guis.ScreenHydrogenGenerator;
import em_niss.chemcraft.objects.models.ModelElectrolyzer;
import em_niss.chemcraft.objects.models.ModelLoaderElectrolyzer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
<<<<<<< Updated upstream
import net.minecraftforge.api.distmarker.Dist;
=======
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
	}
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onTextureStitch(TextureStitchEvent.Pre event)
	{
		if (!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE))
		{
			return;
		}
		
		event.addSprite(ModelElectrolyzer.TEXTURE);
>>>>>>> Stashed changes
	}
}
