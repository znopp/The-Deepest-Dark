package pw.znopp.theDeepestDark.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import pw.znopp.theDeepestDark.blocks.ModBlocks;

public class TheDeepestDarkClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPEST_DARK_PORTAL, RenderLayer.getTranslucent());
    }
}
