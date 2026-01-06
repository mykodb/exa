package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.world.fluid.EnderMatrixFluidType
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredHolder

object ModFluidTypes {

    val ENDER_MATRIX_TYPE: DeferredHolder<FluidType, EnderMatrixFluidType> =
        ModDeferredRegister.FLUID_TYPES.register("ender_matrix") { -> EnderMatrixFluidType() }

    fun register() {}
}