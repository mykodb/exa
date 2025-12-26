package cn.mykodb.exa.core.event

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.datagen.ModLanguageProvider
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber(modid = MODID)
object GatherDataEventHandler {
    @SubscribeEvent
    fun onGatherData(event: GatherDataEvent) {
        event.createProvider(ModLanguageProvider::EnUs)
        event.createProvider(ModLanguageProvider::ZhCn)
    }
}