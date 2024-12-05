package net.ttttoooo.thelunaris.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
	public static final List<ItemLike> LUNARITE_SMELTABLES = List.of(ModBlocks.LUNARITE_ORE.get(),
			ModBlocks.DEEP_LUNARITE_ORE.get());
	public static final List<ItemLike> MOONSTEEL_SMELTABLES = List.of(ModBlocks.MOONSTEEL_ORE.get(),
			ModBlocks.DEEP_MOONSTEEL_ORE.get(),
			ModItems.RAW_MOONSTEEL.get());
	public static final List<ItemLike> LABRADORITE_SMELTABLES = List.of(ModBlocks.LABRADORITE_ORE.get(),
			ModBlocks.DEEP_LABRADORITE_ORE.get());
	public static final List<ItemLike> LUNARIS_COAL_SMELTABLES = List.of(ModBlocks.LUNARIS_COAL_ORE.get(),
			ModBlocks.DEEP_LUNARIS_COAL_ORE.get());

	public static final List<ItemLike> LUNGLASS_SMELTABLES = List.of(ModBlocks.LUNSAND.get());
	public static final List<ItemLike> LUNAR_CHARCOAL = List.of(ModBlocks.CELEST_LOG.get(),
			ModBlocks.STRIPPED_CELEST_LOG.get(),
			ModBlocks.SKYOAK_LOG.get(),
			ModBlocks.STRIPPED_SKYOAK_LOG.get(),
			ModBlocks.STELLAR_LOG.get(),
			ModBlocks.STRIPPED_STELLAR_LOG.get());
	
	public static final List<ItemLike> STONELIKE_SMELTABLES = List.of(ModBlocks.COBBLED_VAILSTONE.get());
	public static final List<ItemLike> GNEISS_SMELTABLES = List.of(ModBlocks.GNEISS.get());
	public static final List<ItemLike> MARBLE_SMELTABLES = List.of(ModBlocks.MARBLE.get());
	public static final List<ItemLike> SLATE_SMELTABLES = List.of(ModBlocks.LUNARSLATE.get());
	public static final List<ItemLike> SHALE_SMELTABLES = List.of(ModBlocks.LUNARSHALE.get());
	
	public static final List<ItemLike> ARCHFISH_COOKING = List.of(ModItems.ARCHFISH.get());

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {	
		oreSmelting(pWriter, LUNARIS_COAL_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.10f, 150, "lunaris_coal" );
		oreBlasting(pWriter, LUNARIS_COAL_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.10f, 40, "lunaris_coal" );
		oreSmelting(pWriter, LUNARITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.25f, 200, "lunarite" );
		oreBlasting(pWriter, LUNARITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNARITE.get(), 0.25f, 150, "lunarite" );
		oreSmelting(pWriter, MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL.get(), 0.15f, 200, "moonsteel" );
		oreBlasting(pWriter, MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL.get(), 0.15f, 150, "moonsteel" );
		oreSmelting(pWriter, LABRADORITE_SMELTABLES, RecipeCategory.MISC, ModItems.LABRADORITE.get(), 0.10f, 200, "labradorite" );
		oreBlasting(pWriter, LABRADORITE_SMELTABLES, RecipeCategory.MISC, ModItems.LABRADORITE.get(), 0.10f, 150, "labradorite" );
		
		oreSmelting(pWriter, LUNGLASS_SMELTABLES, RecipeCategory.MISC, ModBlocks.LUNGLASS.get(), 0.10f, 200, "lunglass" );
		oreSmelting(pWriter, LUNAR_CHARCOAL, RecipeCategory.MISC, Items.CHARCOAL, 0.10f, 200, "lunar_charcoal" );
		
		oreSmelting(pWriter, STONELIKE_SMELTABLES, RecipeCategory.MISC, ModBlocks.VAILSTONE.get(), 0.10f, 200, "vailstone" );
		oreSmelting(pWriter, GNEISS_SMELTABLES, RecipeCategory.MISC, ModBlocks.SMOOTHGNEISS.get(), 0.10f, 200, "smooth_gneiss" );
		oreSmelting(pWriter, MARBLE_SMELTABLES, RecipeCategory.MISC, ModBlocks.SMOOTHMARBLE.get(), 0.10f, 200, "smooth_marble" );
		oreSmelting(pWriter, SLATE_SMELTABLES, RecipeCategory.MISC, ModBlocks.SMOOTHLUNARSLATE.get(), 0.10f, 200, "smooth_lunarslate" );
		oreSmelting(pWriter, SHALE_SMELTABLES, RecipeCategory.MISC, ModBlocks.LUNARSLATE.get(), 0.10f, 200, "lunarslate" );
		
		oreSmelting(pWriter, ARCHFISH_COOKING, RecipeCategory.MISC, ModItems.COOKED_ARCHFISH.get(), 0.20f, 200, "archfish" );
		foodSmoking(pWriter, ARCHFISH_COOKING, RecipeCategory.MISC, ModItems.COOKED_ARCHFISH.get(), 0.20f, 150, "archfish" );
	
		//High level Foods
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPICY_ARCHFISH.get(),4 )
			.pattern("   ")
			.pattern("SAS")
			.pattern("SSS")
			.define('A', ModItems.COOKED_ARCHFISH.get())
			.define('S', ModItems.SARROT.get())
			.unlockedBy(getHasName(ModItems.SARROT.get()), has(ModItems.SARROT.get()))
			.unlockedBy(getHasName(ModItems.COOKED_ARCHFISH.get()), has(ModItems.COOKED_ARCHFISH.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LOONBERRY_PIE.get(),4 )
			.pattern("   ")
			.pattern("LLL")
			.pattern("WWW")
			.define('L', ModItems.LOONBERRY.get())
			.define('W', ModItems.LUNAR_WHEAT.get())
			.unlockedBy(getHasName(ModItems.LOONBERRY.get()), has(ModItems.LOONBERRY.get()))
			.unlockedBy(getHasName(ModItems.LUNAR_WHEAT.get()), has(ModItems.LUNAR_WHEAT.get()))
			.save(pWriter);
		
		//Moonsteel Armors
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONSTEEL_HELMET.get(),1 )
			.pattern("   ")
			.pattern("MMM")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONSTEEL_CHESTPLATE.get(),1 )
			.pattern("M M")
			.pattern("MMM")
			.pattern("MMM")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONSTEEL_LEGGINGS.get(),1 )
			.pattern("MMM")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONSTEEL_BOOTS.get(),1 )
			.pattern("   ")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		
		//Ethereal Moonsteel Armor
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMOONSTEEL_HELMET.get(),1 )
			.pattern("   ")
			.pattern("MMM")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMOONSTEEL_CHESTPLATE.get(),1 )
			.pattern("M M")
			.pattern("MMM")
			.pattern("MMM")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMOONSTEEL_LEGGINGS.get(),1 )
			.pattern("MMM")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMOONSTEEL_BOOTS.get(),1 )
			.pattern("   ")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		
		//Lunarite Armor
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LUNARITE_HELMET.get(),1 )
			.pattern("   ")
			.pattern("LLL")
			.pattern("LML")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_HELMET.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LUNARITE_CHESTPLATE.get(),1 )
			.pattern("LML")
			.pattern("LLL")
			.pattern("LLL")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_CHESTPLATE.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LUNARITE_LEGGINGS.get(),1 )
			.pattern("LLL")
			.pattern("LML")
			.pattern("L L")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_LEGGINGS.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LUNARITE_BOOTS.get(),1 )
			.pattern("   ")
			.pattern("LML")
			.pattern("L L")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_BOOTS.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		
		//Lunarite Tools
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LUNARITE_AXE.get(),1 )
			.pattern("LL ")
			.pattern("LS ")
			.pattern(" S ")
			.define('L', ModItems.LUNARITE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LUNARITE_HOE.get(),1 )
			.pattern("LL ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.LUNARITE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LUNARITE_PICKAXE.get(),1 )
			.pattern("LLL")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.LUNARITE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LUNARITE_SHOVEL.get(),1 )
			.pattern(" L ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.LUNARITE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUNARITE_SWORD.get(),1 )
			.pattern(" L ")
			.pattern(" L ")
			.pattern(" S ")
			.define('L', ModItems.LUNARITE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
	
		//Stairs
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_STAIRS.get(),4 )
			.pattern("  P")
			.pattern(" PP")
			.pattern("PPP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_STAIRS.get(), 4)
			.pattern("  P")
			.pattern(" PP")
			.pattern("PPP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_STAIRS.get(), 4)
			.pattern("  P")
			.pattern(" PP")
			.pattern("PPP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VAILSTONEBRICK_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLED_VAILSTONE_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHGNEISS_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHLUNARSLATE_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHMARBLE_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);	
		
		//slabs
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLED_VAILSTONE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VAILSTONEBRICK_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHGNEISS_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHLUNARSLATE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHMARBLE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);	
	
		//walls
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLED_VAILSTONE_WALL.get(), 6)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VAILSTONEBRICK_WALL.get(), 6)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHGNEISS_WALL.get(), 6)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHLUNARSLATE_WALL.get(), 6)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTHMARBLE_WALL.get(), 6)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);	
		
		//fence
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_FENCE_GATE.get(),1 )
			.pattern("   ")
			.pattern("SPS")
			.pattern("SPS")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_FENCE.get(),3 )
			.pattern("   ")
			.pattern("PSP")
			.pattern("PSP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_FENCE_GATE.get(),1 )
			.pattern("   ")
			.pattern("SPS")
			.pattern("SPS")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_FENCE.get(),3 )
			.pattern("   ")
			.pattern("PSP")
			.pattern("PSP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_FENCE_GATE.get(),1 )
			.pattern("   ")
			.pattern("SPS")
			.pattern("SPS")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_FENCE.get(),3 )
			.pattern("   ")
			.pattern("PSP")
			.pattern("PSP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
		
		//doors
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
		
		//trapdoors
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELEST_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STELLAR_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKYOAK_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
	}
	
	protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
	      oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
	}
	protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
	      oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
	}
	protected static void foodSmoking(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
	      oreCooking(p_248775_, RecipeSerializer.SMOKING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_smoking");
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
