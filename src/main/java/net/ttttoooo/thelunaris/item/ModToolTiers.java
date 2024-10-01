package net.ttttoooo.thelunaris.item;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModToolTiers {
	public static final Tier MOONSTEEL = TierSortingRegistry.registerTier(
			new ForgeTier(2, 400, 6f, 2f, 12,
					ModTags.Blocks.NEEDS_MOONSTEEL_TOOL, () -> Ingredient.of(ModItems.MOONSTEEL.get())),
			new ResourceLocation(TheLunaris.MODID, "moonsteel"), List.of(Tiers.WOOD), List.of(Tiers.DIAMOND));
	
	public static final Tier EMOONSTEEL = TierSortingRegistry.registerTier(
			new ForgeTier(3, 1500, 8f, 3f, 15,
					ModTags.Blocks.NEEDS_EMOONSTEEL_TOOL, () -> Ingredient.of(ModItems.EMOONSTEEL.get())),
			new ResourceLocation(TheLunaris.MODID, "emoonsteel"), List.of(Tiers.IRON), List.of(Tiers.NETHERITE));
	
	public static final Tier LUNARITE = TierSortingRegistry.registerTier(
			new ForgeTier(5, 2200, 10f, 5f, 20,
					ModTags.Blocks.NEEDS_LUNARITE_TOOL, () -> Ingredient.of(ModItems.LUNARITE.get())),
			new ResourceLocation(TheLunaris.MODID, "lunarite"), List.of(Tiers.NETHERITE), List.of());
}
