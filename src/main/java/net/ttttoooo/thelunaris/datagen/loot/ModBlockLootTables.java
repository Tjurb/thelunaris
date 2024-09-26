package net.ttttoooo.thelunaris.datagen.loot;

import java.util.Set;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
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
		
		this.dropSelf(ModBlocks.CELEST_WOOD.get());
		this.dropSelf(ModBlocks.CELEST_LEAVES.get());
		this.dropSelf(ModBlocks.CELEST_PLANKS.get());
		this.dropSelf(ModBlocks.CELEST_STAIRS.get());
		this.dropSelf(ModBlocks.STELLAR_WOOD.get());
		this.dropSelf(ModBlocks.STELLAR_LEAVES.get());
		this.dropSelf(ModBlocks.STELLAR_PLANKS.get());
		this.dropSelf(ModBlocks.STELLAR_STAIRS.get());
		this.dropSelf(ModBlocks.SKYOAK_WOOD.get());
		this.dropSelf(ModBlocks.SKYOAK_LEAVES.get());
		this.dropSelf(ModBlocks.SKYOAK_PLANKS.get());
		this.dropSelf(ModBlocks.SKYOAK_STAIRS.get());

		this.dropSelf(ModBlocks.LUNARITE_ORE.get());
		
		this.add(ModBlocks.VAILSTONEBRICK_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.VAILSTONEBRICK_SLAB.get()));
		this.add(ModBlocks.SMOOTHLUNARSLATE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHLUNARSLATE_SLAB.get()));
		this.add(ModBlocks.SMOOTHGNEISS_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHGNEISS_SLAB.get()));
		this.add(ModBlocks.SMOOTHMARBLE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SMOOTHMARBLE_SLAB.get()));
		
		this.add(ModBlocks.CELEST_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.CELEST_SLAB.get()));
		this.add(ModBlocks.STELLAR_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.STELLAR_SLAB.get()));
		this.add(ModBlocks.SKYOAK_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.SKYOAK_SLAB.get()));
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks(){
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
	
}
