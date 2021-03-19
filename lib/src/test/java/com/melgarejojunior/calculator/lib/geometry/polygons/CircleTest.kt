package com.melgarejojunior.calculator.lib.geometry.polygons

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

internal class CircleTest {

    @Test
    fun `when creating by diameter`() {
        val radius = diameter / 2
        val expectedArea = radius * radius * PI
        val expectedPerimeter = 2 * radius * PI

        val circle = Circle.fromDiameter(diameter)

        assertEquals(expectedArea, circle.area())
        assertEquals(expectedPerimeter, circle.perimeter())
        assertEquals(diameter, circle.diameter)
        assertEquals(radius, circle.ray)
    }

    @Test
    fun `when creating by radius`() {
        val diameter = RADIUS * 2
        val expectedArea = RADIUS * RADIUS * PI
        val expectedPerimeter = 2 * RADIUS * PI

        val circle = Circle.fromRay(RADIUS)

        assertEquals(expectedArea, circle.area())
        assertEquals(expectedPerimeter, circle.perimeter())
        assertEquals(diameter, circle.diameter)
        assertEquals(RADIUS, circle.ray)
    }

    companion object {
        private const val RADIUS = 2.0
        private const val PI = Math.PI
        private const val diameter = 5.0
    }
}