package pw.znopp.theDeepestDark.interactions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import pw.znopp.theDeepestDark.items.SoulItems;

public class UseSoul {
    public static void triggerEffect(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return;

        user.getStackInHand(hand).decrement(1);

        // Give or drop item depending on available slots
        if (user.getInventory().getEmptySlot() == -1) {
            user.dropItem(new ItemStack(SoulItems.FRACTURED_SOUL), true);
        } else {
            user.giveItemStack(new ItemStack(SoulItems.FRACTURED_SOUL));
        }

        // Sound
        user.playSoundToPlayer(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1f, 0.5f);
    }
}
