package pw.znopp.theDeepestDark.blocks;

import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class DeepestDarkPortalBlock extends CustomPortalBlock {

    public DeepestDarkPortalBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            super.randomDisplayTick(state, world, pos, random);
        }
    }
}