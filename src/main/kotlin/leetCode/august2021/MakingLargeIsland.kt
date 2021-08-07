package leetCode.august2021

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val f = MakingLargeIsland()
    f.largestIsland(arrayOf(intArrayOf(1, 1), intArrayOf(0, 1)))
}

class MakingLargeIsland {
    fun largestIsland(grid: Array<IntArray>): Int {
        var curIsland = 2
        if (grid.all { row -> row.all { it == 1 } }) return grid.size * grid[0].size
        if (grid.all { row -> row.all { it == 0 } }) return 1
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        val islands = HashMap<Int, Int>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    val size = findIslands(visited, i, j, grid, curIsland)
                    islands[curIsland] = size
                    curIsland++
                }
            }
        }
        var max = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    var upward: Int = 0
                    if (i > 0) {
                        //up
                        if (grid[i - 1][j] != 0) {
                            upward = grid[i - 1][j]
                        }
                    }
                    var left = 0
                    if (j > 0) {
                        //left
                        if (grid[i][j - 1] != 0) {
                            left = grid[i][j - 1]
                        }
                    }
                    var down = 0
                    if (i < grid.size - 1) {
                        //down
                        if (grid[i + 1][j] != 0) {
                            down = grid[i + 1][j]
                        }
                    }
                    var right = 0
                    if (j < grid[0].size - 1) {
                        //right
                        if (grid[i][j + 1] != 0) {
                            right = grid[i][j + 1]
                        }
                    }
                    val directions = listOf(upward, left, down, right).filter { it != 0 }
                    val dict = HashMap<Int, Int>()
                    if (directions.size > 1) {
                        for (i in directions.indices) {
                            dict[directions[i]] = islands.getOrDefault(directions[i], 0)
                        }
                        val sum = dict.values.sum() + 1
                        max = Math.max(sum, max)
                    }
                }
            }
        }
        val oneIslandSize = islands.values.max()?.plus(1) ?: 0
        return if (max > oneIslandSize) max else oneIslandSize
    }

    private fun findIslands(
        visited: Array<BooleanArray>,
        i: Int,
        j: Int,
        grid: Array<IntArray>,
        curIsland: Int,
    ): Int {
        visited[i][j] = true
        var size = 1
        val island = Stack<Pair<Int, Int>>()
        island.add(i to j)
        grid[i][j] = curIsland
        while (island.isNotEmpty()) {
            val (row, column) = island.pop()
            if (row > 0) {
                //up
                if (grid[row - 1][column] == 1 && !visited[row - 1][column]) {
                    size++
                    island.add(row - 1 to column)
                    grid[row - 1][column] = curIsland
                }
            }
            if (column > 0) {
                //left
                if (grid[row][column - 1] == 1 && !visited[row][column - 1]) {
                    size++
                    island.add(row to column - 1)
                    grid[row][column - 1] = curIsland
                }
            }
            if (row < grid.size - 1) {
                //down
                if (grid[row + 1][column] == 1 && !visited[row + 1][column]) {
                    size++
                    island.add(row + 1 to column)
                    grid[row + 1][column] = curIsland
                }
            }
            if (column < grid[0].size - 1) {
                //right
                if (grid[row][column + 1] == 1 && !visited[row][column + 1]) {
                    size++
                    island.add(row to column + 1)
                    grid[row][column + 1] = curIsland
                }
            }
        }
        return size
    }
}