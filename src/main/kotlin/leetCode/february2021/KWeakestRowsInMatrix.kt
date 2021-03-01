package leetCode.february2021

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val f = KWeakestRowsInMatrix()
    f.kWeakestRowsJava6(arrayOf(
        intArrayOf(1,1,0,0,0),
        intArrayOf(1,1,1,1,0),
        intArrayOf(1,0,0,0,0),
        intArrayOf(1,1,0,0,0),
        intArrayOf(1,1,1,1,1)), 3)
}
class KWeakestRowsInMatrix {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val matSum = mat.map { it.sum() }
        val pq = PriorityQueue<RowAndIndex>(matSum.size)
        matSum.forEachIndexed { index, i ->
            pq.add(RowAndIndex(i, index))
        }
        val result = IntArray(k)
        for (i in 0..k) {
            result[i] = pq.poll().rowIndex
        }
        return result
    }
    fun kWeakestRowsJava6(mat: Array<IntArray>, k: Int): IntArray {
        val matSum = mat.map { it.sum() }
        val pq = ArrayList<RowAndIndex>(matSum.size)
        matSum.forEachIndexed { index, i ->
            pq.add(RowAndIndex(i, index))
        }
        pq.sortBy{ it.rowValue }
        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = pq[i].rowIndex
        }
        return result
    }
}

class RowAndIndex(var rowValue: Int, var rowIndex: Int) : Comparable<RowAndIndex>{
    companion object {
        private val COMPARATOR =
            Comparator.comparingInt<RowAndIndex> { it.rowValue }
                .thenComparingInt { it.rowIndex }
    }
    override fun compareTo(other: RowAndIndex): Int {
        return COMPARATOR.compare(this, other)
    }
}