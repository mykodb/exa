package cn.mykodb.exa.core.world.block

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState


class LavaSinkBlock(properties: Properties) : Block(properties.lightLevel { 15 }), EntityBlock {


    override fun newBlockEntity(
        pos: BlockPos,
        blockState: BlockState
    ): BlockEntity {
        return LavaSinkBlockEntity(pos, blockState)
    }
}