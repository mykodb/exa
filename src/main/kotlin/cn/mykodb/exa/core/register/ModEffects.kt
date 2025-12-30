package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.world.effect.TeleportEffect
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.neoforged.neoforge.registries.DeferredHolder

object ModEffects {

    val TELEPORT: DeferredHolder<MobEffect, TeleportEffect> = ModDeferredRegister.MOB_EFFECT.register("teleport")
    {-> TeleportEffect(MobEffectCategory.NEUTRAL, 0xFF00BEE4.toInt(), ParticleTypes.PORTAL) }


    fun register() {}

}