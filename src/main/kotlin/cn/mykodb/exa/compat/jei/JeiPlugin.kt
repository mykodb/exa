package cn.mykodb.exa.compat.jei


import cn.mykodb.exa.ExaMod.Companion.MODID
import cn.mykodb.exa.core.world.gui.ExaScreen
import mezz.jei.api.IModPlugin
import mezz.jei.api.JeiPlugin
import mezz.jei.api.registration.IGuiHandlerRegistration
import net.minecraft.resources.ResourceLocation


@JeiPlugin
class JeiPlugin : IModPlugin {
    override fun getPluginUid(): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, "jei_plugin")
    }

    override fun registerGuiHandlers(registration: IGuiHandlerRegistration) {
        if (ExaScreen.isHideJei()) {
            registration.addGuiScreenHandler(ExaScreen::class.java) { null }
        }
    }
}