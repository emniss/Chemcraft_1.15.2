package em_niss.chemcraft.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonElementGenerator 
{
	private static final String basePath = "E:/Minecraft Modding/Chemcraft_1.15.2 Workspace/";
	JsonObject jsonObject;
	
	/**
	 * DEVELOPMENT UTILITY: 
	 * Generates external json-files for element models.
	 * @deprecated
	 */
	public static void generateModels()
	{
		List<String> types;
		
		for (Element element : Chemicals.ELEMENTS)
		{		
			if (element.phase == 's') { types = Arrays.asList("test_tube_", "ingot_", "powder_", "tiny_powder_", "nugget_"); }
			else { types = Arrays.asList("test_tube_"); }
				
			for (String type : types)
			{
				String path =  basePath + "GeneratedElementModels/" + type + element.name + ".json";
				try (Writer writer = new FileWriter(path))
				{
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					ItemJson itemJson = new ItemJson(type + element.name);
					gson.toJson(itemJson, writer);
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * DEVELOPMENT UTILITY
	 * @deprecated
	 */
	protected static class ItemJson
	{
		String parent;
		Textures textures;
			
		protected ItemJson(String name)
		{
			this.parent = "item/generated";
			this.textures = new Textures(name);
		}
		
		/**
		 * DEVELOPMENT UTILITY
		 * @deprecated
		 */
		protected class Textures
		{
			String layer0;
			
			protected Textures(String name)
			{
				this.layer0 = "chemcraft:items/" + name;
			}
			
		}
	}
	
	
	/**
	 * DEVELOPMENT UTILITY: 
	 * Generates an external lang file for elements.
	 * @deprecated
	 */
	public static void generateLang()
	{
		JsonObject jsonTubes = new JsonObject();
		JsonObject jsonIngots = new JsonObject();
		JsonObject jsonPowders = new JsonObject();
		JsonObject jsonTinyPowders = new JsonObject();
		JsonObject jsonNuggets = new JsonObject();
		

		for (Element element : Chemicals.ELEMENTS)
		{		
			String nameText = element.name.substring(0, 1).toUpperCase() + element.name.substring(1);
			
			jsonTubes.addProperty("item.chemcraft.test_tube_" + element.name, nameText + " (Test Tube)");
			
			if (element.phase == 's')
			{
				jsonIngots.addProperty("item.chemcraft.ingot_" + element.name, nameText + " Ingot");
				jsonPowders.addProperty("item.chemcraft.powder_" + element.name, nameText + " Powder");
				jsonTinyPowders.addProperty("item.chemcraft.tiny_powder_" + element.name, nameText + " Tiny Powder");
				jsonNuggets.addProperty("item.chemcraft.nugget_" + element.name, nameText + " Nugget");
			}
			
			String path =  "E:/Minecraft Modding/Chemcraft_1.15.2 Workspace/GeneratedElementLang/generatedLang.json";
			try (FileWriter writer = new FileWriter(path))
			{
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				gson.toJson(jsonTubes, writer);
				gson.toJson(jsonIngots, writer);
				gson.toJson(jsonPowders, writer);
				gson.toJson(jsonTinyPowders, writer);
				gson.toJson(jsonNuggets, writer);

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
