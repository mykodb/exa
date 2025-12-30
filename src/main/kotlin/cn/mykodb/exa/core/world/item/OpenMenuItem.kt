package cn.mykodb.exa.core.world.item

import cn.mykodb.exa.core.world.gui.ExaMenu
import io.netty.buffer.Unpooled
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.SimpleMenuProvider
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class OpenMenuItem(properties: Properties) : Item(properties) {
    override fun use(level: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        if (!level.isClientSide && player is ServerPlayer) {
            player.openMenu(
                SimpleMenuProvider(
                    { containerId,playerInv, _ ->
                        ExaMenu(
                            containerId,
                            playerInv,
                            FriendlyByteBuf(Unpooled.buffer())
                        )
                    },
                    Component.literal("OpenMenu")
                )
            ) { buf: FriendlyByteBuf -> buf.writeVarInt(usedHand.ordinal) }
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide)
    }
}
