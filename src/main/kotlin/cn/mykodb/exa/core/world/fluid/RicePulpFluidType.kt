package cn.mykodb.exa.core.world.fluid

import net.minecraft.client.Minecraft
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.level.block.Blocks
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions
import net.neoforged.neoforge.common.SoundActions
import net.neoforged.neoforge.fluids.FluidType

class RicePulpFluidType: FluidType(Properties.create()
    .descriptionId("block.shanwei_seafood.rice_pulp")
    .fallDistanceModifier(0.0f)
    .canExtinguish(true)
    .canConvertToSource(true)
    .supportsBoating(false)
    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
    .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
    .canHydrate(true)
    .addDripstoneDripping(0.17578125f, ParticleTypes.DRIPPING_DRIPSTONE_WATER, Blocks.WATER_CAULDRON, SoundEvents.POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON)
){
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

