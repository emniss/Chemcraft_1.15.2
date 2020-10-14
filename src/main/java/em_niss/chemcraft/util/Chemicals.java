package em_niss.chemcraft.util;

import java.util.Arrays;
import java.util.List;

public class Chemicals 
{
	public static final String WATER = "H\u2082O";
	public static final String HYDROGEN_CHLORIDE = "HCl";
	public static final String CARBON_DIOXIDE = "CO\u2082";
	
	
	//Hydrocarbons
	public static final String METHANE = "CH\u2084";
	public static final String ETHANE = "C\u2082H\u2086";
	public static final String PROPANE = "C\u2083H\u2088";
	public static final String BUTANE = "C\u2084H\u2081\u2080";
	public static final String PENTANE = "C\u2085H\u2081\u2082";
	public static final String HEXANE = "C\u2086H\u2081\u2084";
	public static final String HEPTANE = "C\u2087H\u2081\u2086";
	public static final String OCTANE = "C\u2088H\u2081\u2088";
	public static final String NONANE = "C\u2089H\u2082\u2080";
	public static final String DECANE = "C\u2081\u2080H\u2082\u2082";
	
	//Salts
	public static final String ALUMINIUM_OXIDE = "Al\u2082O\u2083";
	public static final String ALUMINIUM_HYDROXIDE = "Al(OH)\u2083";
	public static final String BORON_TRICHLORIDE = "BCl\u2083";
	public static final String LITHIUM_CARBONATE = "Li\u2082CO\u2083";
	public static final String SODIUM_CARBONATE = "Na\u2082CO\u2083";
	public static final String SODIUM_SULFATE = "Na\u2082SO\u2084";
	public static final String SULFURIC_ACID = "H\u2082SO\u2084";
	public static final String SODIUM_HYDROXIDE = "NaOH";
	
	//Mixtures
	public static final String OXYHYDROGEN = "4H\u2082 : O\u2082";

	
	
	//Elements
	public static final Element HYDROGEN = new Element("hydrogen", "H", 1, 'g');
	public static final Element HELIUM = new Element("helium", "He", 2, 'g');
	public static final Element LITHIUM = new Element("lithium", "Li", 3, 's');
	public static final Element BERYLLIUM = new Element("beryllium", "Be", 4, 's');
	public static final Element BORON = new Element("boron", "B", 5, 's');
	public static final Element CARBON = new Element("carbon", "C", 6, 's');
	public static final Element NITROGEN = new Element("nitrogen", "N", 7, 'g');
	public static final Element OXYGEN = new Element("oxygen", "O", 8, 'g');
	public static final Element FLUORINE = new Element("fluorine", "F", 9, 'g');
	public static final Element NEON = new Element("neon", "Ne", 10, 'g');
	public static final Element SODIUM = new Element("sodium", "Na", 11, 's');
	public static final Element MAGNESIUM = new Element("magnesium", "Mg", 12, 's');
	public static final Element ALUMINIUM = new Element("aluminium", "Al", 13, 's');
	public static final Element SILICON = new Element("silicon", "Si", 14, 's');
	public static final Element PHOSPHORUS = new Element("phosphorus", "P", 15, 's');
	public static final Element SULFUR = new Element("sulfur", "S", 16, 's');
	public static final Element CHLORINE = new Element("chlorine", "Cl", 17, 'g');
	public static final Element ARGON = new Element("argon", "Ar", 18, 'g');
	public static final Element POTASSIUM = new Element("potassium", "K", 19, 's');
	public static final Element CALCIUM = new Element("calcium", "Ca", 20, 's');
	public static final Element SCANDIUM = new Element("scandium", "Sc", 21, 's');
	public static final Element TITANIUM = new Element("titanium", "Ti", 22, 's');
	public static final Element VANADIUM = new Element("vanadium", "V", 23, 's');
	public static final Element CHROMIUM = new Element("chromium", "Cr", 24, 's');
	public static final Element MANGANESE = new Element("manganese", "Mn", 25, 's');
	public static final Element IRON = new Element("iron", "Fe", 26, 's');
	public static final Element COBALT = new Element("cobalt", "Co", 27, 's');
	public static final Element NICKEL = new Element("nickel", "Ni", 28, 's');
	public static final Element COPPER = new Element("copper", "Cu", 29, 's');
	public static final Element ZINC = new Element("zinc", "Zn", 30, 's');
	public static final Element GALLIUM = new Element("gallium", "Ga", 31, 's');
	public static final Element GERMANIUM = new Element("germanium", "Ge", 32, 's');
	public static final Element ARSENIC = new Element("arsenic", "As", 33, 's');
	public static final Element SELENIUM = new Element("selenium", "Se", 34, 's');
	public static final Element BROMINE = new Element("bromine", "Br", 35, 'l');
	public static final Element KRYPTON = new Element("krypton", "Kr", 36, 'g');
	public static final Element RUBIDIUM = new Element("rubidium", "Rb", 37, 's');
	public static final Element STRONTIUM = new Element("strontium", "Sr", 38, 's');
	public static final Element YTTRIUM = new Element("yttrium", "Y", 39, 's');
	public static final Element ZIRCONIUM = new Element("zirconium", "Zr", 40, 's');
	public static final Element NIOBIUM = new Element("niobium", "Nb", 41, 's');
	public static final Element MOLYBDENIUM = new Element("molybdenium", "Mo", 42, 's');
	public static final Element TECHNETIUM = new Element("technetium", "Tc", 43, 'n');
	public static final Element RUTHENIUM = new Element("ruthenium", "Ru", 44, 's');
	public static final Element RHODIUM = new Element("rhodium", "Rh", 45, 's');
	public static final Element PALLADIUM = new Element("palladium", "Pd", 46, 's');
	public static final Element SILVER = new Element("silver", "Ag", 47, 's');
	public static final Element CADMIUM = new Element("cadmium", "Cn", 48, 's');
	public static final Element INDIUM = new Element("indium", "In", 49, 's');
	public static final Element TIN = new Element("tin", "Sn", 50, 's');
	public static final Element ANTIMONY = new Element("antimony", "Sb", 51, 's');
	public static final Element TELLURIUM = new Element("tellurium", "Te", 52, 's');
	public static final Element IODINE = new Element("iodine", "I", 53, 's');
	public static final Element XENON = new Element("xenon", "Xe", 54, 's');
	public static final Element CESIUM = new Element("cesium", "Cs", 55, 's');
	public static final Element BARIUM = new Element("barium", "Ba", 56, 's');
	public static final Element LANTHANUM = new Element("lanthanum", "La", 57, 's');
	public static final Element CERIUM = new Element("cerium", "Ce", 58, 's');
	public static final Element PRASEODYMIUM = new Element("praseodymium", "Pr", 59, 's');
	public static final Element NEODYMIUM = new Element("neodymium", "Nd", 60, 's');
	public static final Element PROMETIUM = new Element("prometium", "Pm", 61, 'n');
	public static final Element SAMARIUM = new Element("samarium", "Sm", 62, 's');
	public static final Element EUROPIUM = new Element("europium", "Eu", 63, 's');
	public static final Element GADOLIUM = new Element("gadolium", "Gd", 64, 's');
	public static final Element TERBIUM = new Element("terbium", "Tb", 65, 's');
	public static final Element DYSPROSIUM = new Element("dysprosium", "Dy", 66, 's');
	public static final Element HOLMIUM = new Element("holmium", "Ho", 67, 's');
	public static final Element ERBIUM = new Element("erbium", "Er", 68, 's');
	public static final Element THULIUM = new Element("thulium", "Tm", 69, 's');
	public static final Element YTTERBIUM = new Element("ytterbium", "Yb", 70, 's');
	public static final Element LUTETIUM = new Element("lutetium", "Lu", 71, 's');
	public static final Element HAFNIUM = new Element("hafnium", "Hf", 72, 's');
	public static final Element TANTALUM = new Element("tantalum", "Ta", 73, 's');
	public static final Element TUNGSTEN = new Element("tungsten", "W", 74, 's');
	public static final Element RHENIUM = new Element("rhenium", "Re", 75, 's');
	public static final Element OSMIUM = new Element("osmium", "Os", 76, 's');
	public static final Element IRIDIUM = new Element("iridium", "Ir", 77, 's');
	public static final Element PLATINUM = new Element("platinum", "Pt", 78, 's');
	public static final Element GOLD = new Element("gold", "Au", 79, 's');
	public static final Element MERCURY = new Element("mercury", "Hg", 80, 'l');
	public static final Element THALLIUM = new Element("thallium", "Tl", 81, 's');
	public static final Element LEAD = new Element("lead", "Pb", 82, 's');
	public static final Element BISMUTH = new Element("bismuth", "Bi", 83, 's');
	public static final Element POLONIUM = new Element("polonium", "Po", 84, 's');
	public static final Element ASTATINE = new Element("astatine", "At", 85, 's');
	public static final Element RADON = new Element("radon", "Rn", 86, 's');
	public static final Element FRANCIUM = new Element("francium", "Fr", 87, 's');
	public static final Element RADIUM = new Element("radium", "Ra", 88, 's');
	public static final Element ACTINIUM = new Element("actinium", "Ac", 89, 's');
	public static final Element THORIUM = new Element("thorium", "Th", 90, 's');
	public static final Element PROTACTINIUM = new Element("protactinium", "Pa", 91, 's');
	public static final Element URANIUM = new Element("uranium", "U", 92, 's');
	public static final Element NEPTUNIUM = new Element("neptunium", "Np", 93, 'n');
	public static final Element PLUTONIUM = new Element("plutonium", "Pu", 94, 'n');
	public static final Element AMERICIUM = new Element("americium", "Am", 95, 'n');
	public static final Element CURIUM = new Element("curium", "Cm", 96, 'n');
	public static final Element BERKELIUM = new Element("berkelium", "Bk", 97, 'n');
	public static final Element CALIFORNIUM = new Element("californium", "Cf", 98, 'n');
	public static final Element EINSTEINIUM = new Element("einsteinium", "Es", 99, 'n');
	public static final Element FERMIUM = new Element("fermium", "Fm", 100, 'n');
	public static final Element MENDELEVIUM = new Element("mendelevium", "Md", 101, 'n');
	public static final Element NOBELIUM = new Element("nobelium", "No", 102, 'n');
	public static final Element LAWRENCIUM = new Element("lawrencium", "Lr", 103, 'n');
	public static final Element RUTHERFORDIUM = new Element("rutherfordium", "Rf", 104, 'n');
	public static final Element DUBNIUM = new Element("dubnium", "Db", 105, 'n');
	public static final Element SEABORGIUM = new Element("seaborgium", "Sg", 106, 'n');
	public static final Element BOHRIUM = new Element("bohrium", "Bh", 107, 'n');
	public static final Element HASSIUM = new Element("hassium", "Hs", 108, 'n');
	public static final Element MEITNERIUM = new Element("meitnerium", "Mt", 109, 'n');
	public static final Element DARMSTADTIUM = new Element("darmstadtium", "Ds", 110, 'n');
	public static final Element ROENTGENIUM = new Element("roentgenium", "Rg", 111, 'n');
	public static final Element COPERNICIUM = new Element("copernicium", "Cn", 112, 'n');
	public static final Element NIHONIUM = new Element("nihonium", "Nh", 113, 'n');
	public static final Element FLEROVIUM = new Element("flerovium", "Fl", 114, 'n');
	public static final Element MOSCOVIUM = new Element("moscovium", "Mc", 115, 'n');
	public static final Element LIVERMORIUM = new Element("livermorium", "Lv", 116, 'n');
	public static final Element TENNESSINE = new Element("tennessine", "Ts", 117, 'n');
	public static final Element OGANESSON = new Element("oganesson", "Og", 118, 'n');
	
	public static List<Element> ELEMENTS 
	= Arrays.asList(HYDROGEN, HELIUM, LITHIUM, BERYLLIUM, BORON, CARBON, NITROGEN, OXYGEN, FLUORINE, NEON,
					SODIUM, MAGNESIUM, ALUMINIUM, SILICON, PHOSPHORUS, SULFUR, CHLORINE, ARGON,
					POTASSIUM, CALCIUM, SCANDIUM, TITANIUM, VANADIUM, CHROMIUM, MANGANESE, IRON, COBALT, NICKEL, COPPER, ZINC, GALLIUM, GERMANIUM, ARSENIC, SELENIUM, BROMINE, KRYPTON,
					RUBIDIUM, STRONTIUM, YTTRIUM, ZIRCONIUM, NIOBIUM, MOLYBDENIUM, TECHNETIUM, RUTHENIUM, RHODIUM, PALLADIUM, SILVER, CADMIUM, INDIUM, TIN, ANTIMONY, TELLURIUM, IODINE, XENON,
					CESIUM, BARIUM, LANTHANUM, CERIUM, PRASEODYMIUM, NEODYMIUM, PROMETIUM, SAMARIUM, EUROPIUM, GADOLIUM, TERBIUM, DYSPROSIUM, HOLMIUM, ERBIUM, THULIUM, YTTERBIUM, LUTETIUM, 
					HAFNIUM, TANTALUM, TUNGSTEN, RHENIUM, OSMIUM, IRIDIUM, PLATINUM, GOLD, MERCURY, THALLIUM, LEAD, BISMUTH, POLONIUM, ASTATINE, RADON, 
					FRANCIUM, RADIUM, ACTINIUM, THORIUM, PROTACTINIUM, URANIUM, NEPTUNIUM, PLUTONIUM, AMERICIUM, CURIUM, BERKELIUM, CALIFORNIUM, EINSTEINIUM, FERMIUM, MENDELEVIUM, NOBELIUM, LAWRENCIUM, 
					RUTHERFORDIUM, DUBNIUM, SEABORGIUM, BOHRIUM, HASSIUM, MEITNERIUM, DARMSTADTIUM, ROENTGENIUM, COPERNICIUM, NIHONIUM, FLEROVIUM, MOSCOVIUM, LIVERMORIUM, TENNESSINE, OGANESSON);
}
