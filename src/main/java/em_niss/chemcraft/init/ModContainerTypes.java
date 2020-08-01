package em_niss.chemcraft.init;

import em_niss.chemcraft.Chemcraft;
import em_niss.chemcraft.objects.containers.ContainerElectrolyzer;
import em_niss.chemcraft.objects.containers.ContainerHydrogenGenerator;
import em_niss.chemcraft.objects.containers.FirstBlockContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes
{
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Chemcraft.MODID);
	
	public static final RegistryObject<ContainerType<ContainerElectrolyzer>> CONTAINER_ELECTROLYZER = CONTAINERS.register("electrolyzer", () -> IForgeContainerType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		World world = inv.player.getEntityWorld();
		return new ContainerElectrolyzer(windowId, world, pos, inv, inv.player);
	}));
	
	public static final RegistryObject<ContainerType<ContainerHydrogenGenerator>> CONTAINER_HYDROGEN_GENERATOR = CONTAINERS.register("hydrogen_generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		World world = inv.player.getEntityWorld();
		return new ContainerHydrogenGenerator(windowId, world, pos, inv, inv.player);
	}));
	
	public static final RegistryObject<ContainerType<FirstBlockContainer>> FIRSTBLOCK_CONTAINER = CONTAINERS.register("firstblock", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new FirstBlockContainer(windowId, world, pos, inv, inv.player);
    }));
}
