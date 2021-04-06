package leetCode.april2021

fun main() {
    val f = GlobalAndLocalInversions()
    f.isIdealPermutation(intArrayOf(2, 1, 3, 4, 3, 0))
}
class GlobalAndLocalInversions {
    fun isIdealPermutationMine(A: IntArray): Boolean {
        var local = 0
        var global = 0
        for (i in A.indices) {
            if (i < A.size - 1 && A[i]> A[i + 1]) local++
            for (j in i + 1 until A.size) {
                if (A[i]> A[j]) global++
            }
        }
        return global == local
    }

    fun isIdealPermutation(A: IntArray): Boolean {
        var max = -1
        for (i in 0 until A.size - 2) {
            max = Math.max(max, A[i])
            if (max > A[i + 2]) return false
        }
        return true
    }
}