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
import java.util.function.Function;

public class FoodItems {
    public static void initialize() {
    }

    private static final Collection<ItemStack> items = new ArrayList<>();


    public static final Item RAW_SCULK_CHUNK = register("raw_sculk_chunk", settings -> new Item(settings
            .food(new FoodComponent.Builder()
                            .nutrition(3)
                            .saturationModifier(2)
                            .build(),
                    ConsumableComponent
                            .builder()
                            .useAction(UseAction.EAT)
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.POISON, 3 * 20, 0), 0.75f))
                            .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.BLOCK_SCULK_SPREAD))
                            .finishSound(Registries.SOUND_EVENT.getEntry(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM))
                            .build())));

    public static final Item SEARED_SCULK_CHUNK = register("seared_sculk_chunk", settings -> new Item(settings
            .food(new FoodComponent.Builder()
                            .nutrition(6)
                            .saturationModifier(4)
                            .build(),
                    ConsumableComponent.builder()
                            .useAction(UseAction.EAT)
                            .consumeEffect(new ApplyEffectsConsumeEffect(
                                    new StatusEffectInstance(StatusEffects.POISON, 3 * 20, 1), 0.10f))
                            .sound(Registries.SOUND_EVENT.getEntry(SoundEvents.BLOCK_SCULK_SPREAD))
                            .finishSound(Registries.SOUND_EVENT.getEntry(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM))
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
