package cn.mykodb.exa.core.world.gui.base

import net.minecraft.world.inventory.Slot
import java.util.WeakHashMap

object ClientSlotManager{
    private val slotClientPositions = WeakHashMap<Slot, Pair<Int, Int>>()

    var Slot.clientX: Int
        get() = slotClientPositions[this]?.first ?: this.x
        set(value) {
            slotClientPositions[this] = Pair(value, this.clientY)
        }

    var Slot.clientY: Int
        get() = slotClientPositions[this]?.second ?: this.y
        set(value) {
            slotClientPositions[this] = Pair(this.clientX, value)
        }
}