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
				
				pOutput.accept(ModBlocks.LUNGRASS.get());
				pOutput.accept(ModBlocks.LUNDIRT.get());
				pOutput.accept(ModBlocks.LUNSAND.get());
				pOutput.accept(ModBlocks.LUNSANDSTONE.get());
				
				
				pOutput.accept(ModBlocks.VAILSTONE.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_STAIRS.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_SLAB.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_WALL.get());

				pOutput.accept(ModBlocks.LUNARSHALE.get());
				pOutput.accept(ModBlocks.LUNARSLATE.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHLUNARSLATE_WALL.get());
				
				pOutput.accept(ModBlocks.GNEISS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHGNEISS_WALL.get());
				
				pOutput.accept(ModBlocks.MARBLE.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_STAIRS.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_SLAB.get());
				pOutput.accept(ModBlocks.SMOOTHMARBLE_WALL.get());
				
				//Ore Entry
				pOutput.accept(ModBlocks.LUNARITE_ORE.get());
				pOutput.accept(ModBlocks.MOONSTEEL_ORE.get());
				
				//Tree Entry
				pOutput.accept(ModBlocks.CELEST_WOOD.get());
				pOutput.accept(ModBlocks.CELEST_LEAVES.get());
				pOutput.accept(ModBlocks.CELEST_PLANKS.get());
				pOutput.accept(ModBlocks.CELEST_STAIRS.get());
				pOutput.accept(ModBlocks.CELEST_SLAB.get());
				
				pOutput.accept(ModBlocks.STELLAR_WOOD.get());
				pOutput.accept(ModBlocks.STELLAR_LEAVES.get());;
				pOutput.accept(ModBlocks.STELLAR_PLANKS.get());
				pOutput.accept(ModBlocks.STELLAR_STAIRS.get());
				pOutput.accept(ModBlocks.STELLAR_SLAB.get());
				
				pOutput.accept(ModBlocks.SKYOAK_WOOD.get());
				pOutput.accept(ModBlocks.SKYOAK_LEAVES.get());;
				pOutput.accept(ModBlocks.SKYOAK_PLANKS.get());
				pOutput.accept(ModBlocks.SKYOAK_STAIRS.get());
				pOutput.accept(ModBlocks.SKYOAK_SLAB.get());
				
				//Item Entry
				pOutput.accept(ModItems.MOONDIAL.get());
				pOutput.accept(ModItems.MOONSTEEL.get());
				pOutput.accept(ModItems.EMOONSTEEL.get());
				pOutput.accept(ModItems.LUNARITE.get());
				pOutput.accept(ModItems.LOONBERRY.get());
				
				//Tool Entry
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
				
			})
			.build());
	
	public static void register(IEventBus eventbus) {
		CREATIVE_MODE_TABS.register(eventbus);
	}
}