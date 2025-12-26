package cn.mykodb.exa.core.fluid

import cn.mykodb.exa.core.ModDeferredRegister.FLUIDS
import cn.mykodb.exa.core.block.ModBlocks
import cn.mykodb.exa.core.item.ModItems
import net.minecraft.world.level.material.FlowingFluid
import net.neoforged.neoforge.fluids.BaseFlowingFluid
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

object ModFluids {

    val RICE_PULP_FLUID = RetentionFluid("a_fluid",ModFluidTypes.RICE_PULP_FLUID_TYPE)
        .apply { properties.slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.RICE_PULP_BLOCK).bucket(ModItems.RICE_PULP_BUCKET) }


    class RetentionFluid(
        name: String,
        fluidType: DeferredHolder<FluidType,*>
    ){
        val still: Supplier<FlowingFluid> = FLUIDS.register(name)
        {->BaseFlowingFluid.Source(properties)}

        val flowing: Supplier<FlowingFluid> = FLUIDS.register("${name}_flow")
        {->BaseFlowingFluid.Flowing(properties)}

        val properties:Properties = Properties(fluidType,still,flowing)
    }

    fun register() {}
}