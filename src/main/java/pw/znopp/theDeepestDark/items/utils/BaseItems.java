package pw.znopp.theDeepestDark.items.utils;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pw.znopp.theDeepestDark.TheDeepestDark;
import pw.znopp.theDeepestDark.items.FoodItems;
import pw.znopp.theDeepestDark.items.SoulItems;

public class BaseItems {

    public static final RegistryKey<ItemGroup> TDD_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TheDeepestDark.MOD_ID, "item_group"));

    public static final ItemGroup TDD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SoulItems.AWAKENED_SOUL))
            .displayName(Text.translatable("itemGroup.the-deepest-dark"))
            .build();

    public static void initialize() {
        SoulItems.initialize();
        FoodItems.initialize();

        Registry.register(Registries.ITEM_GROUP, TDD_ITEM_GROUP_KEY, TDD_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(TDD_ITEM_GROUP_KEY).register(entries -> {
            entries.addAll(SoulItems.getItems());
            entries.addAll(FoodItems.getItems());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(entries -> {
            entries.addAll(SoulItems.getItems());
            entries.addAll(FoodItems.getItems());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAll(FoodItems.getItems());
        });

    }
}
