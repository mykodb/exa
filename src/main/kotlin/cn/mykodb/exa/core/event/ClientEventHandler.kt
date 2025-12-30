package cn.mykodb.exa.core.event

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.world.gui.ExaScreen
import cn.mykodb.exa.core.register.ModMenuTypes
import cn.mykodb.exa.core.register.ModFluidTypes.RICE_PULP_FLUID_TYPE
import cn.mykodb.exa.core.world.fluid.RicePulpFluidType
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent

@EventBusSubscriber(modid = MODID, value = [Dist.CLIENT])
object ClientEventHandler {
    @SubscribeEvent
    fun onClientEvent( event: FMLClientSetupEvent){

    }

    @SubscribeEvent
    fun registerScreen(event: RegisterMenuScreensEvent) {
        event.register(
            ModMenuTypes.EXA_MENU.get(),
            ::ExaScreen
        )
    }

    @SubscribeEvent
    fun onRegisterBlockColors(event: RegisterColorHandlersEvent.Block) {
        // 设置流体渲染层
        // 不需要半透明 注释掉了
        //ItemBlockRenderTypes.setRenderLayer(ModFluids.RICE_PULP_FLUID.still.get(), RenderType.translucent())
        //ItemBlockRenderTypes.setRenderLayer(ModFluids.RICE_PULP_FLUID.flowing.get(), RenderType.translucent())
    }

    @SubscribeEvent
    fun onRegisterClientExtensions( event: RegisterClientExtensionsEvent) {
        // 大概在1.21后需要就需要注册液体类型扩展
        event.registerFluidType(
            RicePulpFluidType.RicePulpFluidTypeExtensions(),
            RICE_PULP_FLUID_TYPE
        )
    }
}