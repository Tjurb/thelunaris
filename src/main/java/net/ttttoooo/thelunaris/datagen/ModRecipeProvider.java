package net.ttttoooo.thelunaris.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
	public static final List<ItemLike> LUNARITE_SMELTABLES = List.of(ModBlocks.LUNARITE_ORE.get());
	public static final List<ItemLike> MOONSTEEL_SMELTABLES = List.of(ModBlocks.MOONSTEEL_ORE.get(),
			ModItems.RAW_MOONSTEEL.get());
	public static final List<ItemLike> LABRADORITE_SMELTABLES = List.of(ModBlocks.LABRADORITE_ORE.get());

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {	
		oreSmelting(pWriter, LUNARITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.25f, 100, "lunarite" );
		oreBlasting(pWriter, LUNARITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.25f, 90, "lunarite" );
		oreSmelting(pWriter, MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL.get(), 0.15f, 100, "moonsteel" );
		oreBlasting(pWriter, MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL.get(), 0.15f, 90, "moonsteel" );
		oreSmelting(pWriter, LABRADORITE_SMELTABLES, RecipeCategory.MISC, ModItems.LABRADORITE.get(), 0.10f, 100, "labradorite" );
		oreBlasting(pWriter, LABRADORITE_SMELTABLES, RecipeCategory.MISC, ModItems.LABRADORITE.get(), 0.10f, 90, "labradorite" );
	}
	
	protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
	      oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
	}
	protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
	      oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
	}
	protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
		for(ItemLike itemlike : p_249619_) {
	         SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_,
	        		 p_251871_, p_251316_, p_251817_)
	         		.group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike))
	         		.save(p_250791_, TheLunaris.MODID + ":" + getItemName(p_250066_) + p_249236_ + "_" + getItemName(itemlike));
	    }
	}

}
