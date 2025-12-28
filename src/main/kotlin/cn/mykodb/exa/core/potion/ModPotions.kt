package cn.mykodb.exa.core.potion

import cn.mykodb.exa.core.ModDeferredRegister.POTION
import cn.mykodb.exa.core.effect.ModEffects
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.alchemy.Potion
import net.neoforged.neoforge.registries.DeferredHolder

object ModPotions {
    val TELEPORT_1: DeferredHolder<Potion, Potion> = POTION.register("teleport_potion_1")
    {-> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 0)) }
    val TELEPORT_2: DeferredHolder<Potion, Potion> = POTION.register("teleport_potion_2")
    {-> Potion(MobEffectInstance(ModEffects.TELEPORT, 100, 1)) }
    init {
        TELEPORT_1.id.path
    }

    fun register(){}
}