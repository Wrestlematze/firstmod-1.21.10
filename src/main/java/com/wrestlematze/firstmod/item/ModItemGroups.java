package com.wrestlematze.firstmod.item;

import com.wrestlematze.firstmod.FirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> key =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FirstMod.MOD_ID, "mod_items"));
    public static final ItemGroup MOD_ITEMS =Registry.register(Registries.ITEM_GROUP,key,
          FabricItemGroup.builder()
              .icon(() -> new ItemStack(ModItems.COLA))
              .displayName(Text.translatable("itemgroup.firstmod.mod_items"))
              .build());


    public static void registerItemGroups() {
        FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);
    }
}
