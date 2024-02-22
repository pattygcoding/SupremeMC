package net.pattygcoding.suprememc.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.enchantments.SmeltingEnchantment;

public class SMCEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =  DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SupremeMC.MOD_ID);


    public static final RegistryObject<Enchantment> BOUNTY_BLADE = ENCHANTMENTS.register("bounty_blade",
            () -> new SmeltingEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> SMELTING = ENCHANTMENTS.register("smelting",
            () -> new SmeltingEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    public static void register(IEventBus eventBus)
    {
        ENCHANTMENTS.register(eventBus);
    }
}
