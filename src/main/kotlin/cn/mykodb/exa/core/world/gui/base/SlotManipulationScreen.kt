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
        var itemStack = slot.item
        var flag = false
        var flag1 = slot === this.clickedSlot && !this.draggingItem.isEmpty && !this.isSplittingStack
        val itemStack1 = this.menu.carried
        var s: String? = null
        if (slot === this.clickedSlot && !this.draggingItem.isEmpty && this.isSplittingStack && !itemStack.isEmpty) {
            itemStack = itemStack.copyWithCount(itemStack.count / 2)
        } else if (this.isQuickCrafting && this.quickCraftSlots.contains(slot) && !itemStack1.isEmpty) {
            if (this.quickCraftSlots.size == 1) {
                return
            }

            if (AbstractContainerMenu.canItemQuickReplace(slot, itemStack1, true) && this.menu.canDragTo(slot)) {
                flag = true
                val k = min(itemStack1.maxStackSize, slot.getMaxStackSize(itemStack1))
                val l = if (slot.item.isEmpty) 0 else slot.item.count
                var i1 = AbstractContainerMenu.getQuickCraftPlaceCount(
                    this.quickCraftSlots,
                    this.quickCraftingType,
                    itemStack1
                ) + l
                if (i1 > k) {
                    i1 = k
                    val var10000 = ChatFormatting.YELLOW.toString()
                    s = var10000 + k
                }

                itemStack = itemStack1.copyWithCount(i1)
            } else {
                this.quickCraftSlots.remove(slot)
                this.recalculateQuickCraftRemaining()
            }
        }
        guiGraphics.pose().pushPose()
        guiGraphics.pose().translate(0.0f, 0.0f, 100.0f)
        if (itemStack.isEmpty && slot.isActive) {
            val pair = slot.noItemIcon
            if (pair != null) {
                val textureAtlasSprite =
                    this.minecraft!!.getTextureAtlas(pair.getFirst()).apply(pair.getSecond()) as TextureAtlasSprite
                guiGraphics.blit(i, j, 0, 16, 16, textureAtlasSprite)
                flag1 = true
            }
        }
        if (!flag1) {
            if (flag) {
                guiGraphics.fill(i, j, i + 16, j + 16, -2130706433)
            }
            this.renderSlotContents(guiGraphics, itemStack, slot, s)
        }
        guiGraphics.pose().popPose()
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

    override fun renderSlotHighlight(
        guiGraphics: GuiGraphics,
        slot: Slot,
        mouseX: Int,
        mouseY: Int,
        partialTick: Float
    ) {
        if (slot.isHighlightable) {
            renderSlotHighlight(guiGraphics, slot.clientX, slot.clientY, 0, getSlotColor(slot.index))
        }
    }

    override fun isHovering(slot: Slot, mouseX: Double, mouseY: Double): Boolean {
        return this.isHovering(slot.clientX, slot.clientY, 16, 16, mouseX, mouseY)
    }

}