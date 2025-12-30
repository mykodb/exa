package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.world.fluid.RicePulpFluidType
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredHolder

object ModFluidTypes {

    val RICE_PULP_FLUID_TYPE: DeferredHolder<FluidType, RicePulpFluidType> = ModDeferredRegister.FLUID_TYPES.register("rice_pulp"){-> RicePulpFluidType() }

    fun register() {}
}