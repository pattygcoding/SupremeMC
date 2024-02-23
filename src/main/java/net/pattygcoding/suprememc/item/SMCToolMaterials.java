package net.pattygcoding.suprememc.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.pattygcoding.suprememc.init.SMCBlocks;
import net.pattygcoding.suprememc.init.SMCItems;

import java.util.function.Supplier;

public enum SMCToolMaterials implements Tier
{
    AMETHYST(2, 386, 6.0F, 2.0F, 9,
            () -> Ingredient.of(Items.AMETHYST_SHARD)),
    ANDESITE(1, 131, 4.0F, 1.0F, 5,
            () -> Ingredient.of(SMCBlocks.COBBLED_ANDESITE.get().asItem())),
    BLACKSTONE(1, 131, 4.0F, 1.0F, 5,
            () -> Ingredient.of(Blocks.BLACKSTONE.asItem())),
    AQUAMARINE(3, 1561, 8.0F, 3.0F, 10,
            () -> Ingredient.of(SMCItems.AQUAMARINE.get())),
    BURNING_DIAMOND(3, 1561, 8.0F, 3.0F, 10,
            () -> Ingredient.of(SMCItems.AQUAMARINE.get())),
    COPPER(2, 213, 5.5F, 1.5F, 9,
            () -> Ingredient.of(Items.COPPER_INGOT)),
    DEEPSLATE(1, 131, 4.0F, 1.0F, 5,
            () -> Ingredient.of(Blocks.DEEPSLATE.asItem())),
    DIORITE(1, 131, 4.0F, 1.0F, 5,
            () -> Ingredient.of(SMCBlocks.COBBLED_DIORITE.get().asItem())),
    EMERALD(2, 550, 6.5F, 2.5F, 14,
            () -> Ingredient.of(Items.EMERALD)),
    GRANITE(1, 131, 4.0F, 1.0F, 5,
            () -> Ingredient.of(SMCBlocks.COBBLED_GRANITE.get().asItem())),
    RUBY(2, 250, 6.0F, 2.0F, 40,
            () -> Ingredient.of(SMCItems.RUBY.get()));

    private final int uses;
    private final float speed;
    private final float damage;
    private final int level;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    SMCToolMaterials(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue(pRepairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
