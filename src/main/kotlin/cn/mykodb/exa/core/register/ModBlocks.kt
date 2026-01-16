package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.world.block.LavaSinkBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem

object ModBlocks {

    val CHEESE_BLOCK =  registerBlockItem("cheese_block")
    val LAVA_SINK = registerBlockItem("lava_sink", ::LavaSinkBlock)

    val ENDER_MATRIX_BLOCK: DeferredBlock<LiquidBlock> = ModDeferredRegister.BLOCKS.register("rice_pulp_block")
    { ->
        LiquidBlock(
            ModFluids.ENDER_MATRIX.still.get(),
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).lightLevel { 15 })
    }

    fun registerBlockItem(
        name: String,
        block: (BlockBehaviour.Properties) -> Block = ::Block,
        blockProps: BlockBehaviour.Properties = BlockBehaviour.Properties.of(),
        properties: Item.Properties = Item.Properties()
    ): DeferredItem<BlockItem> {
        val block = ModDeferredRegister.BLOCKS.registerBlock(name,block,blockProps)
        return ModDeferredRegister.ITEMS.registerSimpleBlockItem(block,properties)
    }

    fun register() {}
}