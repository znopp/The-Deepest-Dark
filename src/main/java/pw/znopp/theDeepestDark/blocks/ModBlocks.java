package pw.znopp.theDeepestDark.blocks;

import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import pw.znopp.theDeepestDark.blocks.utils.ModBlockRegistrar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class ModBlocks {

    private static final Collection<ItemStack> items = new ArrayList<>();

    public static void initialize() {
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        Block block = ModBlockRegistrar.register(name, blockFactory, settings, shouldRegisterItem);

        if (shouldRegisterItem) {
            items.add(new ItemStack(block)); // Add default ItemStack representing the block's item
        }

        return block;
    }

    public static Collection<ItemStack> getItems() {
        return items;
    }

    public static final CustomPortalBlock DEEPEST_DARK_PORTAL = (CustomPortalBlock) register(
            "deepest_dark_portal",
            DeepestDarkPortalBlock::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GLASS)
                    .nonOpaque()
                    .noCollision()
                    .strength(-1.0f)
                    .luminance(state -> 11)
                    .dropsNothing(),
            false
    );

    public static final Block POOP = register(
            "poop",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.DIRT),
            true
    );
}
