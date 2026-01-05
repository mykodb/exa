package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister.BLOCK_ENTITY_TYPE
import cn.mykodb.exa.core.world.block.LavaSinkBlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.neoforged.neoforge.registries.DeferredHolder

object ModBlockEntityType {

    val LAVA_SINK_BLOCK_TYPE: DeferredHolder<BlockEntityType<*>, BlockEntityType<LavaSinkBlockEntity>> =
        BLOCK_ENTITY_TYPE.register("lava_sink_block_entity") { ->
            BlockEntityType.Builder.of(
                ::LavaSinkBlockEntity,
                ModBlocks.LAVA_SINK.get().block
            ).build(null)
        }

    fun register() {}
}