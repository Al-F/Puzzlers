package leetCode.january2021

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val f = SortTheMatrixDiagonally()
    f.diagonalSort(arrayOf(intArrayOf(3, 3, 1, 1), intArrayOf(2, 2, 1, 2), intArrayOf(1, 1, 1, 2)))
}

/**
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row
 * or leftmost column and going in the bottom-right direction until reaching the matrix's end.
 * For example, the matrix diagonal starting from mat[2][0],
 * where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 *
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 */
class SortTheMatrixDiagonally {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
//        val hashMap = HashMap<Int, ArrayList<Int>>()
//
//        for (i in mat.indices) {
//            for (j in mat[i].indices) {
//                val arr = hashMap.getOrDefault(i - j, arrayListOf())
//                if (arr.isEmpty()) {
//                    hashMap[i - j] = arr
//                }
//                arr.add(mat[i][j])
//            }
//        }
//        hashMap.forEach { (_, value) ->
//            value.sort()
//        }
//        for (i in mat.indices) {
//            for (j in mat[i].indices) {
//                val arr = hashMap[i - j]
//                mat[i][j] = arr?.get(0)!!
//                arr.removeAt(0)
//            }
//        }
//        return mat

        val hashMap = HashMap<Int, PriorityQueue<Int>>()
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                val arr = hashMap.getOrDefault(i - j, PriorityQueue())
                if (arr.isEmpty()) {
                    hashMap[i - j] = arr
                }
                arr.add(mat[i][j])
            }
        }
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                val arr = hashMap[i - j]
                mat[i][j] = arr?.poll()!!
            }
        }
        return mat
    }
}