package com.sussysyrup.smcompat.betterend.trait;

import com.sussysyrup.smitheesfoundry.api.trait.IActiveTrait;
import com.sussysyrup.smitheesfoundry.api.trait.TraitContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShiftTrait extends TraitContainer implements IActiveTrait {

    public ShiftTrait(String name, Formatting formatting) {
        super(name, formatting);
    }

    @Override
    public void activeInventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

    }

    @Override
    public void activePostHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

    }

    @Override
    public void activePostMine(ItemStack stack, World world, ItemStack stack1, BlockPos pos, LivingEntity miner) {

    }

    @Override
    public void use(ItemStack stackInHand, World world, PlayerEntity playerEntity) {

        if(!world.isClient) {
            float degrees = playerEntity.getHeadYaw();

            Vec3d lookVec = new Vec3d(Math.sin(-Math.toRadians(degrees)), 0, Math.cos(Math.toRadians(degrees)));

            lookVec = lookVec.multiply(3);

            Vec3d endVec = playerEntity.getPos().add(lookVec);

            playerEntity.requestTeleport(endVec.x, endVec.y, endVec.z);

            world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 0.5f, 0.3f + (world.getRandom().nextFloat() * 0.4f));
        }

        if(world.isClient) {
            for (int i = 0; i < 32; ++i) {
                world.addParticle(ParticleTypes.PORTAL, playerEntity.getX(), playerEntity.getY() + world.random.nextDouble() * 2.0, playerEntity.getZ(), world.random.nextGaussian(), 0.0, world.random.nextGaussian());
            }
        }
    }
}
