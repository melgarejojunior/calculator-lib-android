package com.melgarejojunior.calculator.lib.linearsystem

class ThirdDegreeSystem(
    aList: List<Double>,
    bList: List<Double>
) : LinearSystem(3, aList, bList) {

    private val fullMatrix = arrayOf(
        doubleArrayOf(aList[0], aList[1], aList[2]),
        doubleArrayOf(aList[3], aList[4], aList[5]),
        doubleArrayOf(aList[6], aList[7], aList[8]),
    )

    private val x0Matrix = arrayOf(
        doubleArrayOf(bList[0], aList[1], aList[2]),
        doubleArrayOf(bList[1], aList[4], aList[5]),
        doubleArrayOf(bList[2], aList[7], aList[8]),
    )

    private val x1Matrix = arrayOf(
        doubleArrayOf(aList[0], bList[0], aList[2]),
        doubleArrayOf(aList[3], bList[1], aList[5]),
        doubleArrayOf(aList[6], bList[2], aList[8]),
    )

    private val x2Matrix = arrayOf(
        doubleArrayOf(aList[0], aList[1], bList[0]),
        doubleArrayOf(aList[3], aList[4], bList[1]),
        doubleArrayOf(aList[6], aList[7], bList[2]),
    )
    private val fullSquareMatrix = SquareMatrix(degree) { row, col -> fullMatrix[row][col] }
    private val x0SquareMatrix = SquareMatrix(degree) { row, col -> x0Matrix[row][col] }
    private val x1SquareMatrix = SquareMatrix(degree) { row, col -> x1Matrix[row][col] }
    private val x2SquareMatrix = SquareMatrix(degree) { row, col -> x2Matrix[row][col] }

    override fun solution(): List<Double> {
        val det = fullSquareMatrix.det
        val x0 = x0SquareMatrix.det / det
        val x1 = x1SquareMatrix.det / det
        val x2 = x2SquareMatrix.det / det
        return listOf(x0, x1, x2)
    }
}