package cn.mykodb.exa.core.event

import cn.mykodb.exa.ExaMod
import cn.mykodb.exa.core.potion.ModPotions
import net.minecraft.world.item.Items
import net.minecraft.world.item.alchemy.Potions
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent

//注册新酿造配方的事件
//在客户端和服务器端，主事件总线上都被触发
@EventBusSubscriber(modid = ExaMod.MODID)
object RegisterBrewingRecipes {
    @SubscribeEvent
    fun registerBrewingRecipes(event: RegisterBrewingRecipesEvent) {
        val builder = event.builder
        builder.addMix(
            Potions.AWKWARD,
            Items.ENDER_PEARL,
            ModPotions.TELEPORT_1
        )
        builder.addMix(
            ModPotions.TELEPORT_1,
            Items.GLOWSTONE_DUST,
            ModPotions.TELEPORT_2
        )
    }
}