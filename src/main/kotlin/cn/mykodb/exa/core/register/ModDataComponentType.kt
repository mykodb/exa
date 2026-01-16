package cn.mykodb.exa.core.register

import cn.mykodb.exa.core.ModDeferredRegister.DATA_COMPONENT_TYPE
import com.mojang.serialization.Codec
import net.minecraft.core.component.DataComponentType
import net.minecraft.network.codec.ByteBufCodecs
import net.neoforged.neoforge.registries.DeferredHolder

object ModDataComponentType {

    val ENERGY: DeferredHolder<DataComponentType<*>, DataComponentType<Int>> =
        DATA_COMPONENT_TYPE.register("energy") { ->
            DataComponentType.Builder<Int>()
                .persistent(Codec.INT)
                .networkSynchronized(ByteBufCodecs.INT)
                .build()
        }

    fun register() {}
}