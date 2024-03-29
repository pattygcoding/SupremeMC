package net.pattygcoding.suprememc;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pattygcoding.suprememc.entity.client.FireCreeperRenderer;
import net.pattygcoding.suprememc.entity.client.SnowCreeperRenderer;
import net.pattygcoding.suprememc.entity.client.SoulCreeperRenderer;
import net.pattygcoding.suprememc.init.*;
import net.pattygcoding.suprememc.screens.FreezerScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SupremeMC.MOD_ID)
public class SupremeMC
{
    public static final String MOD_ID = "suprememc";
    private static final Logger LOGGER = LogUtils.getLogger();
    public SupremeMC()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SMCItems.register(modEventBus);
        SMCBlocks.register(modEventBus);
        SMCEnchantments.register(modEventBus);
        SMCEntities.register(modEventBus);
        SMCBlockEntities.register(modEventBus);
        SMCRecipes.registerSerializers(modEventBus);
        SMCMenus.register(modEventBus);
        SMCCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(SMCEntities.FIRE_CREEPER.get(), FireCreeperRenderer::new);
            EntityRenderers.register(SMCEntities.SNOW_CREEPER.get(), SnowCreeperRenderer::new);
            EntityRenderers.register(SMCEntities.SOUL_CREEPER.get(), SoulCreeperRenderer::new);

            MenuScreens.register(SMCMenus.FREEZER_MENU.get(), FreezerScreen::new);
        }
    }
}
