package pw.znopp.theDeepestDark.client.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import pw.znopp.theDeepestDark.TheDeepestDark;
import pw.znopp.theDeepestDark.effects.ModEffects;

public class BlightHeartRender {

    public static Identifier getBlightHeartTexture(InGameHud.HeartType originalType, boolean hardcore, boolean half, boolean blinking) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null && client.player.hasStatusEffect(ModEffects.BLIGHT)) {
            String basePath = "the-deepest-dark:hud/heart/blight";

            if (hardcore) {
                basePath += "_hardcore";
            }

            if (half) {
                basePath += "_half";
            } else {
                basePath += "_full";
            }

            if (blinking) {
                basePath += "_blinking";
            }

            TheDeepestDark.LOGGER.info("Blight heart texture: " + basePath + " (hardcore=" + hardcore + ", half=" + half + ", blinking=" + blinking + ")");


            return Identifier.of(basePath);
        }

        // Now you can call getTexture directly thanks to the access widener!
        return originalType.getTexture(hardcore, half, blinking);
    }
}