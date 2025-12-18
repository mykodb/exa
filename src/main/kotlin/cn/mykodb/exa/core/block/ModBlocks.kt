package cn.mykodb.exa.core.block

import cn.mykodb.exa.core.ModDeferredRegister.BLOCKS
import cn.mykodb.exa.core.ModDeferredRegister.ITEMS
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredItem

object ModBlocks {
    val A = registerSimpleBlockItem("a")

    fun registerSimpleBlockItem(
        name: String,
        func: (BlockBehaviour.Properties) -> Block = ::Block,
        blockProps: BlockBehaviour.Properties = BlockBehaviour.Properties.of(),
        properties: Item.Properties = Item.Properties()
    ): DeferredItem<BlockItem> {
        val block = BLOCKS.registerBlock(name, func, blockProps)
        val blockItem = ITEMS.registerSimpleBlockItem(block, properties)
        return blockItem
    }

    fun register() {}
}