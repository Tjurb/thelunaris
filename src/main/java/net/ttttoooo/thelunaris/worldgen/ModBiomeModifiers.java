package net.ttttoooo.thelunaris.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_MOONSTEEL_ORE = registerKey("add_moonsteel_ore");
    public static final ResourceKey<BiomeModifier> ADD_LABRADORITE_ORE = registerKey("add_labradorite_ore");
    public static final ResourceKey<BiomeModifier> ADD_LUNARITE_ORE = registerKey("add_lunarite_ore");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_MOONSTEEL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),//Set to IS_OVERWORLD TO PREVENT ERRORS
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LABRADORITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),//Set to IS_OVERWORLD TO PREVENT ERRORS
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUNARIS_LABRADORITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LUNARITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));//Set to IS_OVERWORLD TO PREVENT ERRORS
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(TheLunaris.MODID, name));
    }
}