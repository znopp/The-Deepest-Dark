package pw.znopp.theDeepestDark.effects.blight;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.world.World;
import pw.znopp.theDeepestDark.effects.ModEffects;

public class BlightConsumeEffect implements ConsumeEffect {
    public static final MapCodec<BlightConsumeEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    StatusEffectInstance.CODEC.fieldOf("effect").forGetter(effect -> effect.statusEffect),
                    Codec.FLOAT.fieldOf("probability").forGetter(effect -> effect.probability)
            ).apply(instance, BlightConsumeEffect::new)
    );

    public static final PacketCodec<RegistryByteBuf, BlightConsumeEffect> PACKET_CODEC = PacketCodec.tuple(
            StatusEffectInstance.PACKET_CODEC, effect -> effect.statusEffect,
            PacketCodecs.FLOAT, effect -> effect.probability,
            BlightConsumeEffect::new
    );

    private final StatusEffectInstance statusEffect;
    private final float probability;

    public BlightConsumeEffect(StatusEffectInstance effect, float probability) {
        this.statusEffect = effect;
        this.probability = probability;
    }

    @Override
    public ConsumeEffect.Type<BlightConsumeEffect> getType() {
        return ModEffects.BLIGHT_CONSUME_EFFECT;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        if (world.getRandom().nextFloat() < probability) {
            // Only apply if they don't already have the effect
            if (!user.hasStatusEffect(ModEffects.BLIGHT)) {
                user.addStatusEffect(new StatusEffectInstance(statusEffect));
                return true;
            }
        }
        return false;
    }
}