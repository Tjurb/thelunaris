package net.ttttoooo.thelunaris.worldgen.dimension;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

import java.util.Set;

public class ModPoi {
    public static final DeferredRegister<PoiType> POI = 
    		DeferredRegister.create(ForgeRegistries.POI_TYPES, TheLunaris.MODID);

    public static final RegistryObject<PoiType> LUNAR_PORTAL = POI.register("lunar_portal", 
    		() -> new PoiType(getBlockStates(ModBlocks.LUNARPORTAL_BLOCK.get()), 0, 1));

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }
    
    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
