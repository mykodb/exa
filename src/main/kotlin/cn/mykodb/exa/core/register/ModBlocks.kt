package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem

object ModBlocks {
    val A = registerSimpleBlockItem("a")

    val RICE_PULP_BLOCK: DeferredBlock<LiquidBlock> = ModDeferredRegister.BLOCKS.register("rice_pulp_block")
    {-> LiquidBlock(
        ModFluids.RICE_PULP_FLUID.still.get(),
        BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).lightLevel { 15 })
    }

    fun registerSimpleBlockItem(
        name: String,
        func: (BlockBehaviour.Properties) -> Block = ::Block,
        blockProps: BlockBehaviour.Properties = BlockBehaviour.Properties.of(),
        properties: Item.Properties = Item.Properties()
    ): DeferredItem<BlockItem> {
        val block = ModDeferredRegister.BLOCKS.registerBlock(name, func, blockProps)
        val blockItem = ModDeferredRegister.ITEMS.registerSimpleBlockItem(block, properties)
        return blockItem
    }

    fun register() {}
}