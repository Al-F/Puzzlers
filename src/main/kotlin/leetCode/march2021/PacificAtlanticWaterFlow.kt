package leetCode.march2021

import java.util.*


fun main() {
    val f = PacificAtlanticWaterFlow()
    f.pacificAtlantic(
        arrayOf(
            intArrayOf(1, 2, 2, 3, 5), intArrayOf(3, 2, 3, 4, 4), intArrayOf(2, 4, 5, 3, 1), intArrayOf(
                6,
                7,
                1,
                4,
                5
            ), intArrayOf(5, 1, 1, 2, 4)
        )
    )
}
class PacificAtlanticWaterFlow {
    private val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))
    private var numRows = 0
    private var numCols = 0
    private lateinit var landHeights: Array<IntArray>

    fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int?>?>? {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return ArrayList()
        }

        numRows = matrix.size
        numCols = matrix[0].size
        landHeights = matrix

        val pacificQueue: Queue<IntArray> = LinkedList()
        val atlanticQueue: Queue<IntArray> = LinkedList()
        for (i in 0 until numRows) {
            pacificQueue.offer(intArrayOf(i, 0))
            atlanticQueue.offer(intArrayOf(i, numCols - 1))
        }
        for (i in 0 until numCols) {
            pacificQueue.offer(intArrayOf(0, i))
            atlanticQueue.offer(intArrayOf(numRows - 1, i))
        }

        val pacificReachable = bfs(pacificQueue)
        val atlanticReachable = bfs(atlanticQueue)

        val commonCells: MutableList<List<Int?>?> = ArrayList()
        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(listOf(i, j))
                }
            }
        }
        return commonCells
    }

    private fun bfs(queue: Queue<IntArray>): Array<BooleanArray> {
        val reachable = Array(numRows) {
            BooleanArray(
                numCols
            )
        }
        while (!queue.isEmpty()) {
            val cell = queue.poll()
            reachable[cell[0]][cell[1]] = true
            for (dir in directions) {
                val newRow = cell[0] + dir[0]
                val newCol = cell[1] + dir[1]
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue
                }
                if (reachable[newRow][newCol]) {
                    continue
                }
                if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
                    continue
                }
                queue.offer(intArrayOf(newRow, newCol))
            }
        }
        return reachable
    }
}