package cn.mykodb.exa

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.common.ModConfigSpec
import kotlin.text.matches

object Config {
    val BUILDER: ModConfigSpec.Builder = ModConfigSpec.Builder()

    val booleanValue: ModConfigSpec.BooleanValue = BUILDER
        .comment("布尔值：")
        .define("booleanValue", true)

    val intValue: ModConfigSpec.IntValue = BUILDER
        .comment("Int值：")
        .defineInRange("intValue", 1, 0, Int.MAX_VALUE)

    val stringValue: ModConfigSpec.ConfigValue<String> = BUILDER
        .comment("字符串：")
        .define("stringValue", "")

    val itemList: ModConfigSpec.ConfigValue<MutableList<out String?>> = BUILDER
        .comment("物品ID：")
        .defineListAllowEmpty("items", mutableListOf("minecraft:iron_ingot"), { "" }, Config::validateItemName)

    val SPEC: ModConfigSpec = BUILDER.build()

    private fun validateItemName(obj: Any): Boolean {
        return obj is String && obj.matches(Regex("[a-z0-9_]+:[a-z0-9_]+")) && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(obj))
    }
}