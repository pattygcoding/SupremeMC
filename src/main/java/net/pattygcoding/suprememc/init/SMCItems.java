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
import net.pattygcoding.suprememc.item.SMCToolMaterials;

public class SMCItems {
    public static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, SupremeMC.MOD_ID);

    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND = ITEMS.register("burning_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CALAMARI = ITEMS.register("calamari",
            () -> new Item(new Item.Properties().food(SMCFoods.CALAMARI)));
    public static final RegistryObject<Item> COOKED_CALAMARI = ITEMS.register("cooked_calamari",
            () -> new Item(new Item.Properties().food(SMCFoods.COOKED_CALAMARI)));
    public static final RegistryObject<Item> COOKED_FUGU = ITEMS.register("cooked_fugu",
            () -> new Item(new Item.Properties().food(SMCFoods.COOKED_FUGU)));
    public static final RegistryObject<Item> FUGU = ITEMS.register("fugu",
            () -> new Item(new Item.Properties().food(SMCFoods.FUGU)));
    public static final RegistryObject<Item> ANDESITE_SWORD = ITEMS.register("andesite_sword",
            () -> new SwordItem(SMCToolMaterials.ANDESITE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ANDESITE_SHOVEL = ITEMS.register("andesite_shovel",
            () -> new ShovelItem(SMCToolMaterials.ANDESITE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ANDESITE_PICKAXE = ITEMS.register("andesite_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.ANDESITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ANDESITE_AXE = ITEMS.register("andesite_axe",
            () -> new AxeItem(SMCToolMaterials.ANDESITE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> ANDESITE_HOE = ITEMS.register("andesite_hoe",
            () -> new HoeItem(SMCToolMaterials.ANDESITE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(SMCToolMaterials.AMETHYST, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(SMCToolMaterials.AMETHYST, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.AMETHYST, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(SMCToolMaterials.AMETHYST, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(SMCToolMaterials.AMETHYST, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_SWORD = ITEMS.register("aquamarine_sword",
            () -> new SwordItem(SMCToolMaterials.AQUAMARINE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_SHOVEL = ITEMS.register("aquamarine_shovel",
            () -> new ShovelItem(SMCToolMaterials.AQUAMARINE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_PICKAXE = ITEMS.register("aquamarine_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.AQUAMARINE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_AXE = ITEMS.register("aquamarine_axe",
            () -> new AxeItem(SMCToolMaterials.AQUAMARINE, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_HOE = ITEMS.register("aquamarine_hoe",
            () -> new HoeItem(SMCToolMaterials.AQUAMARINE, -4, 0.0F, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_HELMET = ITEMS.register("aquamarine_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_CHESTPLATE = ITEMS.register("aquamarine_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_LEGGINGS = ITEMS.register("aquamarine_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_BOOTS = ITEMS.register("aquamarine_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.AQUAMARINE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_SWORD = ITEMS.register("blackstone_sword",
            () -> new SwordItem(SMCToolMaterials.BLACKSTONE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_SHOVEL = ITEMS.register("blackstone_shovel",
            () -> new ShovelItem(SMCToolMaterials.BLACKSTONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_PICKAXE = ITEMS.register("blackstone_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.BLACKSTONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_AXE = ITEMS.register("blackstone_axe",
            () -> new AxeItem(SMCToolMaterials.BLACKSTONE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_HOE = ITEMS.register("blackstone_hoe",
            () -> new HoeItem(SMCToolMaterials.BLACKSTONE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_SWORD = ITEMS.register("burning_diamond_sword",
            () -> new SwordItem(SMCToolMaterials.BURNING_DIAMOND, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_SHOVEL = ITEMS.register("burning_diamond_shovel",
            () -> new ShovelItem(SMCToolMaterials.BURNING_DIAMOND, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_PICKAXE = ITEMS.register("burning_diamond_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.BURNING_DIAMOND, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_AXE = ITEMS.register("burning_diamond_axe",
            () -> new AxeItem(SMCToolMaterials.BURNING_DIAMOND, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_HOE = ITEMS.register("burning_diamond_hoe",
            () -> new HoeItem(SMCToolMaterials.BURNING_DIAMOND, -4, 0.0F, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_HELMET = ITEMS.register("burning_diamond_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_CHESTPLATE = ITEMS.register("burning_diamond_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_LEGGINGS = ITEMS.register("burning_diamond_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BURNING_DIAMOND_BOOTS = ITEMS.register("burning_diamond_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.BURNING_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(SMCToolMaterials.COPPER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(SMCToolMaterials.COPPER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.COPPER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(SMCToolMaterials.COPPER, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(SMCToolMaterials.COPPER, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_SWORD = ITEMS.register("deepslate_sword",
            () -> new SwordItem(SMCToolMaterials.DEEPSLATE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_SHOVEL = ITEMS.register("deepslate_shovel",
            () -> new ShovelItem(SMCToolMaterials.DEEPSLATE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_PICKAXE = ITEMS.register("deepslate_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.DEEPSLATE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_AXE = ITEMS.register("deepslate_axe",
            () -> new AxeItem(SMCToolMaterials.DEEPSLATE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_HOE = ITEMS.register("deepslate_hoe",
            () -> new HoeItem(SMCToolMaterials.DEEPSLATE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_SWORD = ITEMS.register("diorite_sword",
            () -> new SwordItem(SMCToolMaterials.DIORITE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_SHOVEL = ITEMS.register("diorite_shovel",
            () -> new ShovelItem(SMCToolMaterials.DIORITE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_PICKAXE = ITEMS.register("diorite_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.DIORITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_AXE = ITEMS.register("diorite_axe",
            () -> new AxeItem(SMCToolMaterials.DIORITE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_HOE = ITEMS.register("diorite_hoe",
            () -> new HoeItem(SMCToolMaterials.DIORITE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_SWORD = ITEMS.register("granite_sword",
            () -> new SwordItem(SMCToolMaterials.GRANITE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_SHOVEL = ITEMS.register("granite_shovel",
            () -> new ShovelItem(SMCToolMaterials.GRANITE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_PICKAXE = ITEMS.register("granite_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.GRANITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_AXE = ITEMS.register("granite_axe",
            () -> new AxeItem(SMCToolMaterials.GRANITE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_HOE = ITEMS.register("granite_hoe",
            () -> new HoeItem(SMCToolMaterials.GRANITE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(SMCToolMaterials.EMERALD, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(SMCToolMaterials.EMERALD, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.EMERALD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(SMCToolMaterials.EMERALD, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(SMCToolMaterials.EMERALD, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new SMCArmorItem(SMCArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new SMCArmorItem(SMCArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new SMCArmorItem(SMCArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new SMCArmorItem(SMCArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(SMCToolMaterials.RUBY, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(SMCToolMaterials.RUBY, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(SMCToolMaterials.RUBY, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(SMCToolMaterials.RUBY, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(SMCToolMaterials.RUBY, -2, -1.0F, new Item.Properties()));
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
