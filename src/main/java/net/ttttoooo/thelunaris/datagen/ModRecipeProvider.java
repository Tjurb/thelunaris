package net.ttttoooo.thelunaris.datagen;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;
import net.ttttoooo.thelunaris.util.ModTags;

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
	
	public static final List<ItemLike> LUNAR_CLAY_SMELTING = List.of(ModItems.LUNAR_CLAY.get());

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
		
		oreSmelting(pWriter, LUNGLASS_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LUNGLASS.get(), 0.10f, 200, "lunglass" );
		oreSmelting(pWriter, LUNAR_CHARCOAL, RecipeCategory.MISC, Items.CHARCOAL, 0.10f, 200, "lunar_charcoal" );
		
		oreSmelting(pWriter, STONELIKE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VAILSTONE.get(), 0.10f, 200, "vailstone" );
		oreSmelting(pWriter, GNEISS_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHGNEISS.get(), 0.10f, 200, "smooth_gneiss" );
		oreSmelting(pWriter, MARBLE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHMARBLE.get(), 0.10f, 200, "smooth_marble" );
		oreSmelting(pWriter, SLATE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHLUNARSLATE.get(), 0.10f, 200, "smooth_lunarslate" );
		oreSmelting(pWriter, SHALE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LUNARSLATE.get(), 0.10f, 200, "lunarslate" );
		
		oreSmelting(pWriter, LUNAR_CLAY_SMELTING, RecipeCategory.MISC, ModItems.LUNAR_CLAY_BRICK.get(), 0.10f, 200, "lunar_clay_brick" );
		
		oreSmelting(pWriter, ARCHFISH_COOKING, RecipeCategory.FOOD, ModItems.COOKED_ARCHFISH.get(), 0.20f, 200, "archfish" );
		foodSmoking(pWriter, ARCHFISH_COOKING, RecipeCategory.FOOD, ModItems.COOKED_ARCHFISH.get(), 0.20f, 150, "archfish" );
	
		//High level Foods
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SPICY_ARCHFISH.get(),2 )
			.pattern("   ")
			.pattern("SAS")
			.pattern("SSS")
			.define('A', ModItems.COOKED_ARCHFISH.get())
			.define('S', ModItems.SARROT.get())
			.unlockedBy(getHasName(ModItems.SARROT.get()), has(ModItems.SARROT.get()))
			.unlockedBy(getHasName(ModItems.COOKED_ARCHFISH.get()), has(ModItems.COOKED_ARCHFISH.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.LOONBERRY_PIE.get(),2 )
			.pattern("   ")
			.pattern("LLL")
			.pattern("WWW")
			.define('L', ModItems.LOONBERRY.get())
			.define('W', ModItems.LUNAR_WHEAT.get())
			.unlockedBy(getHasName(ModItems.LOONBERRY.get()), has(ModItems.LOONBERRY.get()))
			.unlockedBy(getHasName(ModItems.LUNAR_WHEAT.get()), has(ModItems.LUNAR_WHEAT.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.LUN_BREAD.get(),1 )
			.pattern("WWW")
			.define('W', ModItems.LUNAR_WHEAT.get())
			.unlockedBy(getHasName(ModItems.LUNAR_WHEAT.get()), has(ModItems.LUNAR_WHEAT.get()))
			.save(pWriter);
		
		//Special Recipes
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONDIAL.get(),1 )
			.pattern("LGL")
			.pattern("GDG")
			.pattern("LGL")
			.define('L', Items.LAPIS_LAZULI)
			.define('G', Items.GOLD_INGOT)
			.define('D', Items.DIAMOND)
			.unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
			.unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
			.unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOONDIAL.get(),1 )
			.pattern("LGL")
			.pattern("GDG")
			.pattern("LGL")
			.define('L', ModItems.LABRADORITE.get())
			.define('G', ModItems.EMOONSTEEL.get())
			.define('D', ModItems.LUNARITE.get())
			.unlockedBy(getHasName(ModItems.LABRADORITE.get()), has(ModItems.LABRADORITE.get()))
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter, name("moondial_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VAILSTONE_FURNACE.get(),1 )
			.pattern("VVV")
			.pattern("VLV")
			.pattern("VVV")
			.define('V', ModBlocks.COBBLED_VAILSTONE.get())
			.define('L', ModItems.LABRADORITE.get())
			.unlockedBy(getHasName(ModItems.LABRADORITE.get()), has(ModItems.LABRADORITE.get()))
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LUNARIS_CRAFTING_TABLE.get(),1 )
			.pattern("##")
			.pattern("##")
			.define('#', ModTags.Items.LUNAR_PLANKS)
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.FURNACE,1 )
			.pattern("VVV")
			.pattern("V V")
			.pattern("VVV")
			.define('V', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter, name("vanilla_furnace_from_vailstone"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLAST_FURNACE,1 )
			.pattern("MMM")
			.pattern("MFM")
			.pattern("VVV")
			.define('V', ModBlocks.VAILSTONE.get())
			.define('M', ModItems.MOONSTEEL.get())
			.define('F', Blocks.FURNACE)
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
			.save(pWriter, name("vanilla_blast_furnace_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.SMOKER,1 )
			.pattern(" W ")
			.pattern("WFW")
			.pattern(" W ")
			.define('W', ModTags.Items.LUNAR_LOGS_ITEM)
			.define('F', Blocks.FURNACE)
			.unlockedBy(getHasName(ModBlocks.CELEST_LOG.get()), has(ModTags.Items.LUNAR_LOGS_ITEM))
			.unlockedBy(getHasName(ModBlocks.STELLAR_LOG.get()), has(ModTags.Items.LUNAR_LOGS_ITEM))
			.unlockedBy(getHasName(ModBlocks.SKYOAK_LOG.get()), has(ModTags.Items.LUNAR_LOGS_ITEM))
			.unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
			.save(pWriter, name("vanilla_smoker_from_lunaris"));
		
		//Misc Items
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LUNAR_STICK.get(),4 )
			.pattern("#")
			.pattern("#")
			.define('#', ModTags.Items.LUNAR_PLANKS)
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STRING,4 )
			.pattern("##")
			.pattern("##")
			.define('#', ModTags.Items.LUNAR_GRASS)
			.unlockedBy(getHasName(ModBlocks.LUNGRASS.get()), has(ModTags.Items.LUNAR_GRASS))
			.unlockedBy(getHasName(ModBlocks.CRIMSON_LUNGRASS.get()), has(ModTags.Items.LUNAR_GRASS))
			.unlockedBy(getHasName(ModBlocks.DUSKLIGHT_LUNGRASS.get()), has(ModTags.Items.LUNAR_GRASS))
			.save(pWriter, name("string_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LUNGLASS_PANE.get(),6 )
			.pattern("###")
			.pattern("###")
			.define('#', ModBlocks.LUNGLASS.get())
			.unlockedBy(getHasName(ModBlocks.LUNGLASS.get()), has(ModBlocks.LUNGLASS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TORCH,4 )
			.pattern("C")
			.pattern("S")
			.define('C', Items.COAL)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("vanilla_torch_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TORCH,4 )
			.pattern("C")
			.pattern("S")
			.define('C', Items.CHARCOAL)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("vanilla_charcoal_torch_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLOWER_POT,1 )
			.pattern("# #")
			.pattern(" # ")
			.define('#', ModItems.LUNAR_CLAY_BRICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_CLAY_BRICK.get()), has(ModItems.LUNAR_CLAY_BRICK.get()))
			.save(pWriter ,name("vanilla_flowerpot_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CHEST,1 )
			.pattern("###")
			.pattern("# #")
			.pattern("###")
			.define('#', ModTags.Items.LUNAR_PLANKS)
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModTags.Items.LUNAR_PLANKS))
			.save(pWriter ,name("vanilla_chest_from_lunaris"));
		
		//Dyes
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 2)
        	.requires(ModBlocks.ORANGEYE.get())
        	.unlockedBy(getHasName(ModBlocks.ORANGEYE.get()), has(ModBlocks.ORANGEYE.get()))
        	.save(pWriter, name("orangeye_dye"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE, 2)
        	.requires(ModBlocks.CYANEYE.get())
        	.unlockedBy(getHasName(ModBlocks.CYANEYE.get()), has(ModBlocks.CYANEYE.get()))
        	.save(pWriter, name("cyaneye_dye"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE, 2)
        	.requires(ModBlocks.MAGENTEYE.get())
        	.unlockedBy(getHasName(ModBlocks.MAGENTEYE.get()), has(ModBlocks.MAGENTEYE.get()))
        	.save(pWriter, name("magenteye_dye"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIME_DYE, 2)
        	.requires(ModBlocks.LUN_CLOVER.get())
        	.unlockedBy(getHasName(ModBlocks.LUN_CLOVER.get()), has(ModBlocks.LUN_CLOVER.get()))
        	.save(pWriter, name("lun_clover_dye"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BROWN_DYE, 2)
        	.requires(ModBlocks.BRAMBLE.get())
        	.unlockedBy(getHasName(ModBlocks.BRAMBLE.get()), has(ModBlocks.BRAMBLE.get()))
        	.save(pWriter, name("bramble_dye"));
		
		//Planks
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CELEST_PLANKS.get(), 4)
        	.requires(ModTags.Items.CELEST_WOODS)
        	.unlockedBy(getHasName(ModBlocks.CELEST_LOG.get()), has(ModBlocks.CELEST_LOG.get()))
        	.save(pWriter);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STELLAR_PLANKS.get(), 4)
        	.requires(ModTags.Items.STELLAR_WOODS)
        	.unlockedBy(getHasName(ModBlocks.STELLAR_LOG.get()), has(ModBlocks.STELLAR_LOG.get()))
        	.save(pWriter);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SKYOAK_PLANKS.get(), 4)
        	.requires(ModTags.Items.SKYOAK_WOODS)
        	.unlockedBy(getHasName(ModBlocks.SKYOAK_LOG.get()), has(ModBlocks.SKYOAK_LOG.get()))
        	.save(pWriter);
		
		//Block -> Ingot
		makeBlockToIngot(ModItems.RAW_MOONSTEEL, ModBlocks.RAW_MOONSTEEL_BLOCK).save(pWriter, name("raw_moonsteel_block_to_ingot"));
		makeBlockToIngot(ModItems.MOONSTEEL, ModBlocks.MOONSTEEL_BLOCK).save(pWriter, name("moonsteel_block_to_ingot"));
		makeBlockToIngot(ModItems.EMOONSTEEL, ModBlocks.EMOONSTEEL_BLOCK).save(pWriter, name("emoonsteel_block_to_ingot"));
		makeBlockToIngot(ModItems.LABRADORITE, ModBlocks.LABRADORITE_BLOCK).save(pWriter, name("labradorite_block_to_ingot"));
		makeBlockToIngot(ModItems.LUNARITE, ModBlocks.LUNARITE_BLOCK).save(pWriter, name("lunarite_block_to_ingot"));
		
		//Ingot -> Block
		makeIngotToBlock(ModBlocks.RAW_MOONSTEEL_BLOCK, ModItems.RAW_MOONSTEEL).save(pWriter);
		makeIngotToBlock(ModBlocks.MOONSTEEL_BLOCK, ModItems.MOONSTEEL).save(pWriter);
		makeIngotToBlock(ModBlocks.EMOONSTEEL_BLOCK, ModItems.EMOONSTEEL).save(pWriter);
		makeIngotToBlock(ModBlocks.LABRADORITE_BLOCK, ModItems.LABRADORITE).save(pWriter);
		makeIngotToBlock(ModBlocks.LUNARITE_BLOCK, ModItems.LUNARITE).save(pWriter);
		
		//Ingot -> Nugget
		makeIngotToNugget(ModItems.MOONSTEEL, ModItems.MOONSTEEL_NUGGET).save(pWriter, name("moonsteel_ingot_to_nugget"));
		makeIngotToNugget(ModItems.EMOONSTEEL, ModItems.EMOONSTEEL_NUGGET).save(pWriter, name("emoonsteel_ingot_to_nugget"));
		
		//Nugget -> Ingot
		makeNuggetToIngot(ModItems.MOONSTEEL_NUGGET, ModItems.MOONSTEEL).save(pWriter, name("moonsteel_nugget_to_ingot"));
		makeNuggetToIngot(ModItems.EMOONSTEEL_NUGGET, ModItems.EMOONSTEEL).save(pWriter, name("emoonsteel_nugget_to_ingot"));

		//Wooden Tools
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.FISHING_ROD,1 )
			.pattern("  S")
			.pattern(" SG")
			.pattern("S G")
			.define('G', Items.STRING)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("fishingrod_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_AXE,1 )
			.pattern("LL ")
			.pattern("LS ")
			.pattern(" S ")
			.define('L', ModTags.Items.LUNAR_PLANKS)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("wooden_axe_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_HOE,1 )
			.pattern("LL ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModTags.Items.LUNAR_PLANKS)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("wooden_hoe_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_PICKAXE,1 )
			.pattern("LLL")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModTags.Items.LUNAR_PLANKS)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("wooden_pickaxe_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_SHOVEL,1 )
			.pattern(" L ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModTags.Items.LUNAR_PLANKS)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("wooden_shovel_from_lunaris"));
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.WOODEN_SWORD,1 )
			.pattern(" L ")
			.pattern(" L ")
			.pattern(" S ")
			.define('L', ModTags.Items.LUNAR_PLANKS)
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_STICK.get()), has(ModItems.LUNAR_STICK.get()))
			.save(pWriter, name("wooden_sword_from_lunaris"));
		
		//Vailstone Tools
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VAILSTONE_AXE.get(),1 )
			.pattern("LL ")
			.pattern("LS ")
			.pattern(" S ")
			.define('L', ModBlocks.VAILSTONE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VAILSTONE_HOE.get(),1 )
			.pattern("LL ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModBlocks.VAILSTONE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VAILSTONE_PICKAXE.get(),1 )
			.pattern("LLL")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModBlocks.VAILSTONE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VAILSTONE_SHOVEL.get(),1 )
			.pattern(" L ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModBlocks.VAILSTONE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VAILSTONE_SWORD.get(),1 )
			.pattern(" L ")
			.pattern(" L ")
			.pattern(" S ")
			.define('L', ModBlocks.VAILSTONE.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONE.get()), has(ModBlocks.VAILSTONE.get()))
			.save(pWriter);
		
		//Moonsteel Armors
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_HELMET.get(),1 )
			.pattern("   ")
			.pattern("MMM")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_CHESTPLATE.get(),1 )
			.pattern("M M")
			.pattern("MMM")
			.pattern("MMM")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_LEGGINGS.get(),1 )
			.pattern("MMM")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_BOOTS.get(),1 )
			.pattern("   ")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.MOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		
		//Moonsteel Tools
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_AXE.get(),1 )
			.pattern("LL ")
			.pattern("LS ")
			.pattern(" S ")
			.define('L', ModItems.MOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_HOE.get(),1 )
			.pattern("LL ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.MOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_PICKAXE.get(),1 )
			.pattern("LLL")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.MOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_SHOVEL.get(),1 )
			.pattern(" L ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.MOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_SWORD.get(),1 )
			.pattern(" L ")
			.pattern(" L ")
			.pattern(" S ")
			.define('L', ModItems.MOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.MOONSTEEL.get()), has(ModItems.MOONSTEEL.get()))
			.save(pWriter);

		
		//Ethereal Moonsteel Armor
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMOONSTEEL_HELMET.get(),1 )
			.pattern("   ")
			.pattern("MMM")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMOONSTEEL_CHESTPLATE.get(),1 )
			.pattern("M M")
			.pattern("MMM")
			.pattern("MMM")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMOONSTEEL_LEGGINGS.get(),1 )
			.pattern("MMM")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMOONSTEEL_BOOTS.get(),1 )
			.pattern("   ")
			.pattern("M M")
			.pattern("M M")
			.define('M', ModItems.EMOONSTEEL.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		
		//Ethereal Moonsteel Tools
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMOONSTEEL_AXE.get(),1 )
			.pattern("LL ")
			.pattern("LS ")
			.pattern(" S ")
			.define('L', ModItems.EMOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMOONSTEEL_HOE.get(),1 )
			.pattern("LL ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.EMOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMOONSTEEL_PICKAXE.get(),1 )
			.pattern("LLL")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.EMOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMOONSTEEL_SHOVEL.get(),1 )
			.pattern(" L ")
			.pattern(" S ")
			.pattern(" S ")
			.define('L', ModItems.EMOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMOONSTEEL_SWORD.get(),1 )
			.pattern(" L ")
			.pattern(" L ")
			.pattern(" S ")
			.define('L', ModItems.EMOONSTEEL.get())
			.define('S', ModItems.LUNAR_STICK.get())
			.unlockedBy(getHasName(ModItems.EMOONSTEEL.get()), has(ModItems.EMOONSTEEL.get()))
			.save(pWriter);		
		
		//Lunarite Armor
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUNARITE_HELMET.get(),1 )
			.pattern("   ")
			.pattern("LLL")
			.pattern("LML")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_HELMET.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUNARITE_CHESTPLATE.get(),1 )
			.pattern("LML")
			.pattern("LLL")
			.pattern("LLL")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_CHESTPLATE.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUNARITE_LEGGINGS.get(),1 )
			.pattern("LLL")
			.pattern("LML")
			.pattern("L L")
			.define('L', ModItems.LUNARITE.get())
			.define('M', ModItems.EMOONSTEEL_LEGGINGS.get())
			.unlockedBy(getHasName(ModItems.LUNARITE.get()), has(ModItems.LUNARITE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUNARITE_BOOTS.get(),1 )
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
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS.get(), 4)
			.pattern("  S")
			.pattern(" SS")
			.pattern("SSS")
			.define('S', ModBlocks.LUNCLAY_BRICK_BLOCK.get())
			.unlockedBy(getHasName(ModBlocks.LUNCLAY_BRICK_BLOCK.get()), has(ModBlocks.LUNCLAY_BRICK_BLOCK.get()))
			.save(pWriter);
		
		//slabs
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CELEST_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STELLAR_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SKYOAK_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("PPP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_VAILSTONE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VAILSTONEBRICK_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHGNEISS_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHLUNARSLATE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHMARBLE_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get(), 6)
			.pattern("   ")
			.pattern("   ")
			.pattern("SSS")
			.define('S', ModBlocks.LUNCLAY_BRICK_BLOCK.get())
			.unlockedBy(getHasName(ModBlocks.LUNCLAY_BRICK_BLOCK.get()), has(ModBlocks.LUNCLAY_BRICK_BLOCK.get()))
			.save(pWriter);	
	
		//walls
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_VAILSTONE_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.COBBLED_VAILSTONE.get())
			.unlockedBy(getHasName(ModBlocks.COBBLED_VAILSTONE.get()), has(ModBlocks.COBBLED_VAILSTONE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VAILSTONEBRICK_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHGNEISS_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHLUNARSLATE_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);	
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTHMARBLE_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);		
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get(), 3)
			.pattern("   ")
			.pattern("SSS")
			.pattern("SSS")
			.define('S', ModBlocks.LUNCLAY_BRICK_BLOCK.get())
			.unlockedBy(getHasName(ModBlocks.LUNCLAY_BRICK_BLOCK.get()), has(ModBlocks.LUNCLAY_BRICK_BLOCK.get()))
			.save(pWriter);	
		
		//fence
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CELEST_FENCE_GATE.get(),1 )
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
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.STELLAR_FENCE_GATE.get(),1 )
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
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SKYOAK_FENCE_GATE.get(),1 )
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
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CELEST_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.STELLAR_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SKYOAK_DOOR.get(),3 )
			.pattern(" PP")
			.pattern(" PP")
			.pattern(" PP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
		
		//trapdoors
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CELEST_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.CELEST_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.CELEST_PLANKS.get()), has(ModBlocks.CELEST_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.STELLAR_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.STELLAR_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.STELLAR_PLANKS.get()), has(ModBlocks.STELLAR_PLANKS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SKYOAK_TRAPDOOR.get(),3 )
			.pattern("   ")
			.pattern("PPP")
			.pattern("PPP")
			.define('P', ModBlocks.SKYOAK_PLANKS.get())
			.unlockedBy(getHasName(ModBlocks.SKYOAK_PLANKS.get()), has(ModBlocks.SKYOAK_PLANKS.get()))
			.save(pWriter);
		
		//brick block
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LUNCLAY_BRICK_BLOCK.get(),1 )
			.pattern("##")
			.pattern("##")
			.define('#', ModItems.LUNAR_CLAY_BRICK.get())
			.unlockedBy(getHasName(ModItems.LUNAR_CLAY_BRICK.get()), has(ModItems.LUNAR_CLAY_BRICK.get()))
			.save(pWriter);
		
		//chissled bricks
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_VAILSTONEBRICK.get(),4 )
			.pattern("##")
			.pattern("##")
			.define('#', ModBlocks.VAILSTONEBRICK.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_SMOOTHGNEISS.get(),4 )
			.pattern("##")
			.pattern("##")
			.define('#', ModBlocks.SMOOTHGNEISS.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_SMOOTHLUNARSLATE.get(),4 )
			.pattern("##")
			.pattern("##")
			.define('#', ModBlocks.SMOOTHLUNARSLATE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_SMOOTHMARBLE.get(),4 )
			.pattern("##")
			.pattern("##")
			.define('#', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CHISELED_STONE_BRICKS,4 )
			.pattern("VG")
			.pattern("SM")
			.define('V', ModBlocks.VAILSTONEBRICK.get())
			.define('G', ModBlocks.SMOOTHGNEISS.get())
			.define('S', ModBlocks.SMOOTHLUNARSLATE.get())
			.define('M', ModBlocks.SMOOTHMARBLE.get())
			.unlockedBy(getHasName(ModBlocks.VAILSTONEBRICK.get()), has(ModBlocks.VAILSTONEBRICK.get()))
			.unlockedBy(getHasName(ModBlocks.SMOOTHGNEISS.get()), has(ModBlocks.SMOOTHGNEISS.get()))
			.unlockedBy(getHasName(ModBlocks.SMOOTHLUNARSLATE.get()), has(ModBlocks.SMOOTHLUNARSLATE.get()))
			.unlockedBy(getHasName(ModBlocks.SMOOTHMARBLE.get()), has(ModBlocks.SMOOTHMARBLE.get()))
			.save(pWriter, name("vanilla_chiseled_stone_bricks_from_lunaris"));
	}
	

	public ShapedRecipeBuilder makeIngotToBlock(Supplier<? extends Block> blockOut, Supplier<? extends Item> ingotIn) {
		return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockOut.get())
				.pattern("###")
				.pattern("###")
				.pattern("###")
				.define('#', ingotIn.get())
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingotIn.get()).getPath(), has(ingotIn.get()));
	}

	public ShapelessRecipeBuilder makeBlockToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Block> blockIn) {
		return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingotOut.get(), 9)
				.requires(blockIn.get())
				.unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
	}

	public ShapedRecipeBuilder makeNuggetToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Item> nuggetIn) {
		return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingotOut.get(), 1)
				.pattern("NNN")
				.pattern("NNN")
				.pattern("NNN")
				.define('N', nuggetIn.get())
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(nuggetIn.get()).getPath(), has(nuggetIn.get()));
	}

	public ShapelessRecipeBuilder makeIngotToNugget(Supplier<? extends Item> nuggetOut, Supplier<? extends Item> ingotIn) {
		return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nuggetOut.get(), 9)
				.requires(ingotIn.get())
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingotIn.get()).getPath(), has(ingotIn.get()));
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
	
	private ResourceLocation name(String name) {
		return new ResourceLocation(TheLunaris.MODID, name);
	}

}
