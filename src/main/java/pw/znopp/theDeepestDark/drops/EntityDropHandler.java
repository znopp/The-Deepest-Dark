package pw.znopp.theDeepestDark.drops;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

@FunctionalInterface
public interface EntityDropHandler {
    void handleDrops(LivingEntity entity, DamageSource source);
}
