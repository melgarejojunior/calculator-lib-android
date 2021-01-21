package com.melgarejojunior.calculator.lib.linearsystem

abstract class LinearSystem(
    val degree: Int,
    val aList: List<Double>,
    val bList: List<Double>
) {

    init {
        check(aList.size == degree * degree) { "This list has to be size 4" }
        check(bList.size == degree) { "This list has to be size 2" }
    }

    abstract fun solution(): List<Double>
}