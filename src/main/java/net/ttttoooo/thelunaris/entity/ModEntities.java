package net.ttttoooo.thelunaris.entity;

import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheLunaris.MODID);

    public static final RegistryObject<EntityType<MooncowEntity>> MOONCOW =
            ENTITY_TYPES.register("mooncow", () -> EntityType.Builder.of(MooncowEntity:: new, MobCategory.CREATURE)
            		.sized(2.0F, 2.0F).build("mooncow"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
