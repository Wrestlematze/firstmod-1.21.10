package com.wrestlematze.firstmod.effect;

import com.wrestlematze.firstmod.FirstMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class ColaEffect extends StatusEffect {
  public ColaEffect() {
    super(StatusEffectCategory.BENEFICIAL, 0x5c110b);

    this.addAttributeModifier(
            EntityAttributes.MOVEMENT_SPEED,
            Identifier.of(FirstMod.MOD_ID, "cola"),
            .2f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
        .addAttributeModifier(
            EntityAttributes.BLOCK_BREAK_SPEED,
            Identifier.of(FirstMod.MOD_ID, "cola"),
            .1f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
  }

  @Override
  public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
    if (entity instanceof PlayerEntity playerEntity) {

      return true;
    }

    return super.applyUpdateEffect(world, entity, amplifier);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }
}
