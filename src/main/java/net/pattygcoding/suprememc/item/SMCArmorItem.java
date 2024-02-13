package net.pattygcoding.suprememc.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.pattygcoding.suprememc.init.SMCItems;

public class SMCArmorItem extends ArmorItem {
    public SMCArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration)
    {
        if(checkNull(pLivingEntity))
        {
            if(checkFullSet(SMCItems.BURNING_DIAMOND_HELMET.get(), SMCItems.BURNING_DIAMOND_CHESTPLATE.get(), SMCItems.BURNING_DIAMOND_LEGGINGS.get(), SMCItems.BURNING_DIAMOND_BOOTS.get(), pLivingEntity))
            {
                giveEffect(pLivingEntity, MobEffects.FIRE_RESISTANCE, 1, 1);
            }
        }

    }

    private boolean checkNull(LivingEntity pLivingEntity)
    {
        return pLivingEntity.getItemBySlot(EquipmentSlot.HEAD) != null &&
                pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() != null &&
                pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() != null &&
                pLivingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() != null;
    }

    private boolean checkFullSet(Item helmet, Item chestplate, Item leggings, Item boots, LivingEntity pLivingEntity)
    {
        return pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == helmet &&
                pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() == chestplate &&
                pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == leggings &&
                pLivingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() == boots;
    }

    private void giveEffect(LivingEntity pLivingEntity, MobEffect mobEffect, int seconds, int amplifier)
    {
        if (pLivingEntity.getEffect(mobEffect) == null || pLivingEntity.getEffect(mobEffect).getDuration() <= 1)
        {
            pLivingEntity.addEffect(new MobEffectInstance(mobEffect, seconds * 20, amplifier - 1, false, false));
        }
    }
}
