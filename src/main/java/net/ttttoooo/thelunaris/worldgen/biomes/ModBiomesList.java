package net.ttttoooo.thelunaris.worldgen.biomes;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomesList {
	public static final RegistryObject<Biome> AZURITE_OCEAN = registerBiome("azurite_ocean", createOceanBiome());
    public static final RegistryObject<Biome> SKYBORN_MOUNTAIN = registerBiome("skyborn_mountain", createMountainBiome());
    public static final RegistryObject<Biome> SLEEPING_SANDS = registerBiome("sleeping_sands", createDesertBiome());
    public static final RegistryObject<Biome> LUNAR_FOREST = registerBiome("lunar_forest", createForestBiome());

    private static RegistryObject<Biome> registerBiome(String name, Biome biome) {
        return ModBiomes.BIOMES.register(name, () -> biome);
    }
    
    private static Biome createOceanBiome() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(null, null);
        // Add ocean-specific features here

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        // Set up ocean mobs here

        return new Biome.BiomeBuilder()
            .temperature(0.5F)
            .downfall(0.5F)
            .hasPrecipitation(true)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(builder.build())
            .build();
    }
    
    private static Biome createMountainBiome() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(null, null);
        // Add mountain-specific features here

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        // Set up mountain mobs here

        return new Biome.BiomeBuilder()
            .temperature(0.3F)
            .downfall(0.5F)
            .hasPrecipitation(true)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(builder.build())
            .build();
    }
    
    private static Biome createDesertBiome() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(null, null);
        // Add desert-specific features here

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        // Set up desert mobs here

        return new Biome.BiomeBuilder()
            .temperature(0.7F)
            .downfall(0.3F)
            .hasPrecipitation(false)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(builder.build())
            .build();
    }
    
    private static Biome createForestBiome() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(null, null);
        // Add forest-specific features here

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        // Set up forest mobs here

        return new Biome.BiomeBuilder()
            .temperature(0.5F)
            .downfall(0.5F)
            .hasPrecipitation(true)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(builder.build())
            .build();
    }
}
