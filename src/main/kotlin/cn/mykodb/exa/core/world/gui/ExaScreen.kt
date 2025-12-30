package cn.mykodb.exa.core.world.gui

import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory

class ExaScreen(menu: ExaMenu, playerInv: Inventory, title: Component,) :
    AbstractContainerScreen<ExaMenu>(menu,playerInv, title) {

    override fun renderBackground(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {

    }
    override fun renderBg(guiGraphics: GuiGraphics, partialTick: Float, mouseX: Int, mouseY: Int) {

    }

}