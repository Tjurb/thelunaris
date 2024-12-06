package net.ttttoooo.thelunaris;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.block.entitiy.ModBlockEntities;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.client.ArchfishRenderer;
import net.ttttoooo.thelunaris.entity.client.HexRenderer;
import net.ttttoooo.thelunaris.entity.client.LunarsleeperRenderer;
import net.ttttoooo.thelunaris.entity.client.MooncowRenderer;
import net.ttttoooo.thelunaris.entity.client.MoonsnailRenderer;
import net.ttttoooo.thelunaris.entity.client.PhyrexRenderer;
import net.ttttoooo.thelunaris.item.ModCreativeTabs;
import net.ttttoooo.thelunaris.item.ModItems;
import net.ttttoooo.thelunaris.recipe.ModRecipes;
import net.ttttoooo.thelunaris.screen.LunarCrafterScreen;
import net.ttttoooo.thelunaris.screen.ModMenuTypes;
import net.ttttoooo.thelunaris.screen.VailstoneFurnaceScreen;
import net.ttttoooo.thelunaris.worldgen.dimension.ModPoi;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheLunaris.MODID)
public class TheLunaris
{
    public static final String MODID = "thelunaris";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public TheLunaris()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        
        ModEntities.register(modEventBus);
        
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        
        ModRecipes.register(modEventBus);
        
        ModPoi.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ORANGEYE.getId(), ModBlocks.POTTED_ORANGEYE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CYANEYE.getId(), ModBlocks.POTTED_CYANEYE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MAGENTEYE.getId(), ModBlocks.POTTED_MAGENTEYE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LUN_CLOVER.getId(), ModBlocks.POTTED_LUN_CLOVER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BRAMBLE.getId(), ModBlocks.POTTED_BRAMBLE);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    	if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
    		event.accept(ModItems.MOONDIAL);
    		event.accept(ModItems.MOONSTEEL);
    		event.accept(ModItems.EMOONSTEEL);
    		event.accept(ModItems.LUNARITE);
    	}
    	if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    		event.accept(ModBlocks.MOONDIALBLOCK);
    		event.accept(ModBlocks.VAILSTONE);
    		event.accept(ModBlocks.VAILSTONEBRICK);
    	}
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from Lunaris server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        	EntityRenderers.register(ModEntities.MOONCOW.get(), MooncowRenderer::new);
        	EntityRenderers.register(ModEntities.ARCHFISH.get(), ArchfishRenderer::new);
        	EntityRenderers.register(ModEntities.MOONSNAIL.get(), MoonsnailRenderer::new);
        	EntityRenderers.register(ModEntities.PHYREX.get(), PhyrexRenderer::new);
        	EntityRenderers.register(ModEntities.LUNARSLEEPER.get(), LunarsleeperRenderer::new);
        	EntityRenderers.register(ModEntities.HEX.get(), HexRenderer::new);
        	EntityRenderers.register(ModEntities.HEX_PROJECTILE.get(), ThrownItemRenderer::new);
        	
            MenuScreens.register(ModMenuTypes.LUNAR_CRAFTING_MENU.get(), LunarCrafterScreen::new);
            MenuScreens.register(ModMenuTypes.VAILSTONE_FURNACE_MENU.get(), VailstoneFurnaceScreen::new);
            
            LOGGER.info("HELLO FROM LUNARIS CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
