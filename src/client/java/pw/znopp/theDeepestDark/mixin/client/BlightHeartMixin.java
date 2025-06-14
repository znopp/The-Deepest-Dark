package pw.znopp.theDeepestDark.mixin.client;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import pw.znopp.theDeepestDark.client.render.BlightHeartRender;

@Mixin(InGameHud.class)
public class BlightHeartMixin {

    @Redirect(method = "drawHeart",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud$HeartType;getTexture(ZZZ)Lnet/minecraft/util/Identifier;"))
    private Identifier getBlightHeartTexture(InGameHud.HeartType heartType, boolean hardcore, boolean half, boolean blinking) {

        // Only replace NORMAL hearts (and other health-related hearts) when Blight is active
        if (heartType == InGameHud.HeartType.NORMAL ||
                heartType == InGameHud.HeartType.POISONED ||
                heartType == InGameHud.HeartType.WITHERED ||
                heartType == InGameHud.HeartType.FROZEN) {

            return BlightHeartRender.getBlightHeartTexture(heartType, hardcore, half, blinking);
        }

        // For all other heart types (CONTAINER, ABSORBING, etc.), use original texture
        return heartType.getTexture(hardcore, half, blinking);
    }
}