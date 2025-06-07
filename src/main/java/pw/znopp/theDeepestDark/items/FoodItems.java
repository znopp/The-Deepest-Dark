package pw.znopp.theDeepestDark.items;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
import pw.znopp.theDeepestDark.items.utils.ModItemRegistrar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class FoodItems {
    public static void initialize() {
    }

    private static final Collection<ItemStack> items = new ArrayList<>();


    public static final Item RAW_SCULK = register("raw_sculk", settings -> new Item(settings
            .food(new FoodComponent.Builder()
                            .nutrition(1)
                            .saturationModifier(1)
                            .build(),
                    ConsumableComponent
                            .builder()
                            .useAction(UseAction.DRINK)
                            .consumeSeconds(0.5f)
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.POISON, 3 * 20, 0), 0.5f))
                            .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_AXE_SCRAPE))
                            .finishSound(SoundEvents.ENTITY_BREEZE_WIND_BURST)
                            .build())));

    public static final Item COOKED_SCULK = register("cooked_sculk", settings -> new Item(settings
            .food(new FoodComponent.Builder()
                            .nutrition(2)
                            .saturationModifier(2)
                            .build(),
                    ConsumableComponent.builder()
                            .useAction(UseAction.SPEAR)
                            .consumeSeconds(0.5f)
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.BLINDNESS, 3 * 20, 0), 0.5f))
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.POISON, 20, 1), 0.05f))
                            .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_AXE_SCRAPE))
                            .finishSound(SoundEvents.ENTITY_BREEZE_WIND_BURST)
                            .build())));

    private static Item register(String name, Function<Item.Settings, Item> factory) {
        Item item = ModItemRegistrar.register(name, factory, new Item.Settings());
        items.add(item.getDefaultStack());
        return item;
    }

    public static Collection<ItemStack> getItems() {
        return items;
    }
}
