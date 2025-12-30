package cn.mykodb.exa.core.world.effect

import cn.mykodb.exa.core.register.ModEffects
import net.minecraft.core.BlockPos
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.PathfinderMob

class TeleportEffect(category: MobEffectCategory, color: Int, particle: ParticleOptions) :
    MobEffect(category, color, particle) {

    override fun applyEffectTick(livingEntity: LivingEntity, amplifier: Int): Boolean {
        val lookVec = livingEntity.lookAngle
        val level = livingEntity.level()
        val random = livingEntity.random
        val baseRange = (amplifier * 16) + 16
        val baseDistance = random.nextInt((baseRange * 0.8).toInt(), baseRange)
        val targetPos = livingEntity.position().add(
            lookVec.x * baseDistance,
            lookVec.y * baseDistance,
            lookVec.z * baseDistance
        )
        var searchY = targetPos.y.toInt()
        var flag = false
        if (level.isLoaded(BlockPos.containing(targetPos))) {
            while (searchY < level.maxBuildHeight) {
                val currentPos = BlockPos(targetPos.x.toInt(), searchY, targetPos.z.toInt())
                val blockState = level.getBlockState(currentPos)
                if (!blockState.isSolid) {
                    flag = true
                    break
                } else {
                    searchY++
                }
            }
        }
        if (!flag) {
            val attempts = 3
            for (i in 1..attempts) {
                val currentRange = baseRange * i
                val randomPos = targetPos.add(
                    (random.nextDouble() - 0.5) * 2 * currentRange,
                    (random.nextDouble() - 0.5) * 2 * currentRange,
                    (random.nextDouble() - 0.5) * 2 * currentRange
                )
                val success = livingEntity.randomTeleport(randomPos.x, randomPos.y, randomPos.z, true)
                if (success) {
                    break
                }
            }
        } else {
            livingEntity.teleportTo(targetPos.x, searchY.toDouble(), targetPos.z)
            level.broadcastEntityEvent(livingEntity, 46)
            if (livingEntity is PathfinderMob) {
                livingEntity.getNavigation().stop()
            }
        }
        livingEntity.removeEffect(ModEffects.TELEPORT)
        return super.applyEffectTick(livingEntity, amplifier)
    }

    override fun shouldApplyEffectTickThisTick(duration: Int, amplifier: Int): Boolean {
        return true
    }
}