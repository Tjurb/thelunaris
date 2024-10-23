package net.ttttoooo.thelunaris.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModTags {
	public static class Blocks {
		public static final TagKey<Block> NEEDS_LUNARITE_TOOL = tag("needs_lunarite_tool");
		public static final TagKey<Block> NEEDS_EMOONSTEEL_TOOL = tag("needs_emoonsteel_tool");
		public static final TagKey<Block> NEEDS_MOONSTEEL_TOOL = tag("needs_moonsteel_tool");
		public static final TagKey<Block> NEEDS_VAILSTONE_TOOL = tag("needs_vailstone_tool");
		
		public static final TagKey<Block> VAILSTONE_ORE_REPLACEABLES = tag("vailstone_ore_replaceables");
		
		public static final TagKey<Block> LUNAR_PORTAL_BLOCKS = tag("lunar_portal_blocks");
		
		private static TagKey<Block> tag(String name){
			return BlockTags.create(new ResourceLocation(TheLunaris.MODID, name));
		}
	}
}
