package cn.mykodb.exa.core.event

import cn.mykodb.exa.core.datagen.ModLanguageProvider
import cn.mykodb.exa.core.datagen.ModLanguageProvider.EnUs
import cn.mykodb.exa.core.datagen.ModLanguageProvider.ZhCn
import cn.mykodb.exa.core.datagen.ModModelProvider
import cn.mykodb.exa.core.register.ModFluidTypes
import cn.mykodb.exa.core.register.ModFluids
import cn.mykodb.exa.core.register.ModMenuTypes
import cn.mykodb.exa.core.world.fluid.EnderMatrixFluidType
import cn.mykodb.exa.core.world.gui.ExaScreen
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.chunk.ChunkSectionLayer
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent
import net.neoforged.neoforge.data.event.GatherDataEvent

object ClientEventHandler {

    @SubscribeEvent
    fun onGatherData(event: GatherDataEvent.Client) {
        // 数据生成
        event.createProvider(ModLanguageProvider::EnUs)
        event.createProvider(ModLanguageProvider::ZhCn)
        event.createProvider(::ModModelProvider)
    }

    @SubscribeEvent
    fun registerScreen(event: RegisterMenuScreensEvent) {
        // 注册屏幕绑定菜单
        event.register(
            ModMenuTypes.EXA_MENU.get(),
            ::ExaScreen
        )
    }

    @SubscribeEvent
    fun onRegisterBlockColors(event: RegisterColorHandlersEvent.Block) {
        // 设置流体渲染层
        ItemBlockRenderTypes.setRenderLayer(ModFluids.ENDER_MATRIX.still.get(), ChunkSectionLayer.TRANSLUCENT)
        ItemBlockRenderTypes.setRenderLayer(ModFluids.ENDER_MATRIX.flowing.get(), ChunkSectionLayer.TRANSLUCENT)
    }

    @SubscribeEvent
    fun onRegisterClientExtensions(event: RegisterClientExtensionsEvent) {
        // 注册液体类型扩展
        event.registerFluidType(
            EnderMatrixFluidType.RicePulpFluidTypeExtensions(),
            ModFluidTypes.ENDER_MATRIX_TYPE
        )
    }
}