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
                        pOutput.accept(SMCBlocks.LOGO_BLOCK.get());
                        pOutput.accept(SMCBlocks.COBBLED_ANDESITE.get());
                        pOutput.accept(SMCBlocks.COBBLED_DIORITE.get());
                        pOutput.accept(SMCBlocks.COBBLED_GRANITE.get());
                        pOutput.accept(SMCBlocks.AQUAMARINE_BLOCK.get());
                        pOutput.accept(SMCBlocks.BURNING_DIAMOND_BLOCK.get());
                        // Ores
                        pOutput.accept(SMCBlocks.AQUAMARINE_ORE.get());
                        pOutput.accept(SMCBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        pOutput.accept(SMCBlocks.BURNING_DIAMOND_ORE.get());
                        // Items
                        pOutput.accept(SMCItems.AQUAMARINE.get());
                        pOutput.accept(SMCItems.BURNING_DIAMOND.get());
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
