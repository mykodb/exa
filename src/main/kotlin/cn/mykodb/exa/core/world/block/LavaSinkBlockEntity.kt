package cn.mykodb.exa.core.world.block

import cn.mykodb.exa.core.register.ModBlockEntityType.LAVA_SINK_BLOCK_TYPE
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Fluids
import net.neoforged.neoforge.fluids.FluidStack
import net.neoforged.neoforge.fluids.capability.IFluidHandler


class LavaSinkBlockEntity(pos: BlockPos, blockState: BlockState) :
    BlockEntity(LAVA_SINK_BLOCK_TYPE.get(),pos,blockState) {

    fun getFluidHandler(side: Direction?): IFluidHandler {

        return object : IFluidHandler {
            override fun getTanks(): Int = Int.MAX_VALUE
            override fun getFluidInTank(tank: Int): FluidStack =
                FluidStack(Fluids.LAVA, Int.MAX_VALUE)
            override fun getTankCapacity(tank: Int): Int = Int.MAX_VALUE
            override fun isFluidValid(tank: Int, stack: FluidStack): Boolean = true
            override fun fill(resource: FluidStack, action: IFluidHandler.FluidAction): Int = 0
            override fun drain(resource: FluidStack, action: IFluidHandler.FluidAction): FluidStack =
                FluidStack(Fluids.LAVA, resource.amount)
            override fun drain(maxDrain: Int, action: IFluidHandler.FluidAction): FluidStack =
                FluidStack(Fluids.LAVA, maxDrain)
        }
    }
}