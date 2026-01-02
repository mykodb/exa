package cn.mykodb.exa.core.event

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.datagen.ModLanguageProvider
import cn.mykodb.exa.core.datagen.ModRecipesProvider
import cn.mykodb.exa.core.register.ModPotions
import net.minecraft.world.item.Items
import net.minecraft.world.item.alchemy.Potions
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent

@EventBusSubscriber(modid = MODID)
object CommonEventHandler {
    @SubscribeEvent
    fun onGatherData(event: GatherDataEvent) {
        // 数据生成
        event.createProvider(ModLanguageProvider::EnUs)
        event.createProvider(ModLanguageProvider::ZhCn)
        event.createProvider(::ModRecipesProvider)
    }

    @SubscribeEvent
    fun registerBrewingRecipes(event: RegisterBrewingRecipesEvent) {
        //注册新酿造配方的事件
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