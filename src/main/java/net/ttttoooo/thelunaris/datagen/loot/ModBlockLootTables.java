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
		this.dropSelf(ModBlocks.VAILSTONE_FURNACE.get());
		this.dropSelf(ModBlocks.LUNARIS_CRAFTING_TABLE.get());
		
		this.dropSelf(ModBlocks.LUNARITE_BLOCK.get());
		this.dropSelf(ModBlocks.LABRADORITE_BLOCK.get());
		this.dropSelf(ModBlocks.EMOONSTEEL_BLOCK.get());
		this.dropSelf(ModBlocks.MOONSTEEL_BLOCK.get());
		this.dropSelf(ModBlocks.RAW_MOONSTEEL_BLOCK.get());
		
		this.dropWhenSilkTouch(ModBlocks.LUNGLASS.get());
		this.dropWhenSilkTouch(ModBlocks.LUNGLASS_PANE.get());

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
		this.add(ModBlocks.LUNDIRT_FARMLAND.get(),
				block -> createGrassBlockLikeDrops(ModBlocks.LUNDIRT.get(), ModBlocks.LUNDIRT.get()));

		this.add(ModBlocks.LUNCLAY_BLOCK.get(),
				block -> createClayLikeDrops(ModBlocks.LUNCLAY_BLOCK.get(), ModItems.LUNAR_CLAY.get()));
		this.dropSelf(ModBlocks.LUNCLAY_BRICK_BLOCK.get());
		this.dropSelf(ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS.get());
		this.dropSelf(ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get());
		
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
		this.dropSelf(ModBlocks.CELEST_BUTTON.get());
		this.dropSelf(ModBlocks.CELEST_PRESSURE_PLATE.get());
		this.dropSelf(ModBlocks.CELEST_FENCE.get());
		this.dropSelf(ModBlocks.CELEST_FENCE_GATE.get());
		this.dropSelf(ModBlocks.CELEST_DOOR.get());
		this.dropSelf(ModBlocks.CELEST_TRAPDOOR.get());

		this.dropSelf(ModBlocks.STELLAR_LOG.get());
		this.dropSelf(ModBlocks.STELLAR_SAPLING.get());
		this.dropSelf(ModBlocks.STELLAR_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_STELLAR_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_STELLAR_WOOD.get());
		this.dropSelf(ModBlocks.STELLAR_PLANKS.get());
		this.dropSelf(ModBlocks.STELLAR_STAIRS.get());
		this.dropSelf(ModBlocks.STELLAR_BUTTON.get());
		this.dropSelf(ModBlocks.STELLAR_PRESSURE_PLATE.get());
		this.dropSelf(ModBlocks.STELLAR_FENCE.get());
		this.dropSelf(ModBlocks.STELLAR_FENCE_GATE.get());
		this.dropSelf(ModBlocks.STELLAR_DOOR.get());
		this.dropSelf(ModBlocks.STELLAR_TRAPDOOR.get());

		this.dropSelf(ModBlocks.SKYOAK_LOG.get());
		this.dropSelf(ModBlocks.SKYOAK_SAPLING.get());
		this.dropSelf(ModBlocks.SKYOAK_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_SKYOAK_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_SKYOAK_WOOD.get());
		this.dropSelf(ModBlocks.SKYOAK_PLANKS.get());
		this.dropSelf(ModBlocks.SKYOAK_STAIRS.get());
		this.dropSelf(ModBlocks.SKYOAK_BUTTON.get());
		this.dropSelf(ModBlocks.SKYOAK_PRESSURE_PLATE.get());
		this.dropSelf(ModBlocks.SKYOAK_FENCE.get());
		this.dropSelf(ModBlocks.SKYOAK_FENCE_GATE.get());
		this.dropSelf(ModBlocks.SKYOAK_DOOR.get());
		this.dropSelf(ModBlocks.SKYOAK_TRAPDOOR.get());
		
		this.add(ModBlocks.LUNARITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.LUNARITE_ORE.get(), ModItems.LUNARITE.get()));
		this.add(ModBlocks.MOONSTEEL_ORE.get(),
				block -> createIronLikeOreDrops(ModBlocks.MOONSTEEL_ORE.get(), ModItems.RAW_MOONSTEEL.get()));
		this.add(ModBlocks.LABRADORITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.LABRADORITE_ORE.get(), ModItems.LABRADORITE.get()));
		this.add(ModBlocks.LUNARIS_COAL_ORE.get(),
				block -> createIronLikeOreDrops(ModBlocks.LUNARIS_COAL_ORE.get(), Items.COAL));
		
		this.add(ModBlocks.DEEP_LUNARITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.DEEP_LUNARITE_ORE.get(), ModItems.LUNARITE.get()));
		this.add(ModBlocks.DEEP_MOONSTEEL_ORE.get(),
				block -> createIronLikeOreDrops(ModBlocks.DEEP_MOONSTEEL_ORE.get(), ModItems.RAW_MOONSTEEL.get()));
		this.add(ModBlocks.DEEP_LABRADORITE_ORE.get(),
				block -> createDiamondLikeOreDrops(ModBlocks.DEEP_LABRADORITE_ORE.get(), ModItems.LABRADORITE.get()));
		this.add(ModBlocks.DEEP_LUNARIS_COAL_ORE.get(),
				block -> createIronLikeOreDrops(ModBlocks.DEEP_LUNARIS_COAL_ORE.get(), Items.COAL));

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
		this.add(ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get(),
				block -> createSlabItemTable(ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get()));
		
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
		
		//Flower Blocks
		this.dropSelf(ModBlocks.ORANGEYE.get());
		this.dropSelf(ModBlocks.CYANEYE.get());
		this.dropSelf(ModBlocks.MAGENTEYE.get());
		this.dropSelf(ModBlocks.LUN_CLOVER.get());
		this.dropSelf(ModBlocks.BRAMBLE.get());
		
		//Potted Flowers
        this.add(ModBlocks.POTTED_ORANGEYE.get(), createPotFlowerItemTable(ModBlocks.ORANGEYE.get()));
        this.add(ModBlocks.POTTED_CYANEYE.get(), createPotFlowerItemTable(ModBlocks.CYANEYE.get()));
        this.add(ModBlocks.POTTED_MAGENTEYE.get(), createPotFlowerItemTable(ModBlocks.MAGENTEYE.get()));
        this.add(ModBlocks.POTTED_LUN_CLOVER.get(), createPotFlowerItemTable(ModBlocks.LUN_CLOVER.get()));
        this.add(ModBlocks.POTTED_BRAMBLE.get(), createPotFlowerItemTable(ModBlocks.BRAMBLE.get()));
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
	
	protected LootTable.Builder createClayLikeDrops(Block pBlock, Item item){
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0f, 6.0f)))
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
