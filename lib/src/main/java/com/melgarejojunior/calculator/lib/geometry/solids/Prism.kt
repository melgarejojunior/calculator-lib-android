package com.melgarejojunior.calculator.lib.geometry.solids

import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.Solid

data class Prism(
    val base: Polygon,
    val height: Double
) : Solid {
    override fun volume(): Double {
        return base.area() * height
    }
}