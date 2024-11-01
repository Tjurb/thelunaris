package net.ttttoooo.thelunaris.datagen.loot;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModLoot {
	private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();
	public static final Set<ResourceLocation> IMMUTABLE_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
	
	private static ResourceLocation register(String id) {
		return register(new ResourceLocation(TheLunaris.MODID, id));
	}
	
	private static ResourceLocation register(ResourceLocation id) {
		if (LOOT_TABLES.add(id)) {
			return id;
		} else {
			throw new IllegalArgumentException(id + " is already a registered built-in loot table");
		}
	}


}
