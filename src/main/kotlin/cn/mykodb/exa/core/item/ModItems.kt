package cn.mykodb.exa.core.item

import cn.mykodb.exa.core.ModDeferredRegister.ITEMS
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

object ModItems {
    val B: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "b",
        Item.Properties().food(FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build())
    )

    fun register() {}
}