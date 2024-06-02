package com.desx.rebornworld.datagen;

import com.desx.rebornworld.init.BlockInit;

import com.desx.rebornworld.loot.AddSusSandBlockModifier;
import com.desx.rebornworld.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.desx.rebornworld.RebornWorld.MODID;

public class OceanGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public OceanGlobalLootModifiersProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void start() {

        add("bubble_egg_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));

        add("bubble_eggs_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_well")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));

        add("bubble_egggs_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));

        add("bubble_eg_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_warm")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));

        add("bubble_egs_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_common")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));

        add("bubble_es_from_suspicious_sand", new AddSusSandBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_rare")).build() }, BlockInit.BUBBLE_EGG_BLOCK.get()));




    }
}