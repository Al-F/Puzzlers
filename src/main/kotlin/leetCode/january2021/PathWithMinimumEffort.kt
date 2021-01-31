package leetCode.january2021

import java.util.*
import java.util.Comparator.comparingInt
import kotlin.math.abs


class PathWithMinimumEffort {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val row: Int = heights.size
        val column: Int = heights[0].size
        val queue: Queue<RowCol> = LinkedList<RowCol>()
        val cost = Array(row) { IntArray(column) }
        Arrays.stream(cost).forEach { a: IntArray? ->
            Arrays.fill(
                a,
                Int.MAX_VALUE
            )
        }
        val neighbour: Array<RowCol?> = arrayOfNulls<RowCol>(4)
        neighbour[0] = RowCol(-1, 0)
        neighbour[1] = RowCol(0, -1)
        neighbour[2] = RowCol(1, 0)
        neighbour[3] = RowCol(0, 1)
        cost[0][0] = 0
        queue.add(RowCol(0, 0))
        while (!queue.isEmpty()) {
            val currentRowCol: RowCol = queue.poll()
            val currentHeight = heights[currentRowCol.row][currentRowCol.col]
            val currentCost = cost[currentRowCol.row][currentRowCol.col]
            for (rowcol in neighbour) {
                val rowC: Int = currentRowCol.row + rowcol?.row!!
                val colC: Int = currentRowCol.col + rowcol.col
                if (rowC in 0 until row && colC >= 0 && colC < column) {
                    val neighbourHeight = heights[rowC][colC]
                    val neighbourCost = currentCost.coerceAtLeast(abs(currentHeight - neighbourHeight))
                    if (neighbourCost < cost[rowC][colC]) {
                        cost[rowC][colC] = neighbourCost
                        queue.add(RowCol(rowC, colC))
                    }
                }
            }
        }
        return cost[row - 1][column - 1]
    }

//    private var DIR = intArrayOf(0, 1, 0, -1, 0)
//    fun minimumEffortDijkstra(heights: Array<IntArray>): Int{
//        val m: Int = heights.size
//        val n: Int = heights[0].size
//        val dist = Array(m) { IntArray(n) }
//        for (i in 0 until m) Arrays.fill(dist[i], Int.MAX_VALUE)
//
//        val minHeap = PriorityQueue(comparingInt { a: IntArray -> a[0] })
//        minHeap.offer(intArrayOf(0, 0, 0)) // distance, row, col
//
//        while (!minHeap.isEmpty()) {
//            val top = minHeap.poll()
//            val d = top[0]
//            val r = top[1]
//            val c = top[2]
//            if (d > dist[r][c]) continue
//            if (r == m - 1 && c == n - 1) return d // Reach to bottom right
//            for (i in 0..3) {
//                val nr: Int = r + DIR[i]
//                val nc: Int = c + DIR[i + 1]
//                if (nr in 0 until m && nc >= 0 && nc < n) {
//                    val newDist = d.coerceAtLeast(abs(heights[nr][nc] - heights[r][c]))
//                    if (dist[nr][nc] > newDist) {
//                        dist[nr][nc] = newDist
//                        minHeap.offer(intArrayOf(dist[nr][nc], nr, nc))
//                    }
//                }
//            }
//        }
//        return 0
//    }
}

class RowCol(var row: Int, var col: Int)