package em_niss.chemcraft;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config
{
	private static final String CATEGORY_GENERAL = "general";
	private static final String CATEGORY_POWER = "power";
	private static final String SUB_CATEGORY_ELECTROLYZER = "electrolyzer";
	private static final String SUB_CATEGORY_HYDROGEN_GENERATOR = "hydrogen_generator";
	private static final String SUB_CATEGORY_GENERAL_ENERGY = "general_energy";
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	
	public static ForgeConfigSpec.IntValue ELECTROLYZER_MAXPOWER;
	public static ForgeConfigSpec.IntValue ELECTROLYZER_ENERGY_CONSUMPTION;
	
	public static ForgeConfigSpec.IntValue HYDROGEN_GENERATOR_MAXPOWER;
	
	public static ForgeConfigSpec.IntValue GENERATOR_SEND;
	public static ForgeConfigSpec.IntValue MACHINE_RECEIVE;
	
	
	static {
		COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
		COMMON_BUILDER.pop();	
		
		COMMON_BUILDER.comment("Power settings").push(CATEGORY_POWER);
		setupGeneralEnergyConfig();
		setupElectrolyzerConfig();
		setupHydrogenGeneratorConfig();
		
		COMMON_BUILDER.pop();
		
		
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	
	//Types
	
	private static void setupGeneralEnergyConfig()
	{
		COMMON_BUILDER.comment("General energy settings").push(SUB_CATEGORY_GENERAL_ENERGY);
		
		GENERATOR_SEND = COMMON_BUILDER.comment("Power to send per tick").defineInRange("send", 1000, 0, Integer.MAX_VALUE);
		MACHINE_RECEIVE = COMMON_BUILDER.comment("Power to receive per tick").defineInRange("receive", 1000, 0, Integer.MAX_VALUE);
		
		COMMON_BUILDER.pop();
	}
	
	private static void setupElectrolyzerConfig()
	{
		COMMON_BUILDER.comment("Electrolyzer settings").push(SUB_CATEGORY_ELECTROLYZER);
		
		ELECTROLYZER_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the electrolyzer").defineInRange("maxpower", 100000, 0, Integer.MAX_VALUE);
		ELECTROLYZER_ENERGY_CONSUMPTION = COMMON_BUILDER.comment("Maximum power consumed per tick for the electrolyzer. Higher value gives  faster processing.").defineInRange("maxconsumption", 10, 0, Integer.MAX_VALUE);
		
		COMMON_BUILDER.pop();
	}
	
	private static void setupHydrogenGeneratorConfig()
	{
		COMMON_BUILDER.comment("Hydrogen Genrator settings").push(SUB_CATEGORY_HYDROGEN_GENERATOR);
		
		HYDROGEN_GENERATOR_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the hydrogen generator").defineInRange("maxpower", 100000, 0, Integer.MAX_VALUE);
		
		COMMON_BUILDER.pop();
	}
	
	
	//Loading
	public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
	
	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent)
	{
		
	}
	
	@SubscribeEvent
	public static void onReload(final ModConfig.Loading configEvent)
	{
		
	}
}
