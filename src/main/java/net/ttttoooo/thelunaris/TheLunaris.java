package net.ttttoooo.thelunaris;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
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
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.client.ArchfishRenderer;
import net.ttttoooo.thelunaris.entity.client.HexRenderer;
import net.ttttoooo.thelunaris.entity.client.LunarsleeperRenderer;
import net.ttttoooo.thelunaris.entity.client.MooncowRenderer;
import net.ttttoooo.thelunaris.entity.client.MoonsnailRenderer;
import net.ttttoooo.thelunaris.entity.client.PhyrexRenderer;
import net.ttttoooo.thelunaris.item.ModCreativeTabs;
import net.ttttoooo.thelunaris.item.ModItems;

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
        
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM The Lunaris");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
       
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
            LOGGER.info("HELLO FROM LUNARIS CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
