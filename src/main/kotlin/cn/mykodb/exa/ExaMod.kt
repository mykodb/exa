package cn.mykodb.exa

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.event.ClientEventHandler
import cn.mykodb.exa.core.event.CommonEventHandler
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.neoforge.common.NeoForge

@Mod(ExaMod.MODID)
class ExaMod(modEventBus: IEventBus, modContainer: ModContainer) {
    init {
        ModDeferredRegister.register(modEventBus)
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC)
        modEventBus.register(CommonEventHandler)
        NeoForge.EVENT_BUS.addListener(CommonEventHandler::registerBrewingRecipes)
    }

    companion object {
        const val MODID = "exa"
    }

}