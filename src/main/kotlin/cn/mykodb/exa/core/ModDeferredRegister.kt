package cn.mykodb.exa.core

import cn.mykodb.exa.ExaMod
import cn.mykodb.exa.core.block.ModBlockEntityType
import cn.mykodb.exa.core.block.ModBlocks
import cn.mykodb.exa.core.item.ModCreativeModeTabs
import cn.mykodb.exa.core.item.ModItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.level.block.entity.BlockEntityType
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object ModDeferredRegister {

    val ITEMS: DeferredRegister.Items =
        DeferredRegister.createItems(ExaMod.MODID)
    val BLOCKS: DeferredRegister.Blocks =
        DeferredRegister.createBlocks(ExaMod.MODID)
    val BLOCK_ENTITY_TYPE: DeferredRegister<BlockEntityType<*>> =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ExaMod.MODID)
    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExaMod.MODID)

    fun register(modbus: IEventBus) {
        ITEMS.register(modbus)
        ModItems.register()
        BLOCKS.register(modbus)
        ModBlocks.register()
        BLOCK_ENTITY_TYPE.register(modbus)
        ModBlockEntityType.register()
        CREATIVE_MODE_TABS.register(modbus)
        ModCreativeModeTabs.register()
    }
}