package cn.mykodb.exa.core.item

import cn.mykodb.exa.core.ModDeferredRegister.ITEMS
import cn.mykodb.exa.core.fluid.ModFluids.RICE_PULP_FLUID
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredItem

object ModItems {
    val B: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "b",
        Item.Properties().food(FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build())
    )

    val RICE_PULP_BUCKET: DeferredItem<BucketItem> = ITEMS.register("rice_pulp_bucket")
    { ->
        BucketItem(
            RICE_PULP_FLUID.still.get(),
            Item.Properties()
                .craftRemainder(Items.BUCKET)
                .stacksTo(1)
        )
    }

    fun register() {}
}