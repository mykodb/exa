package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.register.ModFluids
import cn.mykodb.exa.core.world.item.OpenMenuItem
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredItem

object ModItems {

    val OPEN_MENU_ITEM: DeferredItem<OpenMenuItem> = ModDeferredRegister.ITEMS.register("open_metal_item")
    { -> OpenMenuItem(Item.Properties()) }

    val B: DeferredItem<Item> = ModDeferredRegister.ITEMS.registerSimpleItem(
        "b",
        Item.Properties().food(FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build())
    )

    val RICE_PULP_BUCKET: DeferredItem<BucketItem> = ModDeferredRegister.ITEMS.register("rice_pulp_bucket")
    { ->
        BucketItem(
            ModFluids.RICE_PULP_FLUID.still.get(),
            Item.Properties()
                .craftRemainder(Items.BUCKET)
                .stacksTo(1)
        )
    }


    fun register() {}
}