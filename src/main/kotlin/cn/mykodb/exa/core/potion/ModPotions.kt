package cn.mykodb.exa.core.potion

import cn.mykodb.exa.core.ModDeferredRegister.POTION
import cn.mykodb.exa.core.effect.ModEffects
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.alchemy.Potion
import net.neoforged.neoforge.registries.DeferredHolder

object ModPotions {
    val TELEPORT_I: DeferredHolder<Potion, Potion> = POTION.register("teleport_1")
    {-> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 0)) }
    val TELEPORT_II: DeferredHolder<Potion, Potion> = POTION.register("teleport_2")
    {-> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 1)) }

    fun register(){}
}