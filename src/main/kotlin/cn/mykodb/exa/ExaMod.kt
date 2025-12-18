package cn.mykodb.exa

import cn.mykodb.exa.core.ModDeferredRegister
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig

@Mod(ExaMod.MODID)
class ExaMod(modEventBus: IEventBus, modContainer: ModContainer) {
    init {
        ModDeferredRegister.register(modEventBus)
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC)
    }

    companion object {
        const val MODID = "exa"
    }

}