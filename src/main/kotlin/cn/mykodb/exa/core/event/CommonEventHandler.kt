package cn.mykodb.exa.core.event

import cn.mykodb.exa.core.datagen.ModItemModelProvider
import cn.mykodb.exa.core.datagen.ModLanguageProvider
import cn.mykodb.exa.core.datagen.ModRecipesProvider
import cn.mykodb.exa.core.register.ModItems
import cn.mykodb.exa.core.register.ModPotions
import cn.mykodb.exa.core.world.item.BatteryCellsItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.alchemy.Potions
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.capabilities.Capabilities
import net.neoforged.neoforge.capabilities.ICapabilityProvider
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent
import net.neoforged.neoforge.data.event.GatherDataEvent
import net.neoforged.neoforge.energy.IEnergyStorage
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent


object CommonEventHandler {
    @SubscribeEvent
    fun onGatherData(event: GatherDataEvent) {
        // 数据生成
        val existingFileHelper = event.existingFileHelper
        event.createProvider(ModLanguageProvider::EnUs)
        event.createProvider(ModLanguageProvider::ZhCn)
        event.createProvider(::ModRecipesProvider)
        event.createProvider{output -> ModItemModelProvider(output,existingFileHelper)}
    }

    @SubscribeEvent
    fun registerCapabilities(event: RegisterCapabilitiesEvent){
        // 注册能力
        event.registerItem(Capabilities.EnergyStorage.ITEM,
            ICapabilityProvider<ItemStack, Void, IEnergyStorage> { stack, context ->
                if (stack.item is BatteryCellsItem) {
                    val battery = stack.item as BatteryCellsItem
                    battery.createEnergyStorage(stack)
                } else {
                    null
                }
            },
            ModItems.BATTERY_CELLS
        )
    }

    // 不要注解 需要NeoForge.EVENT_BUS注册  不要使用 @EventBusSubscriber 那会一团糟
    fun registerBrewingRecipes(event: RegisterBrewingRecipesEvent) {
        //注册新酿造配方的事件
        val builder = event.builder
        builder.addMix(
            Potions.AWKWARD,
            Items.ENDER_PEARL,
            ModPotions.TELEPORT_1
        )
        builder.addMix(
            ModPotions.TELEPORT_1,
            Items.GLOWSTONE_DUST,
            ModPotions.TELEPORT_2
        )
    }
}