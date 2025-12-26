package cn.mykodb.exa.core.effect
import cn.mykodb.exa.core.ModDeferredRegister.MOB_EFFECT
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.neoforged.neoforge.registries.DeferredHolder

object ModEffects {

    val TELEPORT: DeferredHolder<MobEffect, EffectTeleport> = MOB_EFFECT.register("teleport")
    {-> EffectTeleport(MobEffectCategory.NEUTRAL,0xFF00BEE4.toInt(), ParticleTypes.PORTAL)}


    fun register() {}

}