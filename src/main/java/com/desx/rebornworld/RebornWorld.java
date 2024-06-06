package com.desx.rebornworld;

import com.desx.rebornworld.entity.OceanEntities;
import com.desx.rebornworld.entity.ocean.OceanCreativeModTabs;
import com.desx.rebornworld.init.BlockInit;
import com.desx.rebornworld.init.ItemInit;
import com.desx.rebornworld.loot.OceanLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.desx.rebornworld.entity.client.turtleRenderer;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.desx.rebornworld.entity.OceanEntities.*;


@Mod(RebornWorld.MODID)
public class RebornWorld
{
    public static final String MODID = "rebornworld";

    private static final Logger LOGGER = LogUtils.getLogger();


    public RebornWorld()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        OceanEntities.register(modEventBus);
        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);
        OceanLootModifiers.register(modEventBus);
        OceanCreativeModTabs.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }



    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register( BUBLEA.get(), turtleRenderer::new);
        }
    }
}
