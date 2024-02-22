package net.pattygcoding.suprememc.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;

public class SMCCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SupremeMC.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("suprememc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SMCBlocks.LOGO_BLOCK.get()))
                    .title(Component.translatable("creativetab.suprememc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Building Blocks
                        pOutput.accept(SMCBlocks.COBBLED_ANDESITE.get());
                        pOutput.accept(SMCBlocks.COBBLED_DIORITE.get());
                        pOutput.accept(SMCBlocks.COBBLED_GRANITE.get());
                        pOutput.accept(SMCBlocks.ANDESITE_BRICKS.get());
                        pOutput.accept(SMCBlocks.DIORITE_BRICKS.get());
                        pOutput.accept(SMCBlocks.GRANITE_BRICKS.get());
                        pOutput.accept(SMCBlocks.LOGO_BLOCK.get());
                        pOutput.accept(SMCBlocks.AQUAMARINE_BLOCK.get());
                        pOutput.accept(SMCBlocks.BURNING_DIAMOND_BLOCK.get());
                        // Ores
                        pOutput.accept(SMCBlocks.AQUAMARINE_ORE.get());
                        pOutput.accept(SMCBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        pOutput.accept(SMCBlocks.BURNING_DIAMOND_ORE.get());
                        // Color Blocks
                        pOutput.accept(SMCBlocks.WHITE_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.ORANGE_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.MAGENTA_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.LIGHT_BLUE_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.YELLOW_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.LIME_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.PINK_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.GRAY_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.LIGHT_GRAY_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.CYAN_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.PURPLE_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.BLUE_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.BROWN_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.GREEN_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.RED_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.BLACK_GLOWBLOCK.get());
                        pOutput.accept(SMCBlocks.WHITE_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.ORANGE_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.MAGENTA_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.LIGHT_BLUE_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.YELLOW_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.LIME_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.PINK_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.GRAY_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.LIGHT_GRAY_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.CYAN_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.PURPLE_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.BLUE_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.BROWN_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.GREEN_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.RED_SLIME_BLOCK.get());
                        pOutput.accept(SMCBlocks.BLACK_SLIME_BLOCK.get());
                        // Stairs
                        pOutput.accept(SMCBlocks.SMOOTH_STONE_STAIRS.get());
                        pOutput.accept(SMCBlocks.COBBLED_ANDESITE_STAIRS.get());
                        pOutput.accept(SMCBlocks.COBBLED_DIORITE_STAIRS.get());
                        pOutput.accept(SMCBlocks.COBBLED_GRANITE_STAIRS.get());
                        pOutput.accept(SMCBlocks.GRANITE_BRICK_STAIRS.get());
                        pOutput.accept(SMCBlocks.ANDESITE_BRICK_STAIRS.get());
                        pOutput.accept(SMCBlocks.DIORITE_BRICK_STAIRS.get());
                        pOutput.accept(SMCBlocks.GRANITE_BRICK_STAIRS.get());
                        pOutput.accept(SMCBlocks.NETHERRACK_STAIRS.get());
                        pOutput.accept(SMCBlocks.END_STONE_STAIRS.get());
                        // Slabs
                        pOutput.accept(SMCBlocks.COBBLED_ANDESITE_SLAB.get());
                        pOutput.accept(SMCBlocks.COBBLED_DIORITE_SLAB.get());
                        pOutput.accept(SMCBlocks.COBBLED_GRANITE_SLAB.get());
                        pOutput.accept(SMCBlocks.ANDESITE_BRICK_SLAB.get());
                        pOutput.accept(SMCBlocks.DIORITE_BRICK_SLAB.get());
                        pOutput.accept(SMCBlocks.GRANITE_BRICK_SLAB.get());
                        pOutput.accept(SMCBlocks.NETHERRACK_SLAB.get());
                        pOutput.accept(SMCBlocks.END_STONE_SLAB.get());
                        // Walls
                        pOutput.accept(SMCBlocks.STONE_WALL.get());
                        pOutput.accept(SMCBlocks.SMOOTH_STONE_WALL.get());
                        pOutput.accept(SMCBlocks.COBBLED_ANDESITE_WALL.get());
                        pOutput.accept(SMCBlocks.COBBLED_DIORITE_WALL.get());
                        pOutput.accept(SMCBlocks.COBBLED_GRANITE_WALL.get());
                        pOutput.accept(SMCBlocks.POLISHED_ANDESITE_WALL.get());
                        pOutput.accept(SMCBlocks.POLISHED_DIORITE_WALL.get());
                        pOutput.accept(SMCBlocks.POLISHED_GRANITE_WALL.get());
                        pOutput.accept(SMCBlocks.ANDESITE_BRICK_WALL.get());
                        pOutput.accept(SMCBlocks.DIORITE_BRICK_WALL.get());
                        pOutput.accept(SMCBlocks.GRANITE_BRICK_WALL.get());
                        pOutput.accept(SMCBlocks.NETHERRACK_WALL.get());
                        pOutput.accept(SMCBlocks.END_STONE_WALL.get());
                        // Items
                        pOutput.accept(SMCItems.AQUAMARINE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND.get());
                        // Foods
                        pOutput.accept(SMCItems.CALAMARI.get());
                        pOutput.accept(SMCItems.COOKED_CALAMARI.get());
                        pOutput.accept(SMCItems.FUGU.get());
                        pOutput.accept(SMCItems.COOKED_FUGU.get());
                        // Tools
                        pOutput.accept(SMCItems.ANDESITE_SWORD.get());
                        pOutput.accept(SMCItems.ANDESITE_SHOVEL.get());
                        pOutput.accept(SMCItems.ANDESITE_PICKAXE.get());
                        pOutput.accept(SMCItems.ANDESITE_AXE.get());
                        pOutput.accept(SMCItems.ANDESITE_HOE.get());
                        pOutput.accept(SMCItems.BLACKSTONE_SWORD.get());
                        pOutput.accept(SMCItems.BLACKSTONE_SHOVEL.get());
                        pOutput.accept(SMCItems.BLACKSTONE_PICKAXE.get());
                        pOutput.accept(SMCItems.BLACKSTONE_AXE.get());
                        pOutput.accept(SMCItems.BLACKSTONE_HOE.get());
                        pOutput.accept(SMCItems.DEEPSLATE_SWORD.get());
                        pOutput.accept(SMCItems.DEEPSLATE_SHOVEL.get());
                        pOutput.accept(SMCItems.DEEPSLATE_PICKAXE.get());
                        pOutput.accept(SMCItems.DEEPSLATE_AXE.get());
                        pOutput.accept(SMCItems.DEEPSLATE_HOE.get());
                        pOutput.accept(SMCItems.DIORITE_SWORD.get());
                        pOutput.accept(SMCItems.DIORITE_SHOVEL.get());
                        pOutput.accept(SMCItems.DIORITE_PICKAXE.get());
                        pOutput.accept(SMCItems.DIORITE_AXE.get());
                        pOutput.accept(SMCItems.DIORITE_HOE.get());
                        pOutput.accept(SMCItems.GRANITE_SWORD.get());
                        pOutput.accept(SMCItems.GRANITE_SHOVEL.get());
                        pOutput.accept(SMCItems.GRANITE_PICKAXE.get());
                        pOutput.accept(SMCItems.GRANITE_AXE.get());
                        pOutput.accept(SMCItems.GRANITE_HOE.get());
                        pOutput.accept(SMCItems.AQUAMARINE_SWORD.get());
                        pOutput.accept(SMCItems.AQUAMARINE_SHOVEL.get());
                        pOutput.accept(SMCItems.AQUAMARINE_PICKAXE.get());
                        pOutput.accept(SMCItems.AQUAMARINE_AXE.get());
                        pOutput.accept(SMCItems.AQUAMARINE_HOE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_SWORD.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_SHOVEL.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_PICKAXE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_AXE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_HOE.get());
                        // Armor
                        pOutput.accept(SMCItems.AQUAMARINE_HELMET.get());
                        pOutput.accept(SMCItems.AQUAMARINE_CHESTPLATE.get());
                        pOutput.accept(SMCItems.AQUAMARINE_LEGGINGS.get());
                        pOutput.accept(SMCItems.AQUAMARINE_BOOTS.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_HELMET.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_CHESTPLATE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_LEGGINGS.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND_BOOTS.get());
                        // Spawn Eggs
                        pOutput.accept(SMCItems.FIRE_CREEPER_SPANW_EGG.get());
                        pOutput.accept(SMCItems.SNOW_CREEPER_SPANW_EGG.get());
                        pOutput.accept(SMCItems.SOUL_CREEPER_SPANW_EGG.get());
                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
