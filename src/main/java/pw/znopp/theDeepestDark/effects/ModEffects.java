package pw.znopp.theDeepestDark.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import pw.znopp.theDeepestDark.TheDeepestDark;
import pw.znopp.theDeepestDark.effects.blight.BlightConsumeEffect;
import pw.znopp.theDeepestDark.effects.blight.BlightEffect;

public class ModEffects {

    public static void initialize() {

    }

    public static final RegistryEntry<StatusEffect> BLIGHT =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TheDeepestDark.MOD_ID, "blight"), new BlightEffect());


    public static final ConsumeEffect.Type<BlightConsumeEffect> BLIGHT_CONSUME_EFFECT =
            Registry.register(Registries.CONSUME_EFFECT_TYPE,
                    Identifier.of(TheDeepestDark.MOD_ID, "blight_consume_effect"),
                    new ConsumeEffect.Type<>(BlightConsumeEffect.CODEC, BlightConsumeEffect.PACKET_CODEC));
}
