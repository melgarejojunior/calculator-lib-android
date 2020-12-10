package com.melgarejojunior.calculator.lib

open data class Solid(
    val base: Polygon,
    val height: Float
) {
    val volume = base * height
}