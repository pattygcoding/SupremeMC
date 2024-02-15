package net.pattygcoding.suprememc.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<Item> BURNING_DIAMOND = ITEMS.register("burning_diamond",
            () -> new Item(new Item.Properties()));

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
