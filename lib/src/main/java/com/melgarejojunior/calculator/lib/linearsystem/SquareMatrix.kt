package com.melgarejojunior.calculator.lib.linearsystem

internal class SquareMatrix(val size: Int, private val elements: (Int, Int) -> Double) {

    operator fun get(row: Int, col: Int): Double {
        require(row in 0 until size) { "Row $row out of bounds: 0..${size - 1}" }
        require(col in 0 until size) { "Column $col out of bounds: 0..${size - 1}" }
        return elements(row, col)
    }

    val det: Double by lazy {
        if (size == 1) this[0, 0]
        else (0 until size).map { item -> this[0, item] * coMatrix[0, item] }.sum()
    }

    val adj: SquareMatrix by lazy { coMatrix.transpose() }

    private val coMatrix: SquareMatrix by lazy {
        SquareMatrix(size) { row, col -> coFactor(row, col) }
    }

    private fun coFactor(row: Int, col: Int): Double =
        minor(row, col) * if ((row + col) % 2 == 0) 1f else -1f

    private fun minor(row: Int, col: Int): Double =
        sub(row, col).det

    private fun sub(delRow: Int, delCol: Int) = SquareMatrix(size - 1) { row, col ->
        this[if (row < delRow) row else row + 1, if (col < delCol) col else col + 1]
    }

    fun transpose(): SquareMatrix = SquareMatrix(size) { row, col -> this[col, row] }

    fun inverse(): SquareMatrix = SquareMatrix(size) { row, col -> adj[row, col] / det }
}