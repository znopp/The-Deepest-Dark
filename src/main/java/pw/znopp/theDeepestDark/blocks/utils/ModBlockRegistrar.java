package pw.znopp.theDeepestDark.blocks.utils;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import pw.znopp.theDeepestDark.TheDeepestDark;

import java.util.function.Function;

public class ModBlockRegistrar {

    public static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TheDeepestDark.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TheDeepestDark.MOD_ID, name));
    }
}
