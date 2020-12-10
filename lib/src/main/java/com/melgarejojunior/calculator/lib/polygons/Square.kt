package com.melgarejojunior.calculator.lib.polygons
package com.melgarejojunior.calculator.lib.Polygon

data class Square(
    val l: Float
) : Polygon {

    override fun area(): Float {
        return l * l
    }
    override fun perimeter(): Float {
        return 4 * l
    }
}