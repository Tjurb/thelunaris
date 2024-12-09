package net.ttttoooo.thelunaris.worldgen.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.datagen.builders.LunarisBiomeBuilder;

public class ModBiomes {
	public static final ResourceKey<Biome> AZUREITE_OCEAN = createKey("azureite_ocean");
	public static final ResourceKey<Biome> LUNAR_FORESTS = createKey("lunar_forests");
	public static final ResourceKey<Biome> SLEEPING_SANDS = createKey("sleeping_sands");
	public static final ResourceKey<Biome> SKYWORD_MOUNTAINS = createKey("skyword_mountains");
	public static final ResourceKey<Biome> SHIMMERING_COAST = createKey("shimmering_coast");
	public static final ResourceKey<Biome> SAPPHIRE_RIVER = createKey("sapphire_river");
	public static final ResourceKey<Biome> DUSKLIGHT_CAVES = createKey("dusklight_caves");
	public static final ResourceKey<Biome> CRIMSON_SHELFS = createKey("crimson_shelfs");
	public static final ResourceKey<Biome> BARREN_DEEP = createKey("barren_deep");

	private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(TheLunaris.MODID, name));
    }
	
    public static void boostrap(BootstapContext<Biome> context) {
    	HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> vanillaConfiguredCarvers = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(AZUREITE_OCEAN, LunarisBiomeBuilder.azureocean(placedFeatures, vanillaConfiguredCarvers));
        context.register(LUNAR_FORESTS, LunarisBiomeBuilder.lunarforest(placedFeatures, vanillaConfiguredCarvers));
        context.register(SLEEPING_SANDS, LunarisBiomeBuilder.sleepingsands(placedFeatures, vanillaConfiguredCarvers));
        context.register(SKYWORD_MOUNTAINS, LunarisBiomeBuilder.skymountain(placedFeatures, vanillaConfiguredCarvers));
        
        context.register(SHIMMERING_COAST, LunarisBiomeBuilder.shimmeringcoast(placedFeatures, vanillaConfiguredCarvers));
        context.register(SAPPHIRE_RIVER, LunarisBiomeBuilder.sapphireriver(placedFeatures, vanillaConfiguredCarvers));
        
        context.register(DUSKLIGHT_CAVES, LunarisBiomeBuilder.dusklightcave(placedFeatures, vanillaConfiguredCarvers));
        context.register(CRIMSON_SHELFS, LunarisBiomeBuilder.crimsonshelf(placedFeatures, vanillaConfiguredCarvers));
        context.register(BARREN_DEEP, LunarisBiomeBuilder.barrendeep(placedFeatures, vanillaConfiguredCarvers));
    }
}