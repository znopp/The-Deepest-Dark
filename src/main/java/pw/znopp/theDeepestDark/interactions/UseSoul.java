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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pw.znopp.theDeepestDark.items.SoulItems;

public class UseSoul extends Item {

    public UseSoul(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }

        // spawn cow
        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 5);
        CowEntity cow = new CowEntity(EntityType.COW, world);
        cow.setPosition(frontOfPlayer.toCenterPos());
        world.spawnEntity(cow);


        // Plays use sound and replaces item with a fractured soul
        user.playSoundToPlayer(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1f, 0.5f);
        user.setStackInHand(hand, new ItemStack(SoulItems.FRACTURED_SOUL));

        return ActionResult.SUCCESS;
    }
}
