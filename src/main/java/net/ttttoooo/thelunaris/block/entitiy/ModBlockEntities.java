package net.ttttoooo.thelunaris.block.entitiy;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheLunaris.MODID);

    public static final RegistryObject<BlockEntityType<VailstoneFurnaceEntity>> ENRICHING_BE =
            BLOCK_ENTITIES.register("vailstone_furnace_be", () ->
                    BlockEntityType.Builder.of(VailstoneFurnaceEntity::new,
                            ModBlocks.VAILSTONE_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<LunarCrafterEntity>> LUNAR_CRAFTING_BE =
            BLOCK_ENTITIES.register("lunar_crafter_be", () ->
                    BlockEntityType.Builder.of(LunarCrafterEntity::new,
                            ModBlocks.LUNAR_CRAFTER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}