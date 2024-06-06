package com.desx.rebornworld.init;

import com.desx.rebornworld.entity.OceanEntities;
import com.desx.rebornworld.item.shild.BubbleShild;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.desx.rebornworld.RebornWorld.MODID;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> Bubble_Turtle_Shield = ITEMS.register("bubble_turtle_shield",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Bubble_Spike = ITEMS.register("bubble_spike",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> fishing_rod_of_sea = ITEMS.register("fishing_rod_of_sea",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BUBBLE_SHIELD = ITEMS.register( "bubble_shield",
            () -> new BubbleShild( new Item.Properties( ).durability( 700 ),Enchantments.THORNS));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
