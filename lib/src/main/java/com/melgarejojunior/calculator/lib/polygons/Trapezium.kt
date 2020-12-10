package com.melgarejojunior.calculator.lib.polygons

package com.melgarejojunior.calculator.lib.Polygon

data class Trapezium(
    val h: Float,
    val b: Float,
    val B: Float
) : Polygon {

    override fun area(): Float {
        return ((B + b) * h) / 2
    }

    override fun perimeter(): Float {
        return TODO("I have to calculate it")
    }
}