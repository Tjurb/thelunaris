package net.ttttoooo.thelunaris.worldgen.dimension;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;
import net.minecraft.world.level.block.Block;

public class ModSurfaceRules {
	private static final SurfaceRules.RuleSource LUNDIRT = makeStateRule(ModBlocks.LUNDIRT.get());
    private static final SurfaceRules.RuleSource LUNGRASS = makeStateRule(ModBlocks.LUNGRASS.get());
	private static final SurfaceRules.RuleSource LUNSAND = makeStateRule(ModBlocks.LUNSAND.get());
    private static final SurfaceRules.RuleSource LUNSANDSTONE = makeStateRule(ModBlocks.LUNSANDSTONE.get());
    private static final SurfaceRules.RuleSource LUNARBEDROCK = makeStateRule(ModBlocks.LUNARIS_BEDROCK.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource isAtBedrockLevel = SurfaceRules.verticalGradient("bedrock_floor",VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5));

        SurfaceRules.RuleSource sandOcean = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNSAND), LUNDIRT);
        SurfaceRules.RuleSource sandSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNSAND), LUNSANDSTONE);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, LUNGRASS), LUNDIRT);
        SurfaceRules.RuleSource bedrockFill = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtBedrockLevel, LUNARBEDROCK));
        
        return SurfaceRules.sequence(
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LUNAR_FORESTS), 
                	SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LUNAR_FORESTS), 
                    	SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, bedrockFill)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AZUREITE_OCEAN), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, sandOcean)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AZUREITE_OCEAN), 
                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, bedrockFill)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SKYWORD_MOUNTAINS), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SKYWORD_MOUNTAINS), 
                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, bedrockFill)
                    )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLEEPING_SANDS), 
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, sandSurface)
                )),
        		SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLEEPING_SANDS), 
                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, bedrockFill)
                    ))
        		
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
