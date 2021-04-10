package leetCode.april2021

import java.util.*

// 3 4 5    4 5 -1
// 5 2 6    -1 -1 -1
// 2 2 1    -1 -1 -1
fun main() {
    val f = LongestIncreasingPathInMatrix()
    f.longestIncreasingPath(
        arrayOf(
            intArrayOf(1, 4, 7, 9),
            intArrayOf(0, 3, 8, 5),
            intArrayOf(3, 6, 0, 6),
            intArrayOf(1, 4, 5, 6)
        )
    )
}

class LongestIncreasingPathInMatrix {
    private lateinit var matrixOrig: Array<IntArray>
    private lateinit var copy: Array<IntArray>

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        matrixOrig = matrix
        copy = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }

        var max = 0
        for (row in matrix.indices) {
            for (column in matrix[row].indices) {
                max = Math.max(goDeepRec(row, column), max)
            }
        }

        return max
    }

    fun goDeepRec(row: Int, column: Int): Int {
        val cur = matrixOrig[row][column]

        val left = if (column > 0) matrixOrig[row][column - 1] else -1
        val top = if (row > 0) matrixOrig[row - 1][column] else -1
        val right = if (column < matrixOrig[0].size - 1) matrixOrig[row][column + 1] else -1
        val bottom = if (row < matrixOrig.size - 1) matrixOrig[row + 1][column] else -1

        if (left <= cur && top <= cur && right <= cur && bottom <= cur) {
            copy[row][column] = 1
            return 1
        }

        if (left > cur) {
            if (copy[row][column - 1] != -1){
                copy[row][column] = Math.max(copy[row][column - 1] + 1, copy[row][column])
            } else {
                copy[row][column] = Math.max(goDeepRec(row, column - 1) + 1, copy[row][column])
            }
        }
        if (top > cur) {
            if (copy[row - 1][column] != -1){
                copy[row][column] = Math.max(copy[row - 1][column] + 1, copy[row][column])
            } else {
                copy[row][column] = Math.max(goDeepRec(row -1, column) + 1, copy[row][column])
            }
        }
        if (right > cur) {
            if (copy[row][column + 1] != -1){
                copy[row][column] = Math.max(copy[row][column + 1] + 1, copy[row][column])
            } else {
                copy[row][column] = Math.max(goDeepRec(row, column + 1) + 1, copy[row][column])
            }
        }
        if (bottom > cur) {
            if (copy[row + 1][column] != -1){
                copy[row][column] = Math.max(copy[row + 1][column] + 1, copy[row][column])
            } else {
                copy[row][column] = Math.max(goDeepRec(row+1, column) + 1, copy[row][column])
            }
        }

        return copy[row][column]
    }

}