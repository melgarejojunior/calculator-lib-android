package com.melgarejojunior.calculator.lib.polygons

import com.melgarejojunior.calculator.lib.Polygon

data class Triangle(
    val h: Double,
    val b: Double
) : Polygon {

    override fun area(): Double {
        return (b * h) / 2
    }
    override fun perimeter(): Double {
        return TODO("It depends on the kind of triangle")
    }
}