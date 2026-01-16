package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister.ITEMS
import cn.mykodb.exa.core.world.item.BatteryCellsItem
import cn.mykodb.exa.core.world.item.OpenMenuItem
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredItem

object ModItems {

    val BATTERY_CELLS: DeferredItem<Item> = ITEMS.registerItem("battery_cells",::BatteryCellsItem)


    val OPEN_MENU_ITEM: DeferredItem<OpenMenuItem> = ITEMS.registerItem("open_metal_item",::OpenMenuItem)


    val ENDER_MATRIX_BUCKET: DeferredItem<BucketItem> = ITEMS.registerItem("ender_matrix_bucket")
    { properties ->
        BucketItem(
            ModFluids.ENDER_MATRIX.still.get(),
            properties
                .craftRemainder(Items.BUCKET)
                .stacksTo(1)
        )
    }

    fun register() {}
}