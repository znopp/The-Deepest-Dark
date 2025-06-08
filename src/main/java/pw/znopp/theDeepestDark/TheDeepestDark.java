package pw.znopp.theDeepestDark;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pw.znopp.theDeepestDark.blocks.ModBlocks;
import pw.znopp.theDeepestDark.blocks.utils.BaseBlocks;
import pw.znopp.theDeepestDark.interactions.UseSoul;
import pw.znopp.theDeepestDark.items.SoulItems;
import pw.znopp.theDeepestDark.items.utils.BaseItems;

public class TheDeepestDark implements ModInitializer {
    public static final String MOD_ID = "the-deepest-dark";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        LOGGER.info("The Deepest Dark Initializing");

        BaseItems.initialize();

        BaseBlocks.initialize();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .customPortalBlock(ModBlocks.DEEPEST_DARK_PORTAL)
                .lightWithItem(SoulItems.ACTIVATED_SOUL)
                .registerIgniteEvent((player, world, pos, blockPos1, ignitionSource) -> {
                    UseSoul.triggerEffect(world, pos, player, player.getActiveHand());
                })
                .destDimID(Identifier.of(MOD_ID, "the-deepest-dark-dimension"))
                .tintColor(0x23a5a3)
                .registerPortal();
    }
}
