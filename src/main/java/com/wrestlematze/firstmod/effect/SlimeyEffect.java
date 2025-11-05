package com.wrestlematze.firstmod.effect;

import com.wrestlematze.firstmod.FirstMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class SlimeyEffect extends StatusEffect {
  public SlimeyEffect() {
    super(StatusEffectCategory.NEUTRAL, 0x36ebab);

    this.addAttributeModifier(
        EntityAttributes.MOVEMENT_SPEED,
        Identifier.of(FirstMod.MOD_ID, "slimey"),
        -0.25f,
        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
  }

  @Override
  public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
    if (entity.horizontalCollision) {
      entity.velocityModified = true;
      Vec3d initialVec = entity.getVelocity();
      Vec3d climbVec = new Vec3d(initialVec.x, 0.2D, initialVec.z);
      entity.setVelocity(climbVec.multiply(0.96D));
      return true;
    }
    return super.applyUpdateEffect(world, entity, amplifier);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }
}
