package em_niss.chemcraft.objects.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class ModelLoaderElectrolyzer implements IModelLoader<ModelGeometryElectrolyzer>
{
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{
		
	}
	
	@Override
	public ModelGeometryElectrolyzer read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
		return new ModelGeometryElectrolyzer();
	}
}
