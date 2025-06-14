package pw.znopp.theDeepestDark.drops;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameMode;
import pw.znopp.theDeepestDark.blocks.ModBlocks;
import pw.znopp.theDeepestDark.items.FoodItems;

public class ModBlockDrops {
    public static void register() {
        BlockDropRegistry.register(ModBlocks.POOP, (world, player, pos, state, blockEntity) -> {
            if (world.isClient) return;

            if (player.getGameMode() == GameMode.CREATIVE) return;

            ServerWorld serverWorld = (ServerWorld) world;
            ItemStack drop = new ItemStack(FoodItems.RAW_SCULK_CHUNK);

            // Drop at the block position
            Block.dropStack(serverWorld, pos, drop);
        });
    }
}