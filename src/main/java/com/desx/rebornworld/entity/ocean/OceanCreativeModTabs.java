package com.desx.rebornworld.entity.ocean;

import com.desx.rebornworld.init.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.desx.rebornworld.RebornWorld.MODID;

public class OceanCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create( Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> OCEAN_TAB = CREATIVE_MODE_TABS.register("ocean_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack( ItemInit.Bubble_Spike.get()))
                    .title( Component.translatable("creativetab.ocean_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemInit.Bubble_Spike.get());
                        pOutput.accept(ItemInit.Bubble_Turtle_Shield.get());
                        pOutput.accept(ItemInit.fishing_rod_of_sea.get());
                        pOutput.accept(ItemInit.BUBBLE_SHIELD.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
