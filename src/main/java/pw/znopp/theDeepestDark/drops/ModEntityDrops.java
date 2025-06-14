package pw.znopp.theDeepestDark.drops;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import pw.znopp.theDeepestDark.blocks.ModBlocks;
import pw.znopp.theDeepestDark.items.SoulItems;

public class ModEntityDrops {
    public static void register() {
        // Warden
        EntityDropRegistry.register(EntityType.WARDEN, (entity, source) -> {
            if (entity.getWorld().isClient) return;

            ServerWorld world = (ServerWorld) entity.getWorld();
            ItemStack drop = new ItemStack(SoulItems.FRACTURED_SOUL);
            entity.dropStack(world, drop);
        });

        EntityDropRegistry.register(EntityType.BAT, ((entity, source) -> {
            if (entity.getWorld().isClient) return;

            ServerWorld world = (ServerWorld) entity.getWorld();
            ItemStack drop = new ItemStack(ModBlocks.POOP);
            entity.dropStack(world, drop);
        }));
    }
}
