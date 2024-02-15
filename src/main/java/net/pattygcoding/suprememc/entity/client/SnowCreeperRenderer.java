package net.pattygcoding.suprememc.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.entity.custom.SnowCreeperEntity;
import net.pattygcoding.suprememc.entity.layers.FireCreeperPowerLayer;
import net.pattygcoding.suprememc.entity.layers.SnowCreeperPowerLayer;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SnowCreeperRenderer extends MobRenderer<SnowCreeperEntity, CreeperModel<SnowCreeperEntity>> {
    private static final ResourceLocation CREEPER_LOCATION = new ResourceLocation(SupremeMC.MOD_ID, "textures/entity/snow_creeper/snow_creeper.png");
    public SnowCreeperRenderer(EntityRendererProvider.Context context) {
        super(context, new CreeperModel<>(context.bakeLayer(ModelLayers.CREEPER)), 0.5F);
        this.addLayer(new SnowCreeperPowerLayer(this, context.getModelSet(), "textures/entity/snow_creeper/snow_creeper_armor.png"));
    }

    @Override
    protected void scale(SnowCreeperEntity pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float $$3 = pLivingEntity.getSwelling(pPartialTickTime);
        float $$4 = 1.0F + Mth.sin($$3 * 100.0F) * $$3 * 0.01F;
        $$3 = Mth.clamp($$3, 0.0F, 1.0F);
        $$3 *= $$3;
        $$3 *= $$3;
        float $$5 = (1.0F + $$3 * 0.4F) * $$4;
        float $$6 = (1.0F + $$3 * 0.1F) / $$4;
        pPoseStack.scale($$5, $$6, $$5);
    }

    protected float getWhiteOverlayProgress(SnowCreeperEntity pLivingEntity, float pPartialTicks) {
        float $$2 = pLivingEntity.getSwelling(pPartialTicks);
        return (int)($$2 * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp($$2, 0.5F, 1.0F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SnowCreeperEntity pEntity) {
        return CREEPER_LOCATION;
    }
}
