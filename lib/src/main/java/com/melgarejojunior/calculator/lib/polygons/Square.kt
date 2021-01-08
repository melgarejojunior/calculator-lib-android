package com.melgarejojunior.calculator.lib.polygons

import com.melgarejojunior.calculator.lib.Polygon

data class Square(
    val l: Double
) : Polygon {

    override fun area(): Double {
        return l * l
    }
    override fun perimeter(): Double {
        return 4 * l
    }
}