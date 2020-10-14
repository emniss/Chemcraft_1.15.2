package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.items.ItemBase;
import em_niss.chemcraft.objects.items.ItemConsumable;
import em_niss.chemcraft.objects.items.ItemCrucible;
import em_niss.chemcraft.objects.items.ItemFormulaMaterial;
import em_niss.chemcraft.objects.items.ItemFormulaTestTube;
import em_niss.chemcraft.objects.items.ItemMaterial;
import em_niss.chemcraft.objects.items.ItemTestTube;
import em_niss.chemcraft.util.Chemicals;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
	//List of all Items
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Chemcraft.MODID);
	
	//Misc
	public static final RegistryObject<Item> TEST_TUBE_EMPTY = ITEMS.register("test_tube_empty", () -> new ItemBase());
	
	//Elements
	/*public static final RegistryObject<Item> TEST_TUBE_HYDROGEN = ITEMS.register("test_tube_hydrogen", () -> new ItemTestTubeBase());
	public static final RegistryObject<Item> TEST_TUBE_OXYGEN = ITEMS.register("test_tube_oxygen", () -> new ItemTestTubeBase());
	public static final RegistryObject<Item> TEST_TUBE_CHLORINE = ITEMS.register("test_tube_chlorine", () -> new ItemTestTubeBase());
	*/
	//2-atomic Molecules
	public static final RegistryObject<Item> TEST_TUBE_WATER = ITEMS.register("test_tube_water", () -> new ItemFormulaTestTube(Chemicals.WATER));
	public static final RegistryObject<Item> TEST_TUBE_HYDROGEN_CHLORIDE = ITEMS.register("test_tube_hydrogen_chloride", () -> new ItemFormulaTestTube(Chemicals.HYDROGEN_CHLORIDE));
	public static final RegistryObject<Item> TEST_TUBE_CARBONDIOXIDE = ITEMS.register("test_tube_carbondioxide", () -> new ItemFormulaTestTube(Chemicals.CARBON_DIOXIDE));
	
	//3-atomic Molecules
	
	//Hydrocarbons
	public static final RegistryObject<Item> TEST_TUBE_METHANE = ITEMS.register("test_tube_methane", () -> new ItemFormulaTestTube(Chemicals.METHANE));
	public static final RegistryObject<Item> TEST_TUBE_ETHANE = ITEMS.register("test_tube_ethane", () -> new ItemFormulaTestTube(Chemicals.ETHANE));
	public static final RegistryObject<Item> TEST_TUBE_PROPANE = ITEMS.register("test_tube_propane", () -> new ItemFormulaTestTube(Chemicals.PROPANE));
	public static final RegistryObject<Item> TEST_TUBE_BUTANE = ITEMS.register("test_tube_butane", () -> new ItemFormulaTestTube(Chemicals.BUTANE));
	public static final RegistryObject<Item> TEST_TUBE_PENTANE = ITEMS.register("test_tube_pentane", () -> new ItemFormulaTestTube(Chemicals.PENTANE));
	public static final RegistryObject<Item> TEST_TUBE_HEXANE = ITEMS.register("test_tube_hexane", () -> new ItemFormulaTestTube(Chemicals.HEXANE));
	public static final RegistryObject<Item> TEST_TUBE_HEPTANE = ITEMS.register("test_tube_heptane", () -> new ItemFormulaTestTube(Chemicals.HEPTANE));
	public static final RegistryObject<Item> TEST_TUBE_OCTANE = ITEMS.register("test_tube_octane", () -> new ItemFormulaTestTube(Chemicals.OCTANE));
	public static final RegistryObject<Item> TEST_TUBE_NONANE = ITEMS.register("test_tube_nonane", () -> new ItemFormulaTestTube(Chemicals.NONANE));
	public static final RegistryObject<Item> TEST_TUBE_DECANE = ITEMS.register("test_tube_decane", () -> new ItemFormulaTestTube(Chemicals.DECANE));
	
	//Salts
	public static final RegistryObject<Item> TEST_TUBE_ALUMINIUM_OXIDE = ITEMS.register("test_tube_aluminium_oxide", () -> new ItemFormulaTestTube(Chemicals.ALUMINIUM_OXIDE));
	public static final RegistryObject<Item> TEST_TUBE_ALUMINIUM_HYDROXIDE = ITEMS.register("test_tube_aluminium_hydroxide", () -> new ItemFormulaTestTube(Chemicals.ALUMINIUM_HYDROXIDE));
	public static final RegistryObject<Item> TEST_TUBE_BORON_TRIOXIDE = ITEMS.register("test_tube_boron_trioxide", () -> new ItemFormulaTestTube(Chemicals.BORON_TRICHLORIDE));
	public static final RegistryObject<Item> TEST_TUBE_SODIUM_CARBONATE = ITEMS.register("test_tube_sodium_carbonate", () -> new ItemFormulaTestTube(Chemicals.SODIUM_CARBONATE));
	public static final RegistryObject<Item> TEST_TUBE_SODIUM_SULFATE = ITEMS.register("test_tube_sodium_sulfate", () -> new ItemFormulaTestTube(Chemicals.SODIUM_SULFATE));
	
	//Acids
	public static final RegistryObject<Item> TEST_TUBE_SULFURIC_ACID = ITEMS.register("test_tube_sulfuric_acid", () -> new ItemFormulaTestTube(Chemicals.SULFURIC_ACID));
	
	//Bases
	public static final RegistryObject<Item> TEST_TUBE_SODIUM_HYDROXIDE = ITEMS.register("test_tube_sodium_hydroxide", () -> new ItemFormulaTestTube(Chemicals.SODIUM_HYDROXIDE));
	
	//Mixtures
	public static final RegistryObject<Item> TEST_TUBE_ANODE_MUD = ITEMS.register("test_tube_anode_mud", () -> new ItemTestTube());
	public static final RegistryObject<Item> TEST_TUBE_BAUXITE_SLAG = ITEMS.register("test_tube_bauxite_slag", () -> new ItemTestTube());
	public static final RegistryObject<Item> TEST_TUBE_BORAX_SLAG = ITEMS.register("test_tube_borax_slag", () -> new ItemTestTube());
	public static final RegistryObject<Item> TEST_TUBE_CONCENTRATED_BRINE = ITEMS.register("test_tube_concentrated_brine", () -> new ItemTestTube());
	public static final RegistryObject<Item> TEST_TUBE_OXYHYDROGEN = ITEMS.register("test_tube_oxyhydrogen", () -> new ItemFormulaTestTube(Chemicals.OXYHYDROGEN));
	public static final RegistryObject<Item> TEST_TUBE_RED_MUD = ITEMS.register("test_tube_red_mud", () -> new ItemTestTube());
	
	//Salt powders
	public static final RegistryObject<Item> POWDER_LITHIUM_CARBONATE  = ITEMS.register("powder_lithium_carbonate", () -> new ItemFormulaMaterial(Chemicals.LITHIUM_CARBONATE));
	public static final RegistryObject<Item> POWDER_BORON_TRICHLORIDE  = ITEMS.register("powder_boron_trichloride", () -> new ItemFormulaMaterial("BCl\u2083"));
	
	//Mineral powders
	public static final RegistryObject<Item> POWDER_BAUXITE  = ITEMS.register("powder_bauxite", () -> new ItemMaterial());
	public static final RegistryObject<Item> POWDER_BORAX  = ITEMS.register("powder_borax", () -> new ItemMaterial());
	public static final RegistryObject<Item> POWDER_CHALCOPYRITE  = ITEMS.register("powder_chalcopyrite", () -> new ItemMaterial());
	public static final RegistryObject<Item> POWDER_CHARCOAL  = ITEMS.register("powder_charcoal", () -> new ItemFormulaMaterial(Chemicals.CARBON.symbol));
	
	/*//Metal powders
	public static final RegistryObject<Item> POWDER_ALUMINIUM  = ITEMS.register("powder_aluminium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_BORON  = ITEMS.register("powder_boron", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_COPPER  = ITEMS.register("powder_copper", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_COBALT  = ITEMS.register("powder_cobalt", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_GOLD  = ITEMS.register("powder_gold", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_LITHIUM  = ITEMS.register("powder_lithium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_NICKEL  = ITEMS.register("powder_nickel", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_PLATINUM  = ITEMS.register("powder_platinum", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> POWDER_SILVER  = ITEMS.register("powder_silver", () -> new ItemFormulaMaterialBase(""));
	
	//Tiny powders
	public static final RegistryObject<Item> TINY_POWDER_ALUMINIUM  = ITEMS.register("tiny_powder_aluminium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_BORON  = ITEMS.register("tiny_powder_boron", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_COBALT  = ITEMS.register("tiny_powder_cobalt", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_COPPER  = ITEMS.register("tiny_powder_copper", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_GOLD  = ITEMS.register("tiny_powder_gold", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_NICKEL  = ITEMS.register("tiny_powder_nickel", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_PLATINUM  = ITEMS.register("tiny_powder_platinum", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> TINY_POWDER_SILVER  = ITEMS.register("tiny_powder_silver", () -> new ItemFormulaMaterialBase(""));
	
	//Nuggets
	public static final RegistryObject<Item> NUGGET_ALUMINIUM  = ITEMS.register("nugget_aluminium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> NUGGET_COBALT  = ITEMS.register("nugget_cobalt", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> NUGGET_COPPER  = ITEMS.register("nugget_copper", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> NUGGET_NICKEL  = ITEMS.register("nugget_nickel", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> NUGGET_PLATINUM  = ITEMS.register("nugget_platinum", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> NUGGET_SILVER  = ITEMS.register("nugget_silver", () -> new ItemFormulaMaterialBase(""));
	
	//Ingots
	public static final RegistryObject<Item> INGOT_ALUMINIUM  = ITEMS.register("ingot_aluminium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_COBALT  = ITEMS.register("ingot_cobalt", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_COPPER  = ITEMS.register("ingot_copper", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_LITHIUM  = ITEMS.register("ingot_lithium", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_NICKEL  = ITEMS.register("ingot_nickel", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_PLATINUM  = ITEMS.register("ingot_platinum", () -> new ItemFormulaMaterialBase(""));
	public static final RegistryObject<Item> INGOT_SILVER  = ITEMS.register("ingot_silver", () -> new ItemFormulaMaterialBase(""));
	*/
	//Consumables
	public static final RegistryObject<Item> IGNITER = ITEMS.register("igniter", () -> new ItemConsumable(64));
	public static final RegistryObject<Item> UVLIGHT = ITEMS.register("uvlight", () -> new ItemConsumable(128));
	public static final RegistryObject<Item> FILTER_PAPER  = ITEMS.register("filter_paper", () -> new ItemBase());
	
	//Crucibles
	public static final RegistryObject<Item> CRUCIBLE_UNFIRED  = ITEMS.register("crucible_unfired", () -> new ItemBase());
	public static final RegistryObject<Item> CRUCIBLE  = ITEMS.register("crucible", () -> new ItemBase());
	
	//Filled Crucibles
	public static final RegistryObject<Item> CRUCIBLE_LITHIUM_CARBONATE_SOLID = ITEMS.register("crucible_lithium_carbonate_solid", () -> new ItemCrucible(Chemicals.LITHIUM_CARBONATE));
	public static final RegistryObject<Item> CRUCIBLE_LITHIUM_CARBONATE_MOLTEN = ITEMS.register("crucible_lithium_carbonate_molten", () -> new ItemCrucible(Chemicals.LITHIUM_CARBONATE));
	public static final RegistryObject<Item> CRUCIBLE_BORON_TRICHLORIDE_SOLID = ITEMS.register("crucible_boron_trichloride_solid", () -> new ItemCrucible(Chemicals.BORON_TRICHLORIDE));
	public static final RegistryObject<Item> CRUCIBLE_BORON_TRICHLORIDE_MOLTEN = ITEMS.register("crucible_boron_trichloride_molten", () -> new ItemCrucible(Chemicals.BORON_TRICHLORIDE));
	
	//Cathodes
	public static final RegistryObject<Item> CATHODE_COPPER  = ITEMS.register("cathode_copper", () -> new ItemBase());
	public static final RegistryObject<Item> CATHODE_PLATINUM  = ITEMS.register("cathode_platinum", () -> new ItemBase());
	
	//Machine parts
	public static final RegistryObject<Item> CONTROL_CIRCUIT  = ITEMS.register("control_circuit", () -> new ItemBase());


	
	
	
}