package cn.mykodb.exa.core.datagen

import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.effect.ModEffects
import cn.mykodb.exa.core.potion.ModPotions
import net.minecraft.data.PackOutput
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.item.alchemy.Potion
import net.neoforged.neoforge.common.data.LanguageProvider
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

object ModLanguageProvider {


    class EnUs(output: PackOutput) : LanguageProvider(output, MODID, "en_us") {
        override fun addTranslations() {
            addEffect(ModEffects.TELEPORT, "传送")
        }
    }

    class ZhCn(output: PackOutput) : LanguageProvider(output, MODID, "zh_cn") {
        override fun addTranslations() {
            addEffect(ModEffects.TELEPORT, "传送")
            addPotions(ModPotions.TELEPORT_1,"传送药水","喷溅型传送药水","滞留型传送药水","传送之箭")
            addPotions(ModPotions.TELEPORT_2,"传送药水","喷溅型传送药水","滞留型传送药水","传送之箭")
        }
    }


    fun LanguageProvider.addPotions(key: DeferredHolder<Potion,Potion>,baseName:String,splashName:String,lingeringName:String,arrowName:String ) {
        val path = key.id.path
        add("item.minecraft.potion.effect.$path",baseName)
        add("item.minecraft.splash_potion.effect.$path",splashName)
        add("item.minecraft.lingering_potion.effect.$path",lingeringName)
        add("item.minecraft.tipped_arrow.effect.$path",arrowName)
    }
}