package com.wrestlematze.firstmod.blocks;

import com.wrestlematze.firstmod.FirstMod;
import com.wrestlematze.firstmod.item.ModItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

  public static final Block PINK_GARNET_BLOCK =
      registerBlock(
          "pink_garnet_block",
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK));

  public static final Block RAW_PINK_GARNET_BLOCK =
      registerBlock(
          "raw_pink_garnet_block",
          AbstractBlock.Settings.create()
              .strength(3f)
              .requiresTool()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK));

  public static final Block PINK_GARNET_ORE =
      registerBlock("pink_garnet_ore", AbstractBlock.Settings.create().strength(3f).requiresTool());

  public static final Block COLA_BLOCK =
      registerBlock("cola_block", AbstractBlock.Settings.create().strength(0.2f));

  public static final Block PINK_GARNET_DEEPSLATE_ORE =
      registerBlock(
          "pink_garnet_deepslate_ore",
          AbstractBlock.Settings.create()
              .strength(3f)
              .requiresTool()
              .sounds(BlockSoundGroup.DEEPSLATE));

  private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
    RegistryKey<Block> key =
        RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));
    Block block = new Block(blockSettings.registryKey(key));
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, key, block);
  }

  private static void registerBlockItem(String name, Block block) {
    RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
    BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
    Registry.register(Registries.ITEM, key, item);
  }

  public static void registerModBlocks() {
    FirstMod.LOGGER.info("Registering Mad Blocks for " + FirstMod.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ModItemGroups.key)
        .register(
            entries -> {
              entries.add(ModBlocks.PINK_GARNET_BLOCK);
              entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
              entries.add(ModBlocks.PINK_GARNET_ORE);
              entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
              entries.add(ModBlocks.COLA_BLOCK);
            });
  }
}
