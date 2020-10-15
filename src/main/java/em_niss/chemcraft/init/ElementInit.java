package em_niss.chemcraft.init;

import java.util.Arrays;
import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.items.elements.ItemElementMaterial;
import em_niss.chemcraft.objects.items.elements.ItemElementTestTube;
import em_niss.chemcraft.util.Chemicals;
import em_niss.chemcraft.util.Element;

public class ElementInit
{
	private static List<String> exceptions = Arrays.asList(Chemicals.HYDROGEN.name, Chemicals.OXYGEN.name, Chemicals.FLUORINE.name, Chemicals.CHLORINE.name, Chemicals.BROMINE.name);
	
	public static void register()
	{
		Chemcraft.LOGGER.debug("Number of elements: " + Chemicals.ELEMENTS.size());
		
		for (Element element : Chemicals.ELEMENTS)
		{
			if (element.phase == 's')
			{
				ItemInit.ITEMS.register("test_tube_" + element.name, () -> new ItemElementTestTube(element.symbol));
				ItemInit.ITEMS.register("powder_" + element.name, () -> new ItemElementMaterial(element.symbol));
				ItemInit.ITEMS.register("tiny_powder_" + element.name, () -> new ItemElementMaterial(element.symbol));
				ItemInit.ITEMS.register("nugget_" + element.name, () -> new ItemElementMaterial(element.symbol));
				ItemInit.ITEMS.register("ingot_" + element.name, () -> new ItemElementMaterial(element.symbol));
			}
			else
			{
				if (exceptions.contains(element.name))
				{
					ItemInit.ITEMS.register("test_tube_" + element.name, () -> new ItemElementTestTube(element.symbol + "\u2082"));
				}
				else
				{
					ItemInit.ITEMS.register("test_tube_" + element.name, () -> new ItemElementTestTube(element.symbol));
				}
				
			}
		}
	}
}			
/*String regSymbol = element.symbol;
			if (exceptions.contains(element.name))
			{
				regSymbol = regSymbol + "\u2082"
			}*/
			
