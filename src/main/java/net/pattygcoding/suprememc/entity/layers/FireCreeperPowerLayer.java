package net.pattygcoding.suprememc.entity.layers;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.entity.custom.FireCreeperEntity;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class FireCreeperPowerLayer extends EnergySwirlLayer<FireCreeperEntity, CreeperModel<FireCreeperEntity>> {
    private final ResourceLocation powerLocation;
    private final CreeperModel<FireCreeperEntity> model;
    private String path;

    public FireCreeperPowerLayer(RenderLayerParent<FireCreeperEntity, CreeperModel<FireCreeperEntity>> pRenderer, EntityModelSet pModelSet, String pPath) {
        super(pRenderer);
        this.model = new CreeperModel<>(pModelSet.bakeLayer(ModelLayers.CREEPER_ARMOR));
        this.powerLocation = new ResourceLocation(SupremeMC.MOD_ID, pPath);
    }

    protected float xOffset(float pTickCount) {
        return pTickCount * 0.01F;
    }

    protected @NotNull ResourceLocation getTextureLocation() {
        return this.powerLocation;
    }

    protected @NotNull EntityModel<FireCreeperEntity> model() {
        return this.model;
    }
}
