package net.ttttoooo.thelunaris.datagen.loot;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;

public class ModFishingLootTable extends LootTableProvider{

	public ModFishingLootTable(PackOutput p_254123_, Set<ResourceLocation> p_254481_,
			List<SubProviderEntry> p_253798_) {
		super(p_254123_, p_254481_, p_253798_);
	}

}
