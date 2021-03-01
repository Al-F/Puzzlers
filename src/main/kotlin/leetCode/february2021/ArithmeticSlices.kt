package leetCode.february2021

/**
 * A sequence of numbers is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequences:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given.
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of the array A is called arithmetic if the sequence:
 * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 */
fun main() {
    val f = ArithmeticSlices()
    f.numberOfArithmeticSlices(intArrayOf(1,2,3,8,9,10))
}

class ArithmeticSlices {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        if (A.isEmpty()) return 0
        var start = 0
        var previous = A[0]
        var distance = 0
        var result = 0
        for (i in 1 until A.size) {
            if (previous - A[i] != distance) {
                if (i - start >= 3) {
                    result += ((i - start) - 2) * ((i - start) - 1) / 2
                }
                start = i - 1
                distance = previous - A[i]
            }
            if (i == A.size - 1 && i - start >= 2) {
                result += ((i - start + 1) - 2) * ((i - start + 1) - 1) / 2
            }
            previous = A[i]
        }
        return result
    }
}