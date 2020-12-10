package com.melgarejojunior.calculator.lib.polygons
package com.melgarejojunior.calculator.lib.Polygon

data class Rectangle(
    val h: Float,
    val b: Float
) : Polygon {

    override fun area(): Float {
        return (b * h) / 2
    }
    override fun perimeter(): Float {
        return TODO("It depends on the kind of triangle")
    }
}