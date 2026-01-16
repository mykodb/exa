package cn.mykodb.exa.core.world.gui.base

import cn.mykodb.exa.core.world.gui.base.ClientSlotManager.clientX
import cn.mykodb.exa.core.world.gui.base.ClientSlotManager.clientY
import net.minecraft.ChatFormatting
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack
import kotlin.math.min

abstract class SlotManipulationScreen<Menu : AbstractContainerMenu>(
    menu: Menu,
    playerInventory: Inventory,
    title: Component
) : AbstractContainerScreen<Menu>(
    menu,
    playerInventory,
    title
) {
    override fun renderSlot(guiGraphics: GuiGraphics, slot: Slot) {
        val i = slot.clientX
        val j = slot.clientY

    }

    override fun renderSlotContents(guiGraphics: GuiGraphics, itemstack: ItemStack, slot: Slot, countString: String?) {
        val x = slot.clientX
        val y = slot.clientY
        val seed = x + y * this.imageWidth
        if (slot.isFake) {
            guiGraphics.renderFakeItem(itemstack, x, y, seed)
        } else {
            guiGraphics.renderItem(itemstack, x, y, seed)
        }
        guiGraphics.renderItemDecorations(this.font, itemstack, x, y, countString)
        super.renderSlotContents(guiGraphics, itemstack, slot, countString)
    }





}