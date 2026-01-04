package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

object ModCreativeModeTabs {
    val EXA_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> =
        ModDeferredRegister.CREATIVE_MODE_TABS.register("exa_tab", Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.exa"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon { ModItems.OPEN_MENU_ITEM.get().defaultInstance }
                .displayItems { _: CreativeModeTab.ItemDisplayParameters, output: CreativeModeTab.Output ->
                    output.accept(ModItems.ENDER_MATRIX_BUCKET)
                    output.accept(ModItems.BATTERY_CELLS)
                    output.accept(ModItems.OPEN_MENU_ITEM)
                }.build()
        })

    fun register() {}
}