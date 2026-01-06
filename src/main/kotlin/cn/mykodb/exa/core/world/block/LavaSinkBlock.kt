package cn.mykodb.exa.core.world.block

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING
import javax.annotation.Nullable


class LavaSinkBlock(properties: Properties) : Block(properties.lightLevel { 15 }), EntityBlock {

    init {
        registerDefaultState(
            stateDefinition.any()
                .setValue(HORIZONTAL_FACING, Direction.NORTH)
        )
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(HORIZONTAL_FACING)
    }

    @Nullable
    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState? {
        val facing = pContext.horizontalDirection
        return defaultBlockState().setValue(HORIZONTAL_FACING, facing.opposite)
    }

    override fun newBlockEntity(
        pos: BlockPos,
        blockState: BlockState
    ): BlockEntity {
        return LavaSinkBlockEntity(pos, blockState)
    }
}