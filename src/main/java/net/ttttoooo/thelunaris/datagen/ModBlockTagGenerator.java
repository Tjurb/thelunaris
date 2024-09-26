package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModBlockTagGenerator extends BlockTagsProvider{
	
	public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, TheLunaris.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		//
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(ModBlocks.VAILSTONE.get(),
					ModBlocks.VAILSTONEBRICK.get(),
					ModBlocks.VAILSTONEBRICK_STAIRS.get(),
					ModBlocks.VAILSTONEBRICK_SLAB.get(),
					ModBlocks.VAILSTONEBRICK_WALL.get(),
					ModBlocks.LUNARSHALE.get(),
					ModBlocks.LUNARSLATE.get(),
					ModBlocks.SMOOTHLUNARSLATE.get(),
					ModBlocks.SMOOTHLUNARSLATE_STAIRS.get(),
					ModBlocks.SMOOTHLUNARSLATE_SLAB.get(),
					ModBlocks.SMOOTHLUNARSLATE_WALL.get(),
					ModBlocks.GNEISS.get(),
					ModBlocks.SMOOTHGNEISS.get(),
					ModBlocks.SMOOTHGNEISS_STAIRS.get(),
					ModBlocks.SMOOTHGNEISS_SLAB.get(),
					ModBlocks.SMOOTHGNEISS_WALL.get(),
					ModBlocks.MARBLE.get(),
					ModBlocks.SMOOTHMARBLE.get(),
					ModBlocks.SMOOTHMARBLE_STAIRS.get(),
					ModBlocks.SMOOTHMARBLE_SLAB.get(),
					ModBlocks.SMOOTHMARBLE_WALL.get());
		
		this.tag(BlockTags.NEEDS_IRON_TOOL)
			.add(ModBlocks.MOONDIALBLOCK.get(),
					ModBlocks.LUNARITE_ORE.get());
		
		this.tag(BlockTags.WALLS)
			.add(ModBlocks.VAILSTONEBRICK_WALL.get(),
					ModBlocks.SMOOTHLUNARSLATE_WALL.get(),
					ModBlocks.SMOOTHGNEISS_WALL.get(),
					ModBlocks.SMOOTHMARBLE_WALL.get());
		
		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(ModBlocks.CELEST_WOOD.get(),
				ModBlocks.CELEST_PLANKS.get(),
				ModBlocks.CELEST_STAIRS.get(),
				ModBlocks.CELEST_SLAB.get(),
				
				ModBlocks.STELLAR_WOOD.get(),
				ModBlocks.STELLAR_PLANKS.get(),
				ModBlocks.STELLAR_STAIRS.get(),
				ModBlocks.STELLAR_SLAB.get(),
				
				ModBlocks.SKYOAK_WOOD.get(),
				ModBlocks.SKYOAK_PLANKS.get(),
				ModBlocks.SKYOAK_STAIRS.get(),
				ModBlocks.SKYOAK_SLAB.get());
		
		
	}
}
