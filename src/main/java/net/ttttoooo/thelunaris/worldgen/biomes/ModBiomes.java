package net.ttttoooo.thelunaris.worldgen.biomes;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, TheLunaris.MODID);

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
