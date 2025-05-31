package pw.znopp.theDeepestDark.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;
import pw.znopp.theDeepestDark.items.utils.ModItemRegistrar;

public class FoodItems {
    public static void initialize() {
    }

    public static final Item RAW_SCULK = ModItemRegistrar.register("raw_sculk", Item::new, new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(2)
                    .build())
            .component(DataComponentTypes.CONSUMABLE, ConsumableComponent
                    .builder()
                    .useAction(UseAction.DRINK)
                    .consumeSeconds(3)
                    .sound(SoundEvents.BLOCK_NOTE_BLOCK_PLING)
                    .build()));
}
