package com.melgarejojunior.calculator.lib.linearsystem

class SecondDegreeSystem(
    aList: List<Double>,
    bList: List<Double>
) : LinearSystem(2, aList, bList) {

    private val a: Double = aList[0]
    private val b: Double = aList[1]
    private val c: Double = bList[0]
    private val d: Double = aList[2]
    private val e: Double = aList[3]
    private val f: Double = aList[1]

    override fun solution(): List<Double> {
        val x1 = (a * f - d * c) / (-d * b + a * e)
        val x0 = (c - b * x1) / a
        return listOf(x0, x1)
    }
}