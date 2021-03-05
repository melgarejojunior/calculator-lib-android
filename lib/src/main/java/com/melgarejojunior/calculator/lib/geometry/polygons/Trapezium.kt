package com.melgarejojunior.calculator.lib.geometry.polygons

import com.melgarejojunior.calculator.lib.geometry.Polygon
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

data class Trapezium(
    val h: Double,
    val minBase: Double,
    val maxBase: Double
) : Polygon {

    private val partialTriangleLeg = (maxBase - minBase) / 2
    private val hypotenuse = sqrt(
        partialTriangleLeg.pow(2.0) + h.pow(2.0)
    ).absoluteValue

    override fun area(): Double {
        return ((maxBase + minBase) * h) / 2
    }

    override fun perimeter(): Double {
        return maxBase + minBase + (2.0 * hypotenuse)
    }
}