package com.desx.rebornworld.item.shild;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.List;
import java.util.Map;

import static net.minecraft.world.item.enchantment.Enchantments.*;

public class BubbleShild extends ShieldItem {
    public static final int EFFECTIVE_BLOCK_DELAY = 5;
    public static final float MINIMUM_DURABILITY_DAMAGE = 3.0F;
    public static final String TAG_BASE_COLOR = "Base";

    private final Enchantment enchantment; // Добавляем параметр для хранения зачарования

    public BubbleShild(Item.Properties p_43089_, Enchantment enchantment) {
        super(p_43089_);
        this.enchantment = enchantment;
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public String getDescriptionId(ItemStack p_43109_) {
        return BlockItem.getBlockEntityData(p_43109_) != null ? this.getDescriptionId() + "." + getColor(p_43109_).getName() : super.getDescriptionId(p_43109_);
    }

    public void appendHoverText(ItemStack p_43094_, @Nullable Level p_43095_, List<Component> p_43096_, TooltipFlag p_43097_) {
        BannerItem.appendHoverTextFromBannerBlockEntityTag(p_43094_, p_43096_);
    }

    public UseAnim getUseAnimation(ItemStack p_43105_) {
        return UseAnim.BLOCK;
    }



    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    public InteractionResultHolder<ItemStack> use(Level p_43099_, Player p_43100_, InteractionHand p_43101_) {
        ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
        p_43100_.startUsingItem(p_43101_);
        return InteractionResultHolder.consume(itemstack);
    }

    public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is( ItemTags.PLANKS) || super.isValidRepairItem(p_43091_, p_43092_);
    }

    public static DyeColor getColor(ItemStack p_43103_) {
        CompoundTag compoundtag = BlockItem.getBlockEntityData(p_43103_);
        return compoundtag != null ? DyeColor.byId(compoundtag.getInt("Base")) : DyeColor.WHITE;
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

    @Override
    public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
        super.onCraftedBy(itemStack, level, player);
        if (enchantment != null) {
            itemStack.enchant(enchantment, 1);
        }
    }

}