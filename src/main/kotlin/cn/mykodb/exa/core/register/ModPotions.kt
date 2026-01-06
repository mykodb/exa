package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.alchemy.Potion
import net.neoforged.neoforge.registries.DeferredHolder

object ModPotions {
    val TELEPORT_1: DeferredHolder<Potion, Potion> = ModDeferredRegister.POTION.register("teleport_potion_1")
    { -> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 0)) }
    val TELEPORT_2: DeferredHolder<Potion, Potion> = ModDeferredRegister.POTION.register("teleport_potion_2")
    { -> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 1)) }

    fun register() {}
}