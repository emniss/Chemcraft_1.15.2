package em_niss.chemcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import em_niss.chemcraft.init.BlockInit;
import em_niss.chemcraft.init.ItemInit;
import em_niss.chemcraft.init.ModContainerTypes;
import em_niss.chemcraft.init.ModTileEntityTypes;
import em_niss.chemcraft.util.ClientSetup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;



@Mod("chemcraft")
public class Chemcraft
{
    public static final Logger LOGGER = LogManager.getLogger(Chemcraft.MODID);
    public static final String MODID = "chemcraft";
    public static Chemcraft instance;
    
    public Chemcraft()
    {
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BlockInit.ITEMS.register(modEventBus);
        
        ModTileEntityTypes.TILES.register(modEventBus);
        ModContainerTypes.CONTAINERS.register(modEventBus);
        
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
        
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("chemcraft-client.toml"));
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("chemcraft-common.toml"));
    }
    /*
    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    
    }
    */
}
