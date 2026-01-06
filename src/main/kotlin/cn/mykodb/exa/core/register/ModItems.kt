package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister.ITEMS
import cn.mykodb.exa.core.world.item.BatteryCellsItem
import cn.mykodb.exa.core.world.item.OpenMenuItem
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredItem

object ModItems {

    val BATTERY_CELLS: DeferredItem<Item> = ITEMS.register("battery_cells")
    { -> BatteryCellsItem(Item.Properties()) }

    val OPEN_MENU_ITEM: DeferredItem<OpenMenuItem> = ITEMS.register("open_metal_item")
    { -> OpenMenuItem(Item.Properties()) }

    val ENDER_MATRIX_BUCKET: DeferredItem<BucketItem> = ITEMS.register("ender_matrix_bucket")
    { ->
        BucketItem(
            ModFluids.ENDER_MATRIX.still.get(),
            Item.Properties()
                .craftRemainder(Items.BUCKET)
                .stacksTo(1)
        )
    }

    fun register() {}
}