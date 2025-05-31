package pw.znopp.theDeepestDark.items;

import net.minecraft.item.Item;
import pw.znopp.theDeepestDark.interactions.UseSoul;
import pw.znopp.theDeepestDark.items.utils.ModItemRegistrar;

public class SoulItems {
    public static void initialize() {
    }

    public static final Item FRACTURED_SOUL = ModItemRegistrar.register("fractured_soul", Item::new, new Item.Settings());
    public static final Item ACTIVATED_SOUL = ModItemRegistrar.register("activated_soul", UseSoul::new, new Item.Settings());

}
