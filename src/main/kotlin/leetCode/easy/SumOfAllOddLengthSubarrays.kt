package leetCode.easy

fun main() {
    val f = SumOfAllOddLengthSubarrays()
    f.sumOddLengthSubarrays(intArrayOf(1, 4, 2, 5, 3))
}

/**
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * A subarray is a contiguous subsequence of the array.
 * Return the sum of all odd-length subarrays of arr.
 */
class SumOfAllOddLengthSubarrays {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var counter = 0
        var curr = 0
        while (curr < arr.size) {
            for (i in 0 until arr.size - curr) {
                for (j in i..i + curr) {
                    if (j >= arr.size) {
                        break
                    }
                    counter += arr[j]
                }
            }
            curr += 2
        }
        return counter
    }
}