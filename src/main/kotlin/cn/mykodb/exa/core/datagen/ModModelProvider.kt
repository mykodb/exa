package cn.mykodb.exa.core.datagen

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.register.ModBlocks
import cn.mykodb.exa.core.register.ModItems
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ItemModelUtils
import net.minecraft.client.data.models.model.ModelLocationUtils
import net.minecraft.client.data.models.model.ModelTemplate
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TextureMapping
import net.minecraft.client.data.models.model.TextureSlot
import net.minecraft.client.data.models.model.TexturedModel
import net.minecraft.client.renderer.item.ItemModel
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.entity.BannerPatterns.BASE


import java.util.Optional

class ModModelProvider(output: PackOutput) : ModelProvider(output, MODID) {
    companion object {
        val BASE: TextureSlot = TextureSlot.create("base", TextureSlot.ALL)
    }

    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        // 方块模型

        blockModels.createTrivialCube(ModBlocks.ENDER_MATRIX_BLOCK.get())


        blockModels.familyWithExistingFullBlock(ModBlocks.LAVA_SINK.get().block)


        // 物品模型
        itemModels.generateFlatItem(ModItems.BATTERY_CELLS.get(), ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.ENDER_MATRIX_BUCKET.get(), ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.OPEN_MENU_ITEM.get(), ModelTemplates.FLAT_ITEM)

        itemModels.itemModelOutput.accept(ModBlocks.LAVA_SINK.get(),ItemModelUtils.plainModel(ResourceLocation.fromNamespaceAndPath(MODID, "block/lava_sink")) )


    }
}