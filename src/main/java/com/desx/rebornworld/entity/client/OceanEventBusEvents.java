package com.desx.rebornworld.entity.client;

import com.desx.rebornworld.entity.OceanEntities;
import com.desx.rebornworld.entity.ocean.Bubble;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.desx.rebornworld.RebornWorld.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OceanEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(OceanEntities.BUBLEA.get(), Bubble.createAttributes().build());
    }
}
