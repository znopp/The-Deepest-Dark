package pw.znopp.theDeepestDark.drops;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BlockDropRegistry {
    private static final Map<Block, BlockDropHandler> HANDLERS = new HashMap<>();

    public static void register(Block block, BlockDropHandler handler) {
        HANDLERS.put(block, handler);
    }

    public static void init() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            BlockDropHandler handler = HANDLERS.get(state.getBlock());
            if (handler == null) {
                return;
            }
            handler.handleDrops(world, player, pos, state, blockEntity);
        });
    }
}