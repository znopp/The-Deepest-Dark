package pw.znopp.theDeepestDark.drops;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@FunctionalInterface
public interface BlockDropHandler {
    void handleDrops(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity);
}
