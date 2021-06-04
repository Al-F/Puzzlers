package leetCode.may2021

class RangeSumQuery2DImmutable(matrix: Array<IntArray>) {
    private val matrix = matrix

    init {
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
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        val first = if (row1 == 0) 0 else matrix[row1 - 1][col2]
        val second = if (col1 == 0) 0 else matrix[row2][col1 - 1]
        val third = if (col1 != 0 && row1 != 0) matrix[row1 -1][col1-1] else 0
        return matrix[row2][col2] - first - second + third
    }

}