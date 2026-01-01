package cn.mykodb.exa.core.world.gui

import cn.mykodb.exa.core.world.gui.ClientSlotManager.clientX
import cn.mykodb.exa.core.world.gui.ClientSlotManager.clientY
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.Slot

class ExaScreen(menu: ExaMenu, playerInv: Inventory, title: Component) :
    AbstractContainerScreen<ExaMenu>(menu,playerInv, title) {

    var hideGui: Boolean = false

    override fun init() {
        super.init()
        setHideGui()
    }

    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        super.render(guiGraphics, mouseX, mouseY, partialTick)
        addPlayerInvLongSlots(this.menu.playerInventorySlots,10, 10)
    }

    override fun renderBackground(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {

    }

    override fun renderSlot(guiGraphics: GuiGraphics, slot: Slot) {
        val x = slot.clientX
        val y = slot.clientY
        val itemStack = slot.item
        guiGraphics.renderItem(itemStack,x,y,itemStack.count)
        guiGraphics.renderItemDecorations(font,itemStack,x,y)
    }


    // 复写方法改用客户端pos
    override fun renderSlotHighlight(guiGraphics: GuiGraphics, slot: Slot, mouseX: Int, mouseY: Int, partialTick: Float) {
        if (slot.isHighlightable) {
            renderSlotHighlight(guiGraphics, slot.clientX, slot.clientY, 0, getSlotColor(slot.index))
        }
    }

    // 复写方法改用客户端pos
    override fun isHovering(slot: Slot, mouseX: Double, mouseY: Double): Boolean {
        return this.isHovering(slot.clientX, slot.clientY,16,16,mouseX, mouseY)
    }

    override fun removed() {
        minecraft?.let { it.options.hideGui = hideGui }
        super.removed()
    }

    fun setHideGui(){
        this.minecraft?.options?.let {
            hideGui = it.hideGui
            it.hideGui = true
        }
    }

    fun addPlayerInvLongSlots(slots:ArrayList<Slot>,x: Int, y: Int) {
        for (i in 0..35) {
            val slotX: Int = x + (i % 18) * 18
            val slotY: Int = y + (i / 18) * 18
            slots[i].clientX = slotX
            slots[i].clientY = slotY
        }
    }

    @Deprecated("不会被调用") // 复写 renderBackground 使 renderBg 不被调用
    override fun renderBg(guiGraphics: GuiGraphics, partialTick: Float, mouseX: Int, mouseY: Int){}

}