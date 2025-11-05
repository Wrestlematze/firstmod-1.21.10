package com.wrestlematze.firstmod.effect;

import com.wrestlematze.firstmod.FirstMod;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
  public static RegistryEntry<StatusEffect> SLIMEY =
      registerStatusEffect("slimey", new SlimeyEffect());

  public static RegistryEntry<StatusEffect> COLA = registerStatusEffect("cola", new ColaEffect());

  private static RegistryEntry<StatusEffect> registerStatusEffect(
      String name, StatusEffect statusEffect) {
    return Registry.registerReference(
        Registries.STATUS_EFFECT, Identifier.of(FirstMod.MOD_ID, name), statusEffect);
  }

  public static void registerEffects() {
    FirstMod.LOGGER.info("Registering Mod Effects for " + FirstMod.MOD_ID);
  }
}
