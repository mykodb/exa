package cn.mykodb.exa.core.world.gui

import cn.mykodb.exa.core.world.gui.base.ClientSlotManager.clientX
import cn.mykodb.exa.core.world.gui.base.ClientSlotManager.clientY
import cn.mykodb.exa.core.world.gui.base.SlotManipulationScreen
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.Slot

class ExaScreen(menu: ExaMenu, playerInv: Inventory, title: Component) :
    SlotManipulationScreen<ExaMenu>(menu, playerInv, title) {

    private var hideGui: Boolean = false

    companion object {
        fun isHideJei(): Boolean = true
        fun isHideGui(): Boolean = false
    }

    override fun init() {
        super.init()
        if (isHideGui()) {
            this.minecraft?.options?.let {
                hideGui = it.hideGui
                it.hideGui = true
            }
        }
    }

    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        super.render(guiGraphics, mouseX, mouseY, partialTick)
        addPlayerInvSlots(this.menu.playerInventorySlots, 6, 86)
        //addPlayerInvLongSlots(this.menu.playerInventorySlots,-74, 130)
        //addContainerSlots(this.menu.playerInventorySlots,6, 10)
    }

    override fun renderBackground(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {

    }

    fun addContainerSlots(slots: ArrayList<Slot>, x: Int, y: Int) {
        for (i in 0..<slots.count()) {
            slots[i].clientX = x + (i % 9) * 18
            slots[i].clientY = y + ((i / 9) - 1) * 18
        }
    }

    fun addPlayerInvSlots(slots: ArrayList<Slot>, x: Int, y: Int) {
        for (i in 0..<slots.count()) {
            if (i >= 9) {
                slots[i].clientX = x + (i % 9) * 18
                slots[i].clientY = y + ((i / 9) - 1) * 18
            } else {
                slots[i].clientX = x + (i % 18) * 18
                slots[i].clientY = y + 59
            }
        }
    }

    fun addPlayerInvLongSlots(slots: ArrayList<Slot>, x: Int, y: Int) {
        for (i in 0..<slots.count()) {
            slots[i].clientX = x + (i % 18) * 18
            slots[i].clientY = y + (i / 18) * 18
        }
    }

    @Deprecated("不会被调用") // 复写 renderBackground 使 renderBg 不被调用
    override fun renderBg(guiGraphics: GuiGraphics, partialTick: Float, mouseX: Int, mouseY: Int) {
    }
}