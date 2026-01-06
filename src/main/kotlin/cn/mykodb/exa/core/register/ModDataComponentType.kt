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

    /**
    废弃方案
    ```
    val ENERGY: DeferredHolder<DataComponentType<*>, DataComponentType<EnergyComponent>> =
    DATA_COMPONENT_TYPE.register("energy")
    {-> DataComponentType.Builder<EnergyComponent>()
    .persistent(EnergyComponent.codec)
    .networkSynchronized(EnergyComponent.streamCodec)
    .build()
    }

    data class EnergyComponent(val currentEnergy: Int, val maxCapacity: Int, val maxInput: Int, val maxOutput: Int){
    companion object {
    val codec: Codec<EnergyComponent> = RecordCodecBuilder.create { builder ->
    builder.group(
    Codec.INT.fieldOf("current_energy").forGetter(EnergyComponent::currentEnergy),
    Codec.INT.fieldOf("max_capacity").forGetter(EnergyComponent::maxCapacity),
    Codec.INT.fieldOf("max_input").forGetter(EnergyComponent::maxInput),
    Codec.INT.fieldOf("max_output").forGetter(EnergyComponent::maxOutput)
    ).apply(builder, ::EnergyComponent)
    }
    val streamCodec: StreamCodec<RegistryFriendlyByteBuf, EnergyComponent> =
    StreamCodec.composite(
    ByteBufCodecs.VAR_INT,
    EnergyComponent::currentEnergy,
    ByteBufCodecs.VAR_INT,
    EnergyComponent::maxCapacity,
    ByteBufCodecs.VAR_INT,
    EnergyComponent::maxInput,
    ByteBufCodecs.VAR_INT,
    EnergyComponent::maxOutput,
    ::EnergyComponent
    )
    }
    }
    ```
     */

    fun register() {}
}