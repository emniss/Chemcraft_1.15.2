package em_niss.chemcraft.datagen;

import em_niss.chemcraft.Chemcraft;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder.FaceRotation;
import net.minecraftforge.client.model.generators.ModelBuilder.Perspective;
import net.minecraftforge.client.model.generators.ModelFile;

public class HydrogenGenerator 
{
	public static BlockModelBuilder createModel(BlockModelBuilder builder, String state, int power)
	{		
		builder.element().
		
		builder.texture("txtfront", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_front_"));
		builder.texture("txtback", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_back"));
		builder.texture("txtup", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_up"));
		builder.texture("txtdown", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_down"));
		builder.texture("txtside", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_side"));
		builder.texture("txtblank", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_blank"));
		builder.texture("particle", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_side"));

		builder.element().from(3, 0, 0).to(13, 16, 16)
				.face(Direction.NORTH).texture("#txtfront").uvs(3, 0, 13, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 16, 16).end()
				.face(Direction.SOUTH).texture("#txtback").uvs(3, 0, 13, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 16, 16).end()
				.face(Direction.UP).texture("#txtup").uvs(3, 0, 13, 16).rotation(FaceRotation.UPSIDE_DOWN).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(3, 0, 13, 16).end()
				.end();
		
		builder.element().from(2, 0, 1).to(3, 16, 15)
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 14, 16).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtside").uvs(1, 0, 15, 16).end()
				.face(Direction.UP).texture("#txtdown").uvs(3, 0, 13, 16).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(15, 1, 16, 15).end()
				.end();
					
		builder.element().from(13, 0, 1).to(14, 16, 15)
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtside").uvs(1, 0, 15, 16).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 14, 16).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 1, 1, 15).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 1, 1, 15).end()
				.end();
		
		builder.element().from(2.15f, 0, 0.35f).to(3.56f, 16, 1.35f).rotation().angle(45).axis(Axis.Y).origin(2.855f, 7.5f, 0.85f).end()
				.face(Direction.NORTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(2.15f, 0, 14.65f).to(3.56f, 16, 15.65f).rotation().angle(-45).axis(Axis.Y).origin(2.855f, 7.5f, 15.15f).end()
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(12.44f, 0, 0.35f).to(13.85f, 16, 1.35f).rotation().angle(-45).axis(Axis.Y).origin(13.145f, 7.5f, 0.85f).end()
				.face(Direction.NORTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(12.44f, 0, 14.65f).to(13.85f, 16, 15.65f).rotation().angle(45).axis(Axis.Y).origin(13.145f, 7.5f, 15.15f).end()
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.transforms().transform(Perspective.THIRDPERSON_RIGHT).rotation(75, 45, 0).translation(0, 2.5f, 0).scale(0.375f).end();
		builder.transforms().transform(Perspective.THIRDPERSON_LEFT).rotation(75, 45, 0).translation(0, 2.5f, 0).scale(0.375f).end();
		builder.transforms().transform(Perspective.FIRSTPERSON_RIGHT).rotation(0, 45, 0).scale(-0.4f, 0.4f, -0.4f).end();
		builder.transforms().transform(Perspective.FIRSTPERSON_LEFT).rotation(0, 225, 0).scale(0.4f, 0.4f, 0.4f).end();
		builder.transforms().transform(Perspective.GROUND).translation(0, 3.0f, 0).scale(0.25f).end();
		builder.transforms().transform(Perspective.GUI).rotation(30, 225, 0).scale(0.625f).end();
		builder.transforms().transform(Perspective.HEAD).scale(1.1f).end();
		builder.transforms().transform(Perspective.FIXED).scale(0.5f).end();
		
		return builder;
	}

	public static ModelFile createMainModel(BlockModelBuilder builder, String string, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/*public static BlockModelBuilder createMainModel(BlockModelBuilder builder, String state, int power)
	{	
		builder.texture("txtfront", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_front_" + state + "_" + power));
		builder.texture("txtback", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_back"));
		builder.texture("txtup", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_up"));
		builder.texture("txtdown", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_down"));
		builder.texture("txtblank", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_blank"));
		builder.texture("txton", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_on"));
		builder.texture("txtoff", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_off"));
		builder.texture("txtpower", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_power"));

		builder.element().from(3, 0, 0).to(13, 16, 16)
				.face(Direction.NORTH).texture("#txtfront").uvs(3, 0, 13, 16).texture("#txtpower").uvs(3 + 16 * power, 0, 13 + 16 * power, 16).texture("#txt" + state).uvs(3, 0, 13, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 16, 16).end()
				.face(Direction.SOUTH).texture("#txtback").uvs(3, 0, 13, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 16, 16).end()
				.face(Direction.UP).texture("#txtup").uvs(3, 0, 13, 16).rotation(FaceRotation.UPSIDE_DOWN).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(3, 0, 13, 16).end()
				.end();
		
		return builder;
	}
	
	public static BlockModelBuilder createFrameModel(BlockModelBuilder builder)
	{
		builder.texture("txtside", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_side"));
		builder.texture("txtdown", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_down"));
		builder.texture("txtblank", new ResourceLocation(Chemcraft.MODID, "blocks/hydrogen_generator/hydrogen_generator_blank"));
		
		builder.element().from(2, 0, 1).to(3, 16, 15)
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 14, 16).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtside").uvs(1, 0, 15, 16).end()
				.face(Direction.UP).texture("#txtdown").uvs(3, 0, 13, 16).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(15, 1, 16, 15).end()
				.end();
					
		builder.element().from(13, 0, 1).to(14, 16, 15)
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtside").uvs(1, 0, 15, 16).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 14, 16).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 1, 1, 15).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 1, 1, 15).end()
				.end();
		
		builder.element().from(2.15f, 0, 0.35f).to(3.56f, 16, 1.35f).rotation().angle(45).axis(Axis.Y).origin(2.855f, 7.5f, 0.85f).end()
				.face(Direction.NORTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(2.15f, 0, 14.65f).to(3.56f, 16, 15.65f).rotation().angle(-45).axis(Axis.Y).origin(2.855f, 7.5f, 15.15f).end()
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(12.44f, 0, 0.35f).to(13.85f, 16, 1.35f).rotation().angle(-45).axis(Axis.Y).origin(13.145f, 7.5f, 0.85f).end()
				.face(Direction.NORTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		builder.element().from(12.44f, 0, 14.65f).to(13.85f, 16, 15.65f).rotation().angle(45).axis(Axis.Y).origin(13.145f, 7.5f, 15.15f).end()
				.face(Direction.NORTH).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.EAST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.SOUTH).texture("#txtdown").uvs(0, 0, 1, 16).end()
				.face(Direction.WEST).texture("#txtblank").uvs(0, 0, 1, 1).end()
				.face(Direction.UP).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.face(Direction.DOWN).texture("#txtdown").uvs(0, 0, 1, 1).end()
				.end();
		
		return builder;
	}*/
}
