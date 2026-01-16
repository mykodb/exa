package cn.mykodb.exa.core.datagen

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.register.ModBlocks
import cn.mykodb.exa.core.register.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, MODID, existingFileHelper) {

    override fun registerModels() {
        basicItem(ModItems.ENDER_MATRIX_BUCKET.get())
        basicItem(ModItems.BATTERY_CELLS.get())
    }
}