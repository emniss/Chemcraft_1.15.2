package em_niss.chemcraft.datagen;

import java.util.Arrays;
import java.util.List;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.util.Chemicals;
import em_niss.chemcraft.util.Element;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class Elements extends ItemModelProvider
{
	public Elements(DataGenerator generator, ExistingFileHelper existingFileHelper)
	{
		super(generator, Chemcraft.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels()
	{
		List<String> types;
		
		for (Element element : Chemicals.ELEMENTS)
		{	
			if (element.phase == 's') { types = Arrays.asList("test_tube_", "ingot_", "powder_", "tiny_powder_", "nugget_"); }
			else { types = Arrays.asList("test_tube_"); }
				
			for (String type : types)
			{
				singleTexture(type + element.name, new ResourceLocation("item/generated"), "layer0", new ResourceLocation(Chemcraft.MODID, "items/elements/" + type + element.name));
			}			
		}
	}
}
