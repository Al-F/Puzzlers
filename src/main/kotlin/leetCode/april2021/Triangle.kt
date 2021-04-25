package leetCode.april2021

import java.util.*

class Triangle {
    fun minimumTotalTooLong(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty() || (triangle.isNotEmpty() && triangle[0].isEmpty())) return 0
        val sums = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        sums.addLast(triangle[0][0] to 0 to 0)
        for (row in 1 until triangle.size) {
            while (sums.firstOrNull()?.second == row - 1) {
                val current = sums.removeFirst()
                sums.addLast(current.first.first + triangle[row][current.first.second] to current.first.second to row)
                sums.addLast(current.first.first + triangle[row][current.first.second + 1] to current.first.second + 1 to row)
            }
        }
        var min = Int.MAX_VALUE
        sums.forEach {
            min = Math.min(it.first.first, min)
        }
        return min
    }

    fun minimumTotal(triangle: List<List<Int>>): Int {
        var nextMut = listOf<Int>()
        for (i in triangle.size - 2 downTo 0) {
            val cur = triangle[i].toMutableList()
            val next = if (i == triangle.size - 2) triangle[i + 1] else nextMut
            for (j in 0 until cur.size) {
                cur[j] += Math.min(next[j], next[j + 1])
            }
            if (i == 0) return cur[i] else nextMut = cur
        }
        return triangle[0][0]
    }
}
