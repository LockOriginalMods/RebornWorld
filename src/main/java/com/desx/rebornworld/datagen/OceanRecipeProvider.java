package com.desx.rebornworld.datagen;

import com.desx.rebornworld.init.BlockInit;
import com.desx.rebornworld.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static com.desx.rebornworld.RebornWorld.MODID;
import static net.minecraft.data.models.model.TextureMapping.pattern;

public class OceanRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public OceanRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.BUBBLE_SHIELD.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ItemInit.Bubble_Spike.get())
                .unlockedBy(getHasName(ItemInit.Bubble_Spike.get()), has(ItemInit.Bubble_Spike.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.fishing_rod_of_sea.get())
                .pattern("SE ")
                .pattern("   ")
                .pattern("   ")
                .define('S', Items.FISHING_ROD)
                .define('E', Items.SEAGRASS)
                .unlockedBy(getHasName( BlockInit.BUBBLE_EGG_BLOCK.get()), has(BlockInit.BUBBLE_EGG_BLOCK.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic( Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}