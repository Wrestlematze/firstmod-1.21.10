package com.wrestlematze.firstmod.item;

import com.wrestlematze.firstmod.FirstMod;
import com.wrestlematze.firstmod.effect.ModEffects;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final Item PINK_GARNET = registerItem("pink_garnet", new Item.Settings());
  public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item.Settings());
  public static final Item COLA =
      registerItem(
          "cola",
          new Item.Settings()
              .food(
                  new FoodComponent.Builder()
                      .nutrition(8)
                      .saturationModifier(0.8f)
                      .alwaysEdible()
                      .build(),
                  ConsumableComponents.food()
                      .consumeEffect(
                          new ApplyEffectsConsumeEffect(
                              new StatusEffectInstance(ModEffects.COLA, 60 * 20, 1)))
                      .build()));

  private static Item registerItem(String name, Item.Settings itemSettings) {
    RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
    Item item = new Item(itemSettings.registryKey(key));
    return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
  }

  public static void registerModItems() {
    FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ModItemGroups.key)
        .register(
            entries -> {
              entries.add(PINK_GARNET);
              entries.add(RAW_PINK_GARNET);
              entries.add(COLA);
            });
  }
}
