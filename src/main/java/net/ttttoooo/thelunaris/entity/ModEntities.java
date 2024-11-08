package net.ttttoooo.thelunaris.entity;

import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.ArchfishEntity;
import net.ttttoooo.thelunaris.entity.custom.HexEntity;
import net.ttttoooo.thelunaris.entity.custom.LunarsleeperEntity;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;
import net.ttttoooo.thelunaris.entity.custom.MoonsnailEntity;
import net.ttttoooo.thelunaris.entity.custom.PhyrexEntity;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheLunaris.MODID);

	//land animals
    public static final RegistryObject<EntityType<MooncowEntity>> MOONCOW =
            ENTITY_TYPES.register("mooncow", () -> EntityType.Builder.of(MooncowEntity:: new, MobCategory.CREATURE)
            		.sized(2.0F, 2.0F).build("mooncow"));
    
  //amphibious animals
    public static final RegistryObject<EntityType<MoonsnailEntity>> MOONSNAIL =
            ENTITY_TYPES.register("moonsnail", () -> EntityType.Builder.of(MoonsnailEntity:: new, MobCategory.CREATURE)
            		.sized(0.5F, 0.5F).build("moonsnail"));

    //sea animals
    public static final RegistryObject<EntityType<ArchfishEntity>> ARCHFISH =
            ENTITY_TYPES.register("archfish", () -> EntityType.Builder.of(ArchfishEntity:: new, MobCategory.CREATURE)
            		.sized(0.5F, 1.0F).build("archfish"));

  //hostile animals
    public static final RegistryObject<EntityType<PhyrexEntity>> PHYREX =
            ENTITY_TYPES.register("phyrex", () -> EntityType.Builder.of(PhyrexEntity:: new, MobCategory.MONSTER)
            		.sized(2.0F, 1.0F).build("phyrex"));
    public static final RegistryObject<EntityType<LunarsleeperEntity>> LUNARSLEEPER =
            ENTITY_TYPES.register("lunarsleeper", () -> EntityType.Builder.of(LunarsleeperEntity:: new, MobCategory.MONSTER)
            		.sized(2.0F, 1.0F).build("lunarsleeper"));
    public static final RegistryObject<EntityType<HexEntity>> HEX =
            ENTITY_TYPES.register("hex", () -> EntityType.Builder.of(HexEntity:: new, MobCategory.MONSTER)
            		.sized(2.0F, 1.0F).build("hex"));
    

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
