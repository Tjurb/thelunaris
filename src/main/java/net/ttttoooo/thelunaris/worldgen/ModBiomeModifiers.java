package net.ttttoooo.thelunaris.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_CELEST = registerKey("add_tree_celest");
    public static final ResourceKey<BiomeModifier> ADD_TREE_STELLAR = registerKey("add_tree_stellar");
    public static final ResourceKey<BiomeModifier> ADD_TREE_SKYOAK = registerKey("add_tree_skyoak");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        
        context.register(ADD_TREE_CELEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CELEST_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        
        context.register(ADD_TREE_STELLAR, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STELLAR_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        
        context.register(ADD_TREE_SKYOAK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SKYOAK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(TheLunaris.MODID, name));
    }
}