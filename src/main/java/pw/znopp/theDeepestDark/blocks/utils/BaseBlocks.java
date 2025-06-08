package pw.znopp.theDeepestDark.blocks.utils;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import pw.znopp.theDeepestDark.blocks.ModBlocks;
import pw.znopp.theDeepestDark.items.utils.BaseItems;

public class BaseBlocks {

    public static void initialize() {
        ModBlocks.initialize();

        ItemGroupEvents.modifyEntriesEvent(BaseItems.TDD_ITEM_GROUP_KEY).register(entries -> {
            entries.addAll(ModBlocks.getItems());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(entries -> {
            entries.addAll(ModBlocks.getItems());
        });

    }
}
