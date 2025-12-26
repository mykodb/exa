package cn.mykodb.exa

import cn.mykodb.exa.ExaMod.Companion.MODID
import net.minecraft.client.gui.screens.Screen
import net.neoforged.api.distmarker.Dist
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.gui.ConfigurationScreen
import net.neoforged.neoforge.client.gui.IConfigScreenFactory

@Mod(value = MODID, dist = [Dist.CLIENT])
class ExaClient(container: ModContainer) {
    init {
        // 添加配置GUi
        container.registerExtensionPoint(
            IConfigScreenFactory::class.java,
            IConfigScreenFactory { mod: ModContainer, parent: Screen ->
                ConfigurationScreen(mod, parent)
            }
        )
    }

}