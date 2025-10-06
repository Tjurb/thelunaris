package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.util.ModTags;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;

public class ModBiomeTagProvider extends BiomeTagsProvider{

	public ModBiomeTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, TheLunaris.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Biomes.IS_LUNARIS_BIOME)
        	.add(ModBiomes.AZUREITE_OCEAN,
        			ModBiomes.LUNAR_FORESTS,
        			ModBiomes.SKYWORD_MOUNTAINS,
        			ModBiomes.SLEEPING_SANDS,
        			ModBiomes.SHIMMERING_COAST,
        			ModBiomes.SAPPHIRE_RIVER,
        			
        			ModBiomes.CRIMSON_SHELFS,
        			ModBiomes.BARREN_DEEP,
        			ModBiomes.DUSKLIGHT_CAVES,
        			
        			ModBiomes.FORESTED_CAVES,
        			ModBiomes.FROZEN_CAVES,
        			ModBiomes.GRASSY_CAVES,
        			ModBiomes.FROZEN_COVER,
        			ModBiomes.HIGHTOP_JUNGLE);
        
        this.tag(ModTags.Biomes.IS_LUNARIS_MOUNTAIN)
        	.add(ModBiomes.SKYWORD_MOUNTAINS);
        
        this.tag(ModTags.Biomes.IS_LUNARIS_OCEAN)
        	.add(ModBiomes.AZUREITE_OCEAN);
        
        this.tag(ModTags.Biomes.IS_LUNARIS_COAST)
        	.add(ModBiomes.SHIMMERING_COAST);
	}

}
