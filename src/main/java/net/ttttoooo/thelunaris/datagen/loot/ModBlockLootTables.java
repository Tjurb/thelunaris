package net.ttttoooo.thelunaris.datagen.loot;

import java.util.Set;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.block.custom.LoonBerryCropBlock;
import net.ttttoooo.thelunaris.block.custom.LunWheatCropBlock;
import net.ttttoooo.thelunaris.block.custom.SarrotCropBlock;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModBlockLootTables extends BlockLootSubProvider{

	public ModBlockLootTables() { 
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(ModBlocks.MOONDIALBLOCK.get());
		this.dropSelf(ModBlocks.LUNAR_CRAFTER.get());
		
		this.dropSelf(ModBlocks.LUNARITE_BLOCK.get());
		this.dropSelf(ModBlocks.LABRADORITE_BLOCK.get());
		this.dropSelf(ModBlocks.EMOONSTEEL_BLOCK.get());
		this.dropSelf(ModBlocks.MOONSTEEL_BLOCK.get());
		this.dropSelf(ModBlocks.RAW_MOONSTEEL_BLOCK.get());

		this.add(ModBlocks.VAILSTONE.get(),
				block -> createGrassBlockLikeDrops(ModBlocks.VAILSTONE.get(), ModBlocks.COBBLED_VAILSTONE.get()));
		this.dropSelf(ModBlocks.VAILSTONEBRICK.get());
		this.dropSelf(ModBlocks.VAILSTONEBRICK_STAIRS.get());
		this.dropSelf(ModBlocks.VAILSTONEBRICK_WALL.get());
		this.dropSelf(ModBlocks.COBBLED_VAILSTONE.get());
		this.dropSelf(ModBlocks.COBBLED_VAILSTONE_STAIRS.get());
		this.dropSelf(ModBlocks.COBBLED_VAILSTONE_WALL.get());
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
		
        LootItemCondition.Builder wheatCropLootContition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LUNWHEAT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LunWheatCropBlock.AGE, 5));

        this.add(ModBlocks.LUNWHEAT_CROP.get(), createCropDrops(ModBlocks.LUNWHEAT_CROP.get(), ModItems.LUNAR_WHEAT.get(),
                ModItems.LUNAR_WHEAT_SEEDS.get(), wheatCropLootContition$builder));
        
        LootItemCondition.Builder sarrotCropLootContition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SARROT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SarrotCropBlock.AGE, 5));

        this.add(ModBlocks.SARROT_CROP.get(), createCropDrops(ModBlocks.SARROT_CROP.get(), ModItems.SARROT.get(),
                ModItems.SARROT.get(), sarrotCropLootContition$builder));
		
        LootItemCondition.Builder loonBerryCropLootContition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LOONBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LoonBerryCropBlock.AGE, 3));

        this.add(ModBlocks.LOONBERRY_CROP.get(), createCropDrops(ModBlocks.LOONBERRY_CROP.get(), ModItems.LOONBERRY.get(),
                ModItems.LOONBERRY.get(), loonBerryCropLootContition$builder));

		this.add(ModBlocks.LUNGRASS_BLOCK.get(),
				block -> createGrassBlockLikeDrops(ModBlocks.LUNGRASS_BLOCK.get(), ModBlocks.LUNDIRT.get()));
		this.dropSelf(ModBlocks.LUNDIRT.get());
		this.dropSelf(ModBlocks.LUNSAND.get());
		this.dropSelf(ModBlocks.LUNSANDSTONE.get());
		this.dropSelf(ModBlocks.LUNSANDSTONE_STAIRS.get());
		this.dropSelf(ModBlocks.LUNSANDSTONE_WALL.get());

		this.dropSelf(ModBlocks.CELEST_LOG.get());
		this.dropSelf(ModBlocks.CELEST_SAPLING.get());
		this.dropSelf(ModBlocks.CELEST_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_CELEST_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_CELEST_WOOD.get());
		this.dropSelf(ModBlocks.CELEST_PLANKS.get());
		this.dropSelf(ModBlocks.CELEST_STAIRS.get());

		this.dropSelf(ModBlocks.STELLAR_LOG.get());
		this.dropSelf(ModBlocks.STELLAR_SAPLING.get());
		this.dropSelf(ModBlocks.STELLAR_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_STELLAR_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_STELLAR_WOOD.get());
		this.dropSelf(ModBlocks.STELLAR_PLANKS.get());
		this.dropSelf(ModBlocks.STELLAR_STAIRS.get());

		this.dropSelf(ModBlocks.SKYOAK_LOG.get());
		this.dropSelf(ModBlocks.SKYOAK_SAPLING.get());
		this.dropSelf(ModBlocks.SKYOAK_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_SKYOAK_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_SKYOAK_WOOD.get());
		this.dropSelf(ModBlocks.SKYOAK_PLANKS.get());
		this.dropSelf(ModBlocks.SKYOAK_STAIRS.get());
		
		this.add(ModBlocks.LUNARITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.LUNARITE_ORE.get(), ModItems.LUNARITE.get()));
		this.add(ModBlocks.MOONSTEEL_ORE.get(),
				block -> createIronLikeOreDrops(ModBlocks.MOONSTEEL_ORE.get(), ModItems.RAW_MOONSTEEL.get()));
		this.add(ModBlocks.LABRADORITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.LABRADORITE_ORE.get(), ModItems.LABRADORITE.get()));

		this.add(ModBlocks.COBBLED_VAILSTONE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.COBBLED_VAILSTONE_SLAB.get()));
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
		
		this.add(ModBlocks.LUNSANDSTONE_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.LUNSANDSTONE_SLAB.get()));
		
		//Leaf Blocks
		this.add(ModBlocks.STELLAR_LEAVES.get(), block ->
			createLeavesDrops(block, ModBlocks.STELLAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
		this.add(ModBlocks.CELEST_LEAVES.get(), block ->
			createLeavesDrops(block, ModBlocks.CELEST_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
		this.add(ModBlocks.SKYOAK_LEAVES.get(), block ->
			createLeavesDrops(block, ModBlocks.SKYOAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
		
		//Nature Blocks
		this.add(ModBlocks.LUNGRASS.get(), block ->
			createGrassLikeDrops(block));
		this.add(ModBlocks.WILD_LOONBERRY.get(), block ->
			createWildLoonberryDrops(block));
		this.add(ModBlocks.WILD_SARROT.get(), block ->
			createWildSarrotDrops(block));
	}
	
	protected LootTable.Builder createGrassLikeDrops(Block p_252139_) {
	      return createShearsDispatchTable(p_252139_, 
	    		  this.applyExplosionDecay(p_252139_, 
	    				  LootItem.lootTableItem(ModItems.LUNAR_WHEAT_SEEDS.get()).when(LootItemRandomChanceCondition.randomChance(0.125F))
	    				  .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
	}
	
	protected LootTable.Builder createWildLoonberryDrops(Block p_252139_) {
	      return createShearsDispatchTable(p_252139_, 
	    		  this.applyExplosionDecay(p_252139_, 
	    				  LootItem.lootTableItem(ModItems.LOONBERRY.get()).when(LootItemRandomChanceCondition.randomChance(0.125F))
	    				  .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
	}
	
	protected LootTable.Builder createWildSarrotDrops(Block p_252139_) {
	      return createShearsDispatchTable(p_252139_, 
	    		  this.applyExplosionDecay(p_252139_, 
	    				  LootItem.lootTableItem(ModItems.SARROT.get()).when(LootItemRandomChanceCondition.randomChance(0.125F))
	    				  .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
	}
	
	protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item){
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)))
						.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}
	
	protected LootTable.Builder createIronLikeOreDrops(Block pBlock, Item item){
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
						.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}
	
	protected LootTable.Builder createGrassBlockLikeDrops(Block pBlock, Block Block){
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(Block)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)))));
	}
	
	protected Iterable<Block> getKnownBlocks(){
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
	
}
