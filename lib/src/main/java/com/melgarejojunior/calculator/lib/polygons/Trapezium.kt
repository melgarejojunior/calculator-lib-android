package com.melgarejojunior.calculator.lib.polygons

import com.melgarejojunior.calculator.lib.Polygon

data class Trapezium(
    val h: Double,
    val minBase: Double,
    val maxBase: Double
) : Polygon {

    override fun area(): Double {
        return ((maxBase + minBase) * h) / 2
    }

    override fun perimeter(): Double {
        return TODO("I have to calculate it")
    }
}