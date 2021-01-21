package com.melgarejojunior.calculator.lib.geometry.solids

import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.Solid

data class Pyramid(
    val base: Polygon,
    val height: Double
) : Solid {
    override fun volume(): Double {
        return (1.0 / 3.0) * base.area() * height
    }
}