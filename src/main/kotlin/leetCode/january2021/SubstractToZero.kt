package leetCode.january2021

import java.util.*


/**
 * You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums
 * and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 */
class SubstractToZero {
    fun minOperations(nums: IntArray, x: Int): Int {
        val end = nums.size - 1
        if (nums[0] > x && nums[end] > x) {
            return -1
        }
        if (nums[0] == x || nums[end] == x) {
            return 1
        }
        val sum = nums.sum()
        if (sum < x) {
            return -1
        }
        return nums.size - findLongestSubArray(nums, sum - x)
    }

    private fun findLongestSubArray(nums: IntArray, x: Int): Int {
        // HashMap to store (sum, index) tuples
        val map = HashMap<Int, Int>()
        var sum = 0
        var maxLen = 0

        // traverse the given array
        for (i in nums.indices) {
            // accumulate sum
            sum += nums[i]
            // when subarray starts from index '0'
            if (sum == x) maxLen = i + 1
            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum)) {
                map[sum] = i
            }
            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(sum - x)) {
                // update maxLength
                if (maxLen < i - map[sum - x]!!) maxLen = i - map[sum - x]!!
            }
        }
        return maxLen
    }
}