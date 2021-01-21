package com.melgarejojunior.calculator.lib.solids

import com.melgarejojunior.calculator.lib.Solid
import kotlin.math.PI
import kotlin.math.pow

data class Sphere constructor(
    val ray: Double
) : Solid {
    override fun volume(): Double {
        return (4.0 * PI * ray.pow(3)) / 3.0
    }
}