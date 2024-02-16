package net.pattygcoding.suprememc.init;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.item.SMCArmorItem;
import net.pattygcoding.suprememc.item.SMCArmorMaterials;

public class SMCItems {
    public static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, SupremeMC.MOD_ID);

    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND = ITEMS.register("burning_diamond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AQUAMARINE_SWORD = ITEMS.register("aquamarine_sword",
            () -> new SwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_SHOVEL = ITEMS.register("aquamarine_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_PICKAXE = ITEMS.register("aquamarine_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_AXE = ITEMS.register("aquamarine_axe",
            () -> new AxeItem(Tiers.DIAMOND, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_HOE = ITEMS.register("aquamarine_hoe",
            () -> new HoeItem(Tiers.DIAMOND, -4, 0.0F, new Item.Properties()));

    public static final RegistryObject<Item> AQUAMARINE_HELMET = ITEMS.register("aquamarine_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_CHESTPLATE = ITEMS.register("aquamarine_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_LEGGINGS = ITEMS.register("aquamarine_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_BOOTS = ITEMS.register("aquamarine_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> BURNING_DIAMOND_SWORD = ITEMS.register("burning_diamond_sword",
            () -> new SwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_SHOVEL = ITEMS.register("burning_diamond_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_PICKAXE = ITEMS.register("burning_diamond_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_AXE = ITEMS.register("burning_diamond_axe",
            () -> new AxeItem(Tiers.DIAMOND, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_HOE = ITEMS.register("burning_diamond_hoe",
            () -> new HoeItem(Tiers.DIAMOND, -4, 0.0F, new Item.Properties()));

    public static final RegistryObject<Item> BURNING_DIAMOND_HELMET = ITEMS.register("burning_diamond_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_CHESTPLATE = ITEMS.register("burning_diamond_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_LEGGINGS = ITEMS.register("burning_diamond_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_BOOTS = ITEMS.register("burning_diamond_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> FIRE_CREEPER_SPANW_EGG = ITEMS.register("fire_creeper_spawn_egg",
            () -> new ForgeSpawnEggItem(SMCEntities.FIRE_CREEPER, 0xD4300D, 0x000000, new Item.Properties()));

    public static final RegistryObject<Item> SNOW_CREEPER_SPANW_EGG = ITEMS.register("snow_creeper_spawn_egg",
            () -> new ForgeSpawnEggItem(SMCEntities.SNOW_CREEPER, 0xFFFFFF, 0xBFFCFF, new Item.Properties()));

    public static final RegistryObject<Item> SOUL_CREEPER_SPANW_EGG = ITEMS.register("soul_creeper_spawn_egg",
            () -> new ForgeSpawnEggItem(SMCEntities.SOUL_CREEPER, 0x5BF7FF, 0x000000, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
