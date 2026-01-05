package cn.mykodb.exa.core.world.block

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.HitResult

class LavaSinkBlock(properties: Properties) : Block(properties),EntityBlock {
    override fun newBlockEntity(
        pos: BlockPos,
        blockState: BlockState
    ): BlockEntity {
        return LavaSinkBlockEntity(pos,blockState)
    }
}