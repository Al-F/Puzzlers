package LeetCode.January2021

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Find the kth positive integer that is missing from this array.
 */
class KthMissing {
    /**
     * Runtime: 160 ms
     * Memory Usage: 35.8 MB
     */
    fun findKthPositive(arr: IntArray, k: Int): Int {
        for (i in arr.indices) {
            if (arr[i] - i - 1 >= k) {
                return k + i
            }
        }
        return k + arr.size
    }
}