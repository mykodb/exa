package cn.mykodb.exa.core.item

import cn.mykodb.exa.core.ModDeferredRegister.CREATIVE_MODE_TABS
import cn.mykodb.exa.core.block.ModBlocks
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

object ModCreativeModeTabs {
    val EXA_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> =
        CREATIVE_MODE_TABS.register("exa_tab", Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.exa"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon { ModItems.B.get().defaultInstance }
                .displayItems { _: ItemDisplayParameters, output: CreativeModeTab.Output ->
                    output.accept(ModBlocks.A)
                    output.accept(ModItems.B)
                    output.accept(ModItems.RICE_PULP_BUCKET)
                }.build()
        })

    fun register() {}
}