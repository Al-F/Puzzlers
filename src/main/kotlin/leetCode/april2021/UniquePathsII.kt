package leetCode.april2021

fun main() {
    val f = UniquePathsII()
    f.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)))
}

class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) return 0
        for (i in obstacleGrid.indices) {
            for (j in obstacleGrid[i].indices) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1
                } else if (obstacleGrid[i][j] == 0) {
                    if (i == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1]
                    } else if (j == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j]
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                    }
                } else {
                    obstacleGrid[i][j] = 0
                }
            }
        }
        return obstacleGrid[obstacleGrid.size - 1][obstacleGrid[0].size - 1]
    }
}