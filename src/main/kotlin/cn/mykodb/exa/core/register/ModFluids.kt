package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import net.minecraft.world.level.material.FlowingFluid
import net.neoforged.neoforge.fluids.BaseFlowingFluid
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

object ModFluids {

    val ENDER_MATRIX = RetentionFluid("ender_matrix", ModFluidTypes.ENDER_MATRIX_TYPE)
        .apply {
            properties.slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ENDER_MATRIX_BLOCK)
                .bucket(ModItems.ENDER_MATRIX_BUCKET)
        }


    class RetentionFluid(
        name: String,
        fluidType: DeferredHolder<FluidType, *>
    ) {
        val still: Supplier<FlowingFluid> = ModDeferredRegister.FLUIDS.register(name)
        { -> BaseFlowingFluid.Source(properties) }

        val flowing: Supplier<FlowingFluid> = ModDeferredRegister.FLUIDS.register("${name}_flow")
        { -> BaseFlowingFluid.Flowing(properties) }

        val properties: BaseFlowingFluid.Properties = BaseFlowingFluid.Properties(fluidType, still, flowing)
    }

    fun register() {}
}