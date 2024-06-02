package com.desx.rebornworld.entity;

import com.desx.rebornworld.entity.ocean.Bubble;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.desx.rebornworld.RebornWorld.MODID;

public class OceanEntities {


    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<Bubble>> BUBLEA =
            ENTITY_TYPES.register("buble", () -> EntityType.Builder.of( Bubble::new, MobCategory.CREATURE)
                   .build("buble"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
