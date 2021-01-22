package leetCode.january2021

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
class MaxNumberOfKSumPair {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        var counter = 0
        for (i in nums) {
            if (i >= k){
                continue
            }
            val value = map.getOrDefault(k - i, 0)
            if (value > 0) {
                map[k - i] = value - 1
                counter++
            } else {
                map[i] = map.getOrDefault(i, 0) + 1
            }
        }
        return counter
    }
}