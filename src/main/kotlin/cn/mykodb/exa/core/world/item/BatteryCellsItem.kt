package cn.mykodb.exa.core.world.item

import cn.mykodb.exa.core.register.ModDataComponentType.ENERGY
import cn.mykodb.exa.core.util.EnergyUtils.formatFE
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.item.component.TooltipDisplay
import net.neoforged.neoforge.energy.ComponentEnergyStorage
import net.neoforged.neoforge.energy.IEnergyStorage
import java.util.function.Consumer


class BatteryCellsItem(properties: Properties) : Item(
    properties.component(ENERGY, 0)
) {

    fun createEnergyStorage(stack: ItemStack): IEnergyStorage {
        return ComponentEnergyStorage(stack, ENERGY.get(), Int.MAX_VALUE, 4096, 4096)
    }

    @Deprecated("Deprecated in Java")
    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipDisplay: TooltipDisplay,
        tooltipAdder: Consumer<Component>,
        tooltipFlag: TooltipFlag
    ) {
        val energy = createEnergyStorage(stack)
        val energyStored = formatFE(energy.energyStored)
        val maxEnergyStored = formatFE(energy.maxEnergyStored)
        tooltipAdder.accept(
            Component.translatable("tooltip.storage_energy").withStyle(ChatFormatting.GREEN)
                .append(Component.literal("$energyStored/$maxEnergyStored").withStyle(ChatFormatting.WHITE))
        )
    }
}