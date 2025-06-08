package pw.znopp.theDeepestDark.interactions;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pw.znopp.theDeepestDark.items.SoulItems;

public class UseSoul extends Item {

    public UseSoul(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        return triggerEffect(world, user.getBlockPos(), user, hand);
    }

    public static ActionResult triggerEffect(World world, BlockPos pos, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.PASS;

        // Perform raycast to see what the player is looking at (up to 5 blocks away)
        HitResult hit = user.raycast(user.getBlockInteractionRange(), 0.0f, false);

        // Only continue if the raycast hit a block
        if (hit.getType() != HitResult.Type.BLOCK) {
            return ActionResult.FAIL;
        }

        // Spawn cow
        BlockPos frontOfPlayer = pos.offset(user.getHorizontalFacing(), 5);
        CowEntity cow = new CowEntity(EntityType.COW, world);
        cow.setPosition(frontOfPlayer.toCenterPos());
        world.spawnEntity(cow);

        // Replace item
        user.setStackInHand(hand, new ItemStack(SoulItems.FRACTURED_SOUL));

        // Sound
        user.playSoundToPlayer(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1f, 0.5f);

        return ActionResult.SUCCESS;
    }
}
