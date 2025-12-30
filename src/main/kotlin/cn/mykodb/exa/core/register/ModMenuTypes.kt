package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister
import cn.mykodb.exa.core.world.gui.ExaMenu
import net.minecraft.world.inventory.MenuType
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension
import net.neoforged.neoforge.registries.DeferredHolder

object ModMenuTypes {
    val EXA_MENU: DeferredHolder<MenuType<*>, MenuType<ExaMenu>> = ModDeferredRegister.MENUS.register("exa_menu")
    { -> IMenuTypeExtension.create(::ExaMenu) }

    fun register() {}
}