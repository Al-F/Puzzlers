package leetCode.april2021

fun main() {
    val f = NumberOfSubmatricesThatSumToTarget()
    f.numSubmatrixSumTarget(arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0)), 3)
}

class NumberOfSubmatricesThatSumToTarget {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (i > 0 && j > 0) {
                    matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1]
                } else if (j > 0) {
                    matrix[i][j] += matrix[i][j - 1]
                } else if (i > 0) {
                    matrix[i][j] += matrix[i - 1][j]
                }
            }
        }
        var counter = 0

        for (i in matrix.indices) {
            for (j in matrix.indices) {
                if (i > 0 && j > 0) {
                    for (k in 0 until i) {
                        for (m in 0 until j) {
                            if (matrix[i][j] - matrix[k][j] - matrix[i][m] + matrix[k][m] == target) counter++
                            if (matrix[i][j] - matrix[k][j] == target) counter++
                            if (matrix[i][j] - matrix[i][m] == target) counter++
                        }
                    }
                } else {
                    if (matrix[i][j] == target) counter++
                }
            }
        }
        return counter
    }
}