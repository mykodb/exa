package cn.mykodb.exa.core.util

object EnergyUtils {
    fun formatFE(energy: Int):String {
        return when {
            energy == Int.MAX_VALUE -> "max FE"
            energy > 1_000_000 -> String.format("%.2f MFE",energy / 1_000_000.0)
            energy > 1_000 -> String.format("%.2f kFE",energy / 1_000.0)
            else -> String.format("%d FE", energy)
        }
    }
}
