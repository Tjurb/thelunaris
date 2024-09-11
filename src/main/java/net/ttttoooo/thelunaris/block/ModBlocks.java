package net.ttttoooo.thelunaris.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, TheLunaris.MODID);
	
	public static final RegistryObject<Block> MOONDIALBLOCK = BLOCKS.register("moondialblock", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
	
	public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
