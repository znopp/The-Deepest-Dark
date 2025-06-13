package pw.znopp.theDeepestDark.effects;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import pw.znopp.theDeepestDark.TheDeepestDark;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> BLIGHT_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(TheDeepestDark.MOD_ID, "blight"));
}
