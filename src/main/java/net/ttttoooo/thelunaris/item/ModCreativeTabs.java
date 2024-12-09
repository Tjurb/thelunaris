package net.ttttoooo.thelunaris.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModCreativeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheLunaris.MODID);
	
	public static final RegistryObject<CreativeModeTab> THELUNARIS_TAB = CREATIVE_MODE_TABS.register("thelunaris_tab", 
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOONDIAL.get()))
			.title(Component.translatable("creativetab.thelunaris_tab"))
			.displayItems((pParameters, pOutput) -> {
				//Block Entry
				pOutput.accept(ModBlocks.MOONDIALBLOCK.get());
				pOutput.accept(ModBlocks.LUNAR_CRAFTER.get());
				pOutput.accept(ModBlocks.VAILSTONE_FURNACE.get());
				pOutput.accept(ModBlocks.LUNARIS_CRAFTING_TABLE.get());
				pOutput.accept(ModBlocks.LUNARIS_BEDROCK.get());
				
				pOutput.accept(ModBlocks.LUNGRASS_BLOCK.get());
				pOutput.accept(ModBlocks.CRIMSON_LUNGRASS_BLOCK.get());
				pOutput.accept(ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get());
				pOutput.accept(ModBlocks.LUNDIRT.get());
				pOutput.accept(ModBlocks.LUNCLAY_BLOCK.get());
				pOutput.accept(ModBlocks.LUNCLAY_BRICK_BLOCK.get());
				pOutput.accept(ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS.get());
				pOutput.accept(ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get());
				pOutput.accept(ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get());
				pOutput.accept(ModBlocks.LUNSAND.get());
				pOutput.accept(ModBlocks.LUNSANDSTONE.get());
				pOutput.accept(ModBlocks.LUNSANDSTONE_STAIRS.get());
				pOutput.accept(ModBlocks.LUNSANDSTONE_SLAB.get());
				pOutput.accept(ModBlocks.LUNSANDSTONE_WALL.get());

				pOutput.accept(ModBlocks.COBBLED_VAILSTONE.get());
				pOutput.accept(ModBlocks.COBBLED_VAILSTONE_STAIRS.get());
				pOutput.accept(ModBlocks.COBBLED_VAILSTONE_SLAB.get());
				pOutput.accept(ModBlocks.COBBLED_VAILSTONE_WALL.get());
				
				pOutput.accept(ModBlocks.VAILSTONE.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK.get());
				pOutput.accept(ModBlocks.CHISELED_VAILSTONEBRICK.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_STAIRS.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_SLAB.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_WALL.get());

				pOutput.accept(ModBlocks.LUNARSHALE.get());
				pOutput.accept(ModBlocks.LUNARSLATE.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE.get());
				pOutput.accept(ModBlocks.CHISELED_SMOOTHLUNARSLATE.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_WALL.get());
				
				pOutput.accept(ModBlocks.GNEISS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS.get());
				pOutput.accept(ModBlocks.CHISELED_SMOOTHGNEISS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_WALL.get());
				
				pOutput.accept(ModBlocks.MARBLE.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE.get());
				pOutput.accept(ModBlocks.CHISELED_SMOOTHMARBLE.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_WALL.get());
				
				pOutput.accept(ModBlocks.LUNGLASS.get());
				pOutput.accept(ModBlocks.LUNGLASS_PANE.get());
				
				//Ore Entry
				pOutput.accept(ModBlocks.LUNARIS_COAL_ORE.get());
				pOutput.accept(ModBlocks.LUNARITE_ORE.get());
				pOutput.accept(ModBlocks.MOONSTEEL_ORE.get());
				pOutput.accept(ModBlocks.LABRADORITE_ORE.get());
				pOutput.accept(ModBlocks.DEEP_LUNARIS_COAL_ORE.get());
				pOutput.accept(ModBlocks.DEEP_LUNARITE_ORE.get());
				pOutput.accept(ModBlocks.DEEP_MOONSTEEL_ORE.get());
				pOutput.accept(ModBlocks.DEEP_LABRADORITE_ORE.get());
				
				//Tree Entry
				pOutput.accept(ModBlocks.CELEST_SAPLING.get());
				pOutput.accept(ModBlocks.CELEST_LOG.get());
				pOutput.accept(ModBlocks.CELEST_WOOD.get());
				pOutput.accept(ModBlocks.STRIPPED_CELEST_LOG.get());
				pOutput.accept(ModBlocks.STRIPPED_CELEST_WOOD.get());
				pOutput.accept(ModBlocks.CELEST_LEAVES.get());
				pOutput.accept(ModBlocks.CELEST_PLANKS.get());
				pOutput.accept(ModBlocks.CELEST_STAIRS.get());
				pOutput.accept(ModBlocks.CELEST_SLAB.get());
				pOutput.accept(ModBlocks.CELEST_BUTTON.get());
				pOutput.accept(ModBlocks.CELEST_PRESSURE_PLATE.get());
				pOutput.accept(ModBlocks.CELEST_FENCE.get());
				pOutput.accept(ModBlocks.CELEST_FENCE_GATE.get());
				pOutput.accept(ModBlocks.CELEST_DOOR.get());
				pOutput.accept(ModBlocks.CELEST_TRAPDOOR.get());
				
				pOutput.accept(ModBlocks.STELLAR_SAPLING.get());
				pOutput.accept(ModBlocks.STELLAR_LOG.get());
				pOutput.accept(ModBlocks.STELLAR_WOOD.get());
				pOutput.accept(ModBlocks.STRIPPED_STELLAR_LOG.get());
				pOutput.accept(ModBlocks.STRIPPED_STELLAR_WOOD.get());
				pOutput.accept(ModBlocks.STELLAR_LEAVES.get());;
				pOutput.accept(ModBlocks.STELLAR_PLANKS.get());
				pOutput.accept(ModBlocks.STELLAR_STAIRS.get());
				pOutput.accept(ModBlocks.STELLAR_SLAB.get());
				pOutput.accept(ModBlocks.STELLAR_BUTTON.get());
				pOutput.accept(ModBlocks.STELLAR_PRESSURE_PLATE.get());
				pOutput.accept(ModBlocks.STELLAR_FENCE.get());
				pOutput.accept(ModBlocks.STELLAR_FENCE_GATE.get());
				pOutput.accept(ModBlocks.STELLAR_DOOR.get());
				pOutput.accept(ModBlocks.STELLAR_TRAPDOOR.get());
				
				pOutput.accept(ModBlocks.SKYOAK_SAPLING.get());
				pOutput.accept(ModBlocks.SKYOAK_LOG.get());
				pOutput.accept(ModBlocks.SKYOAK_WOOD.get());
				pOutput.accept(ModBlocks.STRIPPED_SKYOAK_LOG.get());
				pOutput.accept(ModBlocks.STRIPPED_SKYOAK_WOOD.get());
				pOutput.accept(ModBlocks.SKYOAK_LEAVES.get());;
				pOutput.accept(ModBlocks.SKYOAK_PLANKS.get());
				pOutput.accept(ModBlocks.SKYOAK_STAIRS.get());
				pOutput.accept(ModBlocks.SKYOAK_SLAB.get());
				pOutput.accept(ModBlocks.SKYOAK_BUTTON.get());
				pOutput.accept(ModBlocks.SKYOAK_PRESSURE_PLATE.get());
				pOutput.accept(ModBlocks.SKYOAK_FENCE.get());
				pOutput.accept(ModBlocks.SKYOAK_FENCE_GATE.get());
				pOutput.accept(ModBlocks.SKYOAK_DOOR.get());
				pOutput.accept(ModBlocks.SKYOAK_TRAPDOOR.get());
				
				//Pure Blocks
				pOutput.accept(ModBlocks.LUNARITE_BLOCK.get());
				pOutput.accept(ModBlocks.LABRADORITE_BLOCK.get());
				pOutput.accept(ModBlocks.EMOONSTEEL_BLOCK.get());
				pOutput.accept(ModBlocks.MOONSTEEL_BLOCK.get());
				pOutput.accept(ModBlocks.RAW_MOONSTEEL_BLOCK.get());

				//Nature Blocks
				pOutput.accept(ModBlocks.LUNGRASS.get());
				pOutput.accept(ModBlocks.CRIMSON_LUNGRASS.get());
				pOutput.accept(ModBlocks.DUSKLIGHT_LUNGRASS.get());
				pOutput.accept(ModBlocks.CRIMSON_GLOWBUSH.get());
				pOutput.accept(ModBlocks.DUSKLIGHT_GLOWBUSH.get());
				pOutput.accept(ModBlocks.ORANGEYE.get());
				pOutput.accept(ModBlocks.CYANEYE.get());
				pOutput.accept(ModBlocks.MAGENTEYE.get());
				pOutput.accept(ModBlocks.LUN_CLOVER.get());
				pOutput.accept(ModBlocks.BRAMBLE.get());
				
				//Item Entry
				pOutput.accept(ModItems.LUNAR_STICK.get());
				pOutput.accept(ModItems.MOONDIAL.get());
				pOutput.accept(ModItems.RAW_MOONSTEEL.get());
				pOutput.accept(ModItems.MOONSTEEL.get());
				pOutput.accept(ModItems.MOONSTEEL_NUGGET.get());
				pOutput.accept(ModItems.LABRADORITE.get());
				pOutput.accept(ModItems.EMOONSTEEL.get());
				pOutput.accept(ModItems.EMOONSTEEL_NUGGET.get());
				pOutput.accept(ModItems.LUNARITE.get());
				pOutput.accept(ModItems.LUNAR_WHEAT_SEEDS.get());
				pOutput.accept(ModItems.HEXDUST.get());
				pOutput.accept(ModItems.LUNAR_CLAY.get());
				pOutput.accept(ModItems.LUNAR_CLAY_BRICK.get());
				
				//Food Entry
				pOutput.accept(ModItems.LOONBERRY.get());
				pOutput.accept(ModItems.ARCHFISH.get());
				pOutput.accept(ModItems.SARROT.get());
				pOutput.accept(ModItems.COOKED_ARCHFISH.get());
				pOutput.accept(ModItems.SPICY_ARCHFISH.get());
				pOutput.accept(ModItems.LOONBERRY_PIE.get());
				pOutput.accept(ModItems.LUNAR_WHEAT.get());
				
				//Tool Entry
				pOutput.accept(ModItems.VAILSTONE_SWORD.get());
				pOutput.accept(ModItems.VAILSTONE_PICKAXE.get());
				pOutput.accept(ModItems.VAILSTONE_AXE.get());
				pOutput.accept(ModItems.VAILSTONE_SHOVEL.get());
				pOutput.accept(ModItems.VAILSTONE_HOE.get());
				pOutput.accept(ModItems.MOONSTEEL_SWORD.get());
				pOutput.accept(ModItems.MOONSTEEL_PICKAXE.get());
				pOutput.accept(ModItems.MOONSTEEL_AXE.get());
				pOutput.accept(ModItems.MOONSTEEL_SHOVEL.get());
				pOutput.accept(ModItems.MOONSTEEL_HOE.get());
				pOutput.accept(ModItems.EMOONSTEEL_SWORD.get());
				pOutput.accept(ModItems.EMOONSTEEL_PICKAXE.get());
				pOutput.accept(ModItems.EMOONSTEEL_AXE.get());
				pOutput.accept(ModItems.EMOONSTEEL_SHOVEL.get());
				pOutput.accept(ModItems.EMOONSTEEL_HOE.get());
				pOutput.accept(ModItems.LUNARITE_SWORD.get());
				pOutput.accept(ModItems.LUNARITE_PICKAXE.get());
				pOutput.accept(ModItems.LUNARITE_AXE.get());
				pOutput.accept(ModItems.LUNARITE_SHOVEL.get());
				pOutput.accept(ModItems.LUNARITE_HOE.get());
				
				//Armor Entry
				pOutput.accept(ModItems.MOONSTEEL_HELMET.get());
				pOutput.accept(ModItems.MOONSTEEL_CHESTPLATE.get());
				pOutput.accept(ModItems.MOONSTEEL_LEGGINGS.get());
				pOutput.accept(ModItems.MOONSTEEL_BOOTS.get());
				pOutput.accept(ModItems.EMOONSTEEL_HELMET.get());
				pOutput.accept(ModItems.EMOONSTEEL_CHESTPLATE.get());
				pOutput.accept(ModItems.EMOONSTEEL_LEGGINGS.get());
				pOutput.accept(ModItems.EMOONSTEEL_BOOTS.get());
				pOutput.accept(ModItems.LUNARITE_HELMET.get());
				pOutput.accept(ModItems.LUNARITE_CHESTPLATE.get());
				pOutput.accept(ModItems.LUNARITE_LEGGINGS.get());
				pOutput.accept(ModItems.LUNARITE_BOOTS.get());
				
				//SpawnEggs Entry
				pOutput.accept(ModItems.MOONCOW_SPANW_EGG.get());
				pOutput.accept(ModItems.ARCHFISH_SPANW_EGG.get());
				pOutput.accept(ModItems.MOONSNAIL_SPANW_EGG.get());
				pOutput.accept(ModItems.PHYREX_SPANW_EGG.get());
				pOutput.accept(ModItems.LUNARSLEEPER_SPANW_EGG.get());
				pOutput.accept(ModItems.HEX_SPANW_EGG.get());
				
			})
			.build());
	
	public static void register(IEventBus eventbus) {
		CREATIVE_MODE_TABS.register(eventbus);
	}
}