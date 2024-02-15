package net.pattygcoding.suprememc.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.pattygcoding.suprememc.entity.custom.SnowCreeperEntity;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class SnowCreeperSwellGoal extends Goal {
    private final SnowCreeperEntity creeper;
    @Nullable
    private LivingEntity target;

    public SnowCreeperSwellGoal(SnowCreeperEntity pCreeper) {
        this.creeper = pCreeper;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity $$0 = this.creeper.getTarget();
        return this.creeper.getSwellDir() > 0 || $$0 != null && this.creeper.distanceToSqr($$0) < 9.0;
    }

    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.creeper.setSwellDir(-1);
        } else if (this.creeper.distanceToSqr(this.target) > 49.0) {
            this.creeper.setSwellDir(-1);
        } else if (!this.creeper.getSensing().hasLineOfSight(this.target)) {
            this.creeper.setSwellDir(-1);
        } else {
            this.creeper.setSwellDir(1);
        }
    }
}
