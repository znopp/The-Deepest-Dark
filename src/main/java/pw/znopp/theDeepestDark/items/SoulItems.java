package pw.znopp.theDeepestDark.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pw.znopp.theDeepestDark.items.utils.ModItemRegistrar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class SoulItems {
    public static void initialize() {
    }

    public static final Collection<ItemStack> items = new ArrayList<>();

    public static final Item FRACTURED_SOUL = register("fractured_soul", Item::new);
    public static final Item AWAKENED_SOUL = register("awakened_soul", Item::new);

    private static Item register(String name, Function<Item.Settings, Item> factory) {
        Item item = ModItemRegistrar.register(name, factory, new Item.Settings());
        items.add(item.getDefaultStack());
        return item;
    }

    public static Collection<ItemStack> getItems(){
        return items;
    }

}
