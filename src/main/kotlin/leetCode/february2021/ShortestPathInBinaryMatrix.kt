package leetCode.february2021

import java.util.*
import kotlin.properties.Delegates

/**
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k
 * if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally
 * (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0)
 *
 * Return the length of the shortest such clear path from top-left to bottom-right.
 * If such a path does not exist, return -1.
 */

fun main() {
    val mat = arrayOf(
        intArrayOf(0, 0, 1, 1, 1, 1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1, 1, 1, 0, 1, 1),
        intArrayOf(1, 1, 0, 0, 1, 1, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 1, 0, 1, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 1, 1, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0, 0, 0, 0, 0, 0)
    )
    val f = ShortestPathInBinaryMatrix()
    f.shortestPathBinaryMatrix(mat)
}

class ShortestPathInBinaryMatrix {
    private var row by Delegates.notNull<Int>()
    private var col by Delegates.notNull<Int>()

    // check whether given cell (row, col)
    // is a valid cell or not.
    private fun isValid(row: Int, col: Int): Boolean {
        // return true if row number and
        // column number is in range
        return row in 0 until this.row &&
                col >= 0 && col < this.col
    }

    // These arrays are used to get row and column
    // numbers of 8 neighbours of a given cell
    var rowNum = intArrayOf(-1, 0, 0, 1, -1, -1, 1, 1)
    var colNum = intArrayOf(0, -1, 1, 0, -1, 1, -1, 1)

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val start = Point(0, 0)
        val dest = Point(grid.size - 1, grid[0].size - 1)
        row = grid.size
        col = grid[0].size

        return breadthFirstSearch(grid, start, dest)
    }

    // function to find the shortest path between
    // a given source cell to a destination cell.
    private fun breadthFirstSearch(grid: Array<IntArray>, start: Point, dest: Point): Int {
        // check source and destination cell
        // of the matrix have value 0
        if (grid[start.x][start.y] != 0 || grid[dest.x][dest.y] != 0) return -1
        val visited = Array(row) { BooleanArray(col) }

        // Mark the source cell as visited
        visited[start.x][start.y] = true

        // Create a queue for BFS
        val q: Queue<QueueNode> = LinkedList()

        // Distance of source cell is 0
        val s = QueueNode(start, 0)
        q.add(s) // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty()) {
            val currentNode = q.peek()
            val point = currentNode.point

            // If we have reached the destination cell,
            // we are done
            if (point.x == dest.x && point.y == dest.y) {
                return currentNode.dist
            }

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove()
            for (i in 0..7) {
                val row = point.x + rowNum[i]
                val col = point.y + colNum[i]

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) && grid[row][col] == 0 &&
                    !visited[row][col]
                ) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true
                    val adjCell = QueueNode(
                        Point(row, col),
                        currentNode.dist + 1
                    )
                    q.add(adjCell)
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1
    }
}

// To store matrix cell coordinates
class Point(var x: Int, var y: Int)

internal class QueueNode(
    var point: Point, // The coordinates of a cell
    var dist: Int // Cell's distance of from the source
)