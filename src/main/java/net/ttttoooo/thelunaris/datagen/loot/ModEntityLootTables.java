package net.ttttoooo.thelunaris.datagen.loot;

import java.util.Set;
import java.util.stream.Stream;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModEntityLootTables extends EntityLootSubProvider {

	public ModEntityLootTables() {
		super(FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate() {
		this.add(ModEntities.ARCHFISH.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.ARCHFISH.get())
						.when(LootItemRandomChanceCondition.randomChance(0.5F)))));
		
		this.add(ModEntities.MOONSNAIL.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.LUNAR_WHEAT_SEEDS.get())
						.when(LootItemRandomChanceCondition.randomChance(0.5F)))));
		
		this.add(ModEntities.MOONCOW.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
						.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BEEF)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
						.apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition
								.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
						.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
	      
		this.add(ModEntities.PHYREX.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER)
						.when(LootItemRandomChanceCondition.randomChance(0.5F)))));
		
		this.add(ModEntities.LUNARSLEEPER.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER)
						.when(LootItemRandomChanceCondition.randomChance(0.5F)))));
		
		this.add(ModEntities.HEX.get(), LootTable.lootTable().withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.HEXDUST.get())
						.when(LootItemRandomChanceCondition.randomChance(0.5F)))));
		
	}
	
	@Override
    public Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().flatMap(entityType -> Stream.of(entityType.get()));
    }
}
