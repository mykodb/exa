package cn.mykodb.exa.core.datagen

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.register.ModBlocks
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper


class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    BlockStateProvider(output, MODID, exFileHelper) {

    override fun registerStatesAndModels() {

        horizontalBlock(
            ModBlocks.LAVA_SINK.get().block,
            models().getExistingFile(modLoc("block/lava_sink"))
        )

    }
}