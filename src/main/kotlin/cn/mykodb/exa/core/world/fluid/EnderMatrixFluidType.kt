package cn.mykodb.exa.core.world.fluid

import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvents
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent
import net.neoforged.neoforge.common.SoundActions
import net.neoforged.neoforge.fluids.FluidType

class EnderMatrixFluidType : FluidType(
    Properties.create()
        .descriptionId("block.fluid_type.ender_manager")
        .fallDistanceModifier(0.0f)
        .canExtinguish(true)
        .canConvertToSource(true)
        .supportsBoating(false)
        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
        .canHydrate(true)
) {

    /**
     * [initializeClient] 方法注册客户端扩展在1.21后弃用
     *
     * 新方法 使用 [RegisterClientExtensionsEvent] 进行注册
     * ```
     * // 在1.21后弃用
     * override fun initializeClient(consumer: Consumer<IClientFluidTypeExtensions>) {
     *     consumer.accept(RicePulpFluidTypeExtensions())
     * }
     * ```
     * @see cn.mykodb.exa.core.event.ClientEventHandler.onRegisterClientExtensions
     */
    @OnlyIn(Dist.CLIENT)
    class RicePulpFluidTypeExtensions : IClientFluidTypeExtensions {
        private companion object {
            private val UNDERWATER_LOCATION = ResourceLocation.withDefaultNamespace("textures/misc/underwater.png")
            private val WATER_STILL = ResourceLocation.withDefaultNamespace("block/water_still")
            private val WATER_FLOW = ResourceLocation.withDefaultNamespace("block/water_flow")
            private val WATER_OVERLAY = ResourceLocation.withDefaultNamespace("block/water_overlay")
        }

        override fun getStillTexture(): ResourceLocation = WATER_STILL
        override fun getFlowingTexture(): ResourceLocation = WATER_FLOW
        override fun getOverlayTexture(): ResourceLocation = WATER_OVERLAY
        override fun getRenderOverlayTexture(mc: Minecraft): ResourceLocation = UNDERWATER_LOCATION
        override fun getTintColor(): Int = 0xFF00BEE4.toInt()
    }

}

