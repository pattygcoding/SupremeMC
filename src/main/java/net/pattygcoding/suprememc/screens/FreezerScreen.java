package net.pattygcoding.suprememc.screens;

import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pattygcoding.suprememc.SupremeMC;

@OnlyIn(Dist.CLIENT)
public class FreezerScreen extends AbstractFreezerScreen<FreezerMenu> {
    private static final ResourceLocation LIT_PROGRESS_SPRITE = new ResourceLocation(SupremeMC.MOD_ID, "container/freezer/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = new ResourceLocation(SupremeMC.MOD_ID, "container/freezer/burn_progress");
    private static final ResourceLocation TEXTURE = new ResourceLocation(SupremeMC.MOD_ID, "textures/gui/container/freezer.png");

    public FreezerScreen(FreezerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, new SmeltingRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE);
    }
}
