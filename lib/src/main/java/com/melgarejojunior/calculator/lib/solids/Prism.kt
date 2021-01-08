package com.melgarejojunior.calculator.lib.solids

import com.melgarejojunior.calculator.lib.Polygon
import com.melgarejojunior.calculator.lib.Solid

data class Prism(
    val base: Polygon,
    val height: Double
) : Solid {
    override fun volume(): Double {
        return base.area() * height
    }
}