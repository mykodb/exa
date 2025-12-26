package cn.mykodb.exa.core.fluid

import cn.mykodb.exa.core.ModDeferredRegister.FLUID_TYPES
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredHolder


object ModFluidTypes {

    val RICE_PULP_FLUID_TYPE: DeferredHolder<FluidType, RicePulpFluidType> = FLUID_TYPES.register("rice_pulp"){->RicePulpFluidType() }

    fun register() {}
}