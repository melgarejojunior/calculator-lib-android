package com.melgarejojunior.calculator.lib.polygons

import com.melgarejojunior.calculator.lib.Polygon

data class Rectangle(
    val h: Double,
    val b: Double
) : Polygon {

    override fun area(): Double {
        return b * h
    }
    override fun perimeter(): Double {
        return b + b + h + h
    }
}