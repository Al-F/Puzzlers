package leetCode.july2021

import java.util.*

fun main() {
    val f = KthSmallestElementInSortedMatrix()
    f.kthSmallest(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3)), 2)
}

class KthSmallestElementInSortedMatrix {

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {

        val queue = PriorityQueue<Int>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                queue.add(matrix[i][j])
            }
        }
        var _k = k
        while (_k != 1) {
            queue.poll()
            _k--
        }
        return queue.poll()
    }
}