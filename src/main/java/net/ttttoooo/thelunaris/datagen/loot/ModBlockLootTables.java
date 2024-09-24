package net.ttttoooo.thelunaris.datagen.loot;

import java.util.Set;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModBlockLootTables extends BlockLootSubProvider{

	public ModBlockLootTables() { 
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(ModBlocks.MOONDIALBLOCK.get());
		
		this.dropSelf(ModBlocks.VAILSTONE.get());
		this.dropSelf(ModBlocks.VAILSTONEBRICK.get());
		this.dropSelf(ModBlocks.VAILSTONEBRICK_STAIRS.get());
		this.dropSelf(ModBlocks.VAILSTONEBRICK_WALL.get());
		this.dropSelf(ModBlocks.LUNARSHALE.get());
		this.dropSelf(ModBlocks.LUNARSLATE.get());
		this.dropSelf(ModBlocks.SMOOTHLUNARSLATE.get());
		this.dropSelf(ModBlocks.SMOOTHLUNARSLATE_STAIRS.get());
		this.dropSelf(ModBlocks.SMOOTHLUNARSLATE_WALL.get());
		this.dropSelf(ModBlocks.GNEISS.get());
		this.dropSelf(ModBlocks.SMOOTHGNEISS.get());
		this.dropSelf(ModBlocks.SMOOTHGNEISS_STAIRS.get());
		this.dropSelf(ModBlocks.SMOOTHGNEISS_WALL.get());
		this.dropSelf(ModBlocks.MARBLE.get());
		this.dropSelf(ModBlocks.SMOOTHMARBLE.get());
		this.dropSelf(ModBlocks.SMOOTHMARBLE_STAIRS.get());
		this.dropSelf(ModBlocks.SMOOTHMARBLE_WALL.get());
		
		this.add(ModBlocks.VAILSTONEBRICK_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.VAILSTONEBRICK_SLAB.get()));
		this.add(ModBlocks.SMOOTHLUNARSLATE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHLUNARSLATE_SLAB.get()));
		this.add(ModBlocks.SMOOTHGNEISS_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHGNEISS_SLAB.get()));
		this.add(ModBlocks.SMOOTHMARBLE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHMARBLE_SLAB.get()));
	}
	
}
