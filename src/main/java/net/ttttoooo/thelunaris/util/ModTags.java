package net.ttttoooo.thelunaris.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModTags {
	public static class Blocks {
		public static final TagKey<Block> NEEDS_LUNARITE_TOOL = tag("needs_lunarite_tool");
		public static final TagKey<Block> NEEDS_EMOONSTEEL_TOOL = tag("needs_emoonsteel_tool");
		public static final TagKey<Block> NEEDS_MOONSTEEL_TOOL = tag("needs_moonsteel_tool");
		public static final TagKey<Block> NEEDS_VAILSTONE_TOOL = tag("needs_vailstone_tool");
		
		public static final TagKey<Block> VAILSTONE_ORE_REPLACEABLES = tag("vailstone_ore_replaceables");
		public static final TagKey<Block> GNEISS_ORE_REPLACEABLES = tag("gneiss_ore_replaceables");
		
		public static final TagKey<Block> LUNAR_PORTAL_BLOCKS = tag("lunar_portal_blocks");
		
		public static final TagKey<Block> LUNAR_PLANKS = tag("lunar_planks");
		
		private static TagKey<Block> tag(String name){
			return BlockTags.create(new ResourceLocation(TheLunaris.MODID, name));
		}
	}
	
	public static class Biomes {
	    public static final TagKey<Biome> IS_LUNARIS_BIOME = tag("is_lunaris_biome");
	    public static final TagKey<Biome> IS_LUNARIS_MOUNTAIN = tag("is_lunaris_mountian");
	    public static final TagKey<Biome> IS_LUNARIS_OCEAN = tag("is_lunaris_ocean");
	    public static final TagKey<Biome> IS_LUNARIS_COAST = tag("is_lunaris_coast");

	    private static TagKey<Biome> tag(String name) {
	        return TagKey.create(Registries.BIOME, new ResourceLocation(TheLunaris.MODID, name));
	    }
	}

	public static class Items {
		public static final TagKey<Item> MOONCOW_TEMP_ITEMS = tag("mooncow_temp_items");
		
		private static TagKey<Item> tag(String name){
			return ItemTags.create(new ResourceLocation(TheLunaris.MODID, name));
		}
	}
}

