package com.melgarejojunior.calculator.lib.solids

import com.melgarejojunior.calculator.lib.Polygon
import com.melgarejojunior.calculator.lib.Solid

data class Pyramid(
    val base: Polygon,
    val height: Double
) : Solid {
    override fun volume(): Double {
        return (1.0 / 3.0) * base.area() * height
    }
}