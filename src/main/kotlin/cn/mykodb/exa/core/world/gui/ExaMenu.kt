package cn.mykodb.exa.core.world.gui

import cn.mykodb.exa.core.register.ModMenuTypes.EXA_MENU
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack

class ExaMenu(
    containerId: Int,
    playerInv: Inventory,
    extraData: FriendlyByteBuf
) : AbstractContainerMenu(
    EXA_MENU.get(),
    containerId
) {

    val playerInventorySlots = ArrayList<Slot>()

    init {
        for (i in 0..35) {
            playerInventorySlots.add(this.addSlot(Slot(playerInv, i, Int.MAX_VALUE, Int.MAX_VALUE)))
        }
    }

    override fun quickMoveStack(player: Player, index: Int): ItemStack {
        return ItemStack.EMPTY
    }

    override fun stillValid(player: Player): Boolean {
        return true
    }
}