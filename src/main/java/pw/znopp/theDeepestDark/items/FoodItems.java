package pw.znopp.theDeepestDark.items;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
import pw.znopp.theDeepestDark.items.utils.ModItemRegistrar;

public class FoodItems {
    public static void initialize() {
    }

    public static final Item RAW_SCULK = ModItemRegistrar.register(
            "raw_sculk",
            Item::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(1)
                            .saturationModifier(1)
                            .build(),
                ConsumableComponent
                        .builder()
                        .useAction(UseAction.DRINK)
                        .consumeSeconds(0.5f)
                        .consumeEffect(new ApplyEffectsConsumeEffect(
                                new StatusEffectInstance(StatusEffects.POISON,
                                        3 * 20,
                                        0),
                                0.5f))
                        .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_AXE_SCRAPE))
                        .finishSound(SoundEvents.ENTITY_BREEZE_WIND_BURST)
                        .build())
    );

    public static final Item COOKED_SCULK = ModItemRegistrar.register(
            "cooked_sculk",
            Item::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(2)
                            .saturationModifier(2)
                            .build(),
                    ConsumableComponent.builder()
                            .useAction(UseAction.SPEAR)
                            .consumeSeconds(0.5f)
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.BLINDNESS,
                                            3 * 20,
                                            0),
                                    0.5f))
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.POISON,
                                            20,
                                            1),
                                    0.05f))
                            .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_AXE_SCRAPE))
                            .finishSound(SoundEvents.ENTITY_BREEZE_WIND_BURST)
                            .build())
    );
}
