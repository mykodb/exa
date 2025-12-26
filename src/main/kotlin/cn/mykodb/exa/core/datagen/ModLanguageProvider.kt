package cn.mykodb.exa.core.datagen

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.effect.ModEffects
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

object ModLanguageProvider {

    class EnUs(output: PackOutput) : LanguageProvider(output, MODID, "en_us") {
        override fun addTranslations() {
            addEffect(ModEffects.TELEPORT, "传送")
        }
    }

    class ZhCn(output: PackOutput) : LanguageProvider(output, MODID, "zh_cn") {
        override fun addTranslations() {
            addEffect(ModEffects.TELEPORT, "传送")
        }
    }
}