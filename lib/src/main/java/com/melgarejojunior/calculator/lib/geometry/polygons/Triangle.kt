package com.melgarejojunior.calculator.lib.geometry.polygons

import com.melgarejojunior.calculator.lib.geometry.Polygon
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

open class Triangle(
    val height: Double,
    val base: Double
) : Polygon {

    private val l: Double get() = abs(sqrt((base.pow(2.0) / 4) + height.pow(2.0)))

    override fun area(): Double {
        return (base * height) / 2
    }

    override fun perimeter(): Double {
        return l + l + base
    }
}