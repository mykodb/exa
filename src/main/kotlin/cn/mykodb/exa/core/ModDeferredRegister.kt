package cn.mykodb.exa.core

import cn.mykodb.exa.ExaMod
import cn.mykodb.exa.core.register.*
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.inventory.MenuType
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.alchemy.Potion
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.material.Fluid
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.fluids.FluidType
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries


object ModDeferredRegister {
    // 物品
    val ITEMS: DeferredRegister.Items =
        DeferredRegister.createItems(ExaMod.MODID)

    // 方块
    val BLOCKS: DeferredRegister.Blocks =
        DeferredRegister.createBlocks(ExaMod.MODID)

    // 方块实体类型
    val BLOCK_ENTITY_TYPE: DeferredRegister<BlockEntityType<*>> =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ExaMod.MODID)

    // 创造选项栏
    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExaMod.MODID)

    // 流体类型
    val FLUID_TYPES: DeferredRegister<FluidType> =
        DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, ExaMod.MODID)

    // 流体
    val FLUIDS: DeferredRegister<Fluid> =
        DeferredRegister.create(Registries.FLUID, ExaMod.MODID)

    // 状态效果
    val MOB_EFFECT: DeferredRegister<MobEffect> =
        DeferredRegister.create(Registries.MOB_EFFECT, ExaMod.MODID)

    // 药水
    val POTION: DeferredRegister<Potion> =
        DeferredRegister.create(Registries.POTION, ExaMod.MODID)

    // 附魔
    val ENCHANTMENT: DeferredRegister<Enchantment> =
        DeferredRegister.create(Registries.ENCHANTMENT, ExaMod.MODID)

    // 菜单
    val MENUS: DeferredRegister<MenuType<*>> =
        DeferredRegister.create(Registries.MENU, ExaMod.MODID)

    // 数据组件
    val DATA_COMPONENT_TYPE: DeferredRegister<DataComponentType<*>> =
        DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ExaMod.MODID)

    fun register(modbus: IEventBus) {
        ITEMS.register(modbus)
        ModItems.register()
        BLOCKS.register(modbus)
        ModBlocks.register()
        BLOCK_ENTITY_TYPE.register(modbus)
        ModBlockEntityType.register()
        CREATIVE_MODE_TABS.register(modbus)
        ModCreativeModeTabs.register()
        FLUID_TYPES.register(modbus)
        ModFluidTypes.register()
        FLUIDS.register(modbus)
        ModFluids.register()
        MOB_EFFECT.register(modbus)
        ModEffects.register()
        POTION.register(modbus)
        ModPotions.register()
        ENCHANTMENT.register(modbus)
        ModEnchantments.register()
        MENUS.register(modbus)
        ModMenuTypes.register()
        DATA_COMPONENT_TYPE.register(modbus)
        ModDataComponentType.register()
    }
}