package com.melgarejojunior.calculator.lib.polygons

import com.melgarejojunior.calculator.lib.Polygon
import kotlin.math.PI

class Circle private constructor(
    val ray: Double
) : Polygon {
    val diameter: Double = ray * 2

    override fun area(): Double {
        return PI * (ray * ray)
    }

    override fun perimeter(): Double {
        TODO("Not yet implemented")
    }

    companion object {
        fun fromRay(r: Double) = Circle(r)
        fun fromDiameter(d: Double) = Circle(d / 2)
    }
}