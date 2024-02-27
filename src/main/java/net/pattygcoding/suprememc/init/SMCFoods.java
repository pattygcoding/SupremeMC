package net.pattygcoding.suprememc.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SMCFoods {
    public static final FoodProperties CALAMARI = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.4F).build();
    public static final FoodProperties COOKED_CALAMARI = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.8F).meat().build();
    public static final FoodProperties COOKED_FUGU = new FoodProperties.Builder()
            .nutrition(7).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 5), 0.03F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15), 0.1F).build();
    public static final FoodProperties FRIED_EGG = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties FUGU = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 10), 0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 30), 0.3F).build();

}
