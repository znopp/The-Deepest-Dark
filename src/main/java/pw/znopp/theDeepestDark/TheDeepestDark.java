package pw.znopp.theDeepestDark;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pw.znopp.theDeepestDark.items.utils.BaseItems;

public class TheDeepestDark implements ModInitializer {
    public static final String MOD_ID = "the-deepest-dark";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        LOGGER.info("The Deepest Dark Initializing");

        BaseItems.initialize();
    }
}
