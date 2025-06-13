package pw.znopp.theDeepestDark.effects.blight;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import pw.znopp.theDeepestDark.effects.ModDamageTypes;

public class BlightEffect extends StatusEffect {

    public BlightEffect() {
        super(StatusEffectCategory.HARMFUL, 0x009295);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // The effect triggers every 40 >> amplifier ticks (40 ticks = 2 seconds at amplifier 0)
        int interval = 160 >> amplifier; // Higher amplifier = faster ticking
        if (interval <= 0) {
            interval = 1; // Prevent division by zero
        }
        return duration % interval == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) { // Deal 1 point of magic damage (0.5 hearts)
            DamageSource damageSource = new DamageSource(
                    world.getRegistryManager()
                            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                            .getEntry(ModDamageTypes.BLIGHT_DAMAGE.getValue()).get()
            );

            Vec3d preVelocity = entity.getVelocity();

            entity.damage(world, damageSource, 2.0f);

            entity.setVelocity(preVelocity);

        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

}
