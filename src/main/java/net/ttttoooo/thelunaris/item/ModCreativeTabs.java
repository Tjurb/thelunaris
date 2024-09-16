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
				pOutput.accept(ModBlocks.VAILSTONE.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_STAIRS.get());
				pOutput.accept(ModBlocks.VAILSTONEBRICK_SLAB.get());
				//Item Entry
				pOutput.accept(ModItems.MOONDIAL.get());
				pOutput.accept(ModItems.MOONSTEEL.get());
				pOutput.accept(ModItems.EMOONSTEEL.get());
				pOutput.accept(ModItems.LUNARITE.get());
			})
			.build());
	
	public static void register(IEventBus eventbus) {
		CREATIVE_MODE_TABS.register(eventbus);
	}
}