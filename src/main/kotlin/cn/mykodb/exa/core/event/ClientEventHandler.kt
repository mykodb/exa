package cn.mykodb.exa.core.event

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.fluid.ModFluidTypes.RICE_PULP_FLUID_TYPE
import cn.mykodb.exa.core.fluid.RicePulpFluidType
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent

@EventBusSubscriber(modid = MODID, value = [Dist.CLIENT])
object ClientEventHandler {
    @SubscribeEvent
    fun onClientEvent( event: FMLClientSetupEvent){
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
        event.registerFluidType(
            RicePulpFluidType.RicePulpFluidTypeExtensions(),
            RICE_PULP_FLUID_TYPE
        )
    }
}