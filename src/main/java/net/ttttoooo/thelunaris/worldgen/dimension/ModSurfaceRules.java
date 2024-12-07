package net.ttttoooo.thelunaris.worldgen.dimension;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;
import net.minecraft.world.level.block.Block;

public class ModSurfaceRules {
	private static final SurfaceRules.RuleSource LUNDIRT = makeStateRule(ModBlocks.LUNDIRT.get());
    private static final SurfaceRules.RuleSource LUNGRASS_BLOCK = makeStateRule(ModBlocks.LUNGRASS_BLOCK.get());
	private static final SurfaceRules.RuleSource LUNSAND = makeStateRule(ModBlocks.LUNSAND.get());
    private static final SurfaceRules.RuleSource LUNSANDSTONE = makeStateRule(ModBlocks.LUNSANDSTONE.get());
    private static final SurfaceRules.RuleSource LUNARBEDROCK = makeStateRule(ModBlocks.LUNARIS_BEDROCK.get());
    private static final SurfaceRules.RuleSource GNEISS = makeStateRule(ModBlocks.GNEISS.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        
        SurfaceRules.ConditionSource isAtBedrockLevel = SurfaceRules.verticalGradient("bedrock_floor",VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5));
        SurfaceRules.ConditionSource isAtGneissLevel = SurfaceRules.verticalGradient("gneiss_layer",VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));

        SurfaceRules.RuleSource sandOcean = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNSAND), LUNDIRT);
        SurfaceRules.RuleSource sandSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNSAND), LUNSAND);
        SurfaceRules.RuleSource sandstoneSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNSANDSTONE), LUNSANDSTONE);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNGRASS_BLOCK), LUNDIRT);
        SurfaceRules.RuleSource dirtSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNDIRT), LUNDIRT);
        SurfaceRules.RuleSource bedrockFill = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtBedrockLevel, LUNARBEDROCK));
        SurfaceRules.RuleSource deepfill = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtGneissLevel, GNEISS));
        
        return SurfaceRules.sequence(
        		SurfaceRules.sequence(SurfaceRules.ifTrue(isAtBedrockLevel, bedrockFill)),
        		
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LUNAR_FORESTS), 
                	SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LUNAR_FORESTS), 
                    	SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, dirtSurface)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SAPPHIRE_RIVER), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, dirtSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SAPPHIRE_RIVER), 
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, dirtSurface)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SHIMMERING_COAST), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, sandSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SHIMMERING_COAST), 
                    	SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, sandstoneSurface)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AZUREITE_OCEAN), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, sandOcean)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AZUREITE_OCEAN), 
                    	SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, sandOcean)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SKYWORD_MOUNTAINS), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SKYWORD_MOUNTAINS), 
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, dirtSurface)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLEEPING_SANDS), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, sandSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLEEPING_SANDS), 
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, sandstoneSurface)
                    )),
        		

        		SurfaceRules.sequence(SurfaceRules.ifTrue(isAtGneissLevel, deepfill))
        		
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
