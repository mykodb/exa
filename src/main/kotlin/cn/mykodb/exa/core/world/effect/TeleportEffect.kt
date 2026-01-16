package cn.mykodb.exa.core.world.effect

import cn.mykodb.exa.core.register.ModEffects
import net.minecraft.core.BlockPos
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.level.Level
import net.minecraft.world.phys.Vec3
import net.minecraft.world.phys.shapes.CollisionContext

class TeleportEffect(category: MobEffectCategory, color: Int, particle: ParticleOptions) :
    MobEffect(category, color, particle) {
    // 获取上方安全的坐标
    fun getAboveSafePos(startPos: Vec3, level: Level): Vec3? {
        var searchY: Double = startPos.y
        if (searchY < level.minY) {
            searchY = level.minY.toDouble()
        }
        while (searchY < level.maxY) {
            val currentPos = BlockPos.containing(startPos.x, searchY, startPos.z)
            val blockState = level.getBlockState(currentPos)
            val collisionShape = blockState.getCollisionShape(level, currentPos, CollisionContext.empty())
            if (collisionShape.isEmpty) {
                return Vec3(startPos.x, searchY, startPos.z)
            }
            searchY++
        }
        return null
    }

    // 传送并广播，中断寻路
    fun LivingEntity.teleportTo(targetPos: Vec3) {
        this.teleportTo(targetPos.x, targetPos.y, targetPos.z)
        this.level().broadcastEntityEvent(this, 46)
        if (this is PathfinderMob) {
            this.getNavigation().stop()
        }
    }

    // 在坐标范围进行随机传送，并有三次重试机会
    fun LivingEntity.randomTeleportTo(targetPos: Vec3, current: Int): Boolean {
        val attempts = 3
        for (i in 1..attempts) {
            val currentRange = current * i
            val randomPos = targetPos.add(
                (random.nextDouble() - 0.5) * 2 * currentRange,
                (random.nextDouble() - 0.5) * 2 * currentRange,
                (random.nextDouble() - 0.5) * 2 * currentRange
            )
            val success = this.randomTeleport(randomPos.x, randomPos.y, randomPos.z, true)
            if (success) {
                return true
            }
        }
        return false
    }

    override fun applyEffectTick(level: ServerLevel, livingEntity: LivingEntity, amplifier: Int): Boolean {
        val random = livingEntity.random
        val lookVec = livingEntity.lookAngle
        val baseRange = (amplifier * 16) + 16
        val baseDistance = random.nextInt((baseRange * 0.8).toInt(), baseRange)

        val startPos = livingEntity.position().add(
            lookVec.x * baseDistance,
            lookVec.y * baseDistance,
            lookVec.z * baseDistance
        )
        var targetPos: Vec3?
        var success = false
        if (level.isLoaded(BlockPos.containing(startPos))) {
            targetPos = getAboveSafePos(startPos, level)
            if (targetPos != null) {
                livingEntity.teleportTo(targetPos)
                if (level.noCollision(livingEntity)) {
                    success = true
                }
            }
        } else {
            livingEntity.teleportTo(startPos)
            targetPos = getAboveSafePos(startPos, level)
            if (targetPos != null) {
                livingEntity.teleportTo(targetPos)
                if (level.noCollision(livingEntity)) {
                    success = true
                }
            }
        }
        if (!success) {
            livingEntity.randomTeleportTo(startPos, baseRange)
        }
        livingEntity.removeEffect(ModEffects.TELEPORT)
        return super.applyEffectTick(level,livingEntity,amplifier)
    }

    override fun shouldApplyEffectTickThisTick(duration: Int, amplifier: Int): Boolean {
        return true
    }
}