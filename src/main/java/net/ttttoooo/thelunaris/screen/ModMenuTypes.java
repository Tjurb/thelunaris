package net.ttttoooo.thelunaris.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheLunaris.MODID);

    public static final RegistryObject<MenuType<LunarCrafterMenu>> LUNAR_CRAFTING_MENU =
            registerMenuType("lunar_crafting_menu", LunarCrafterMenu::new);
    
    public static final RegistryObject<MenuType<VailstoneFurnaceMenu>> VAILSTONE_FURNACE_MENU =
            registerMenuType("vailstone_furnace_menu", VailstoneFurnaceMenu::new);


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}