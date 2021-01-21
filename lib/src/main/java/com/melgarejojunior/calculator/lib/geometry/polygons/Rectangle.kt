package com.melgarejojunior.calculator.lib.geometry.polygons

import com.melgarejojunior.calculator.lib.geometry.Polygon

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