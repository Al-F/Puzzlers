package leetCode.march2021

import kotlin.properties.Delegates

/**
 * Given an integer array nums, return the length of the longest wiggle sequence.
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate
 * between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3)
 * are alternately positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences,
 * the first because its first two differences are positive and the second because its last difference is zero.
 *
 * A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 */
fun main() {
    val f = WiggleSubsequence()
    f.wiggleMaxLength(intArrayOf(1,1,7,4,9,2,5))
}

class WiggleSubsequence {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        if (nums.size == 2) return if (nums[0] == nums[1]) 1 else 2
        if (nums.all { it == nums[0] }) return 1
        var curMax = nums[0]
        var curMin = nums[0]


        var isSmaler: Boolean? = null

        var first = 0
        var second = 1
        while (isSmaler == null) {
            when {
                nums[second] - nums[first] < 0 -> {
                    isSmaler = true
                    curMin = nums[second]
                }
                nums[second] - nums[first] > 0 -> {
                    isSmaler = false
                    curMax = nums[second]
                }
                else -> {
                    first++
                    second++
                }
            }
        }
        var counter = 2

        for (i in second+1 until nums.size) {
            if (isSmaler!!) {
                if (nums[i] - curMin > 0) {
                    isSmaler = false
                    curMax = nums[i]
                    curMin = nums[i]
                    counter++
                } else {
                    curMin = Math.min(curMin, nums[i])
                }
            } else {
                if (nums[i] - curMax < 0) {
                    isSmaler = true
                    curMax = nums[i]
                    curMin = nums[i]
                    counter++
                } else {
                    curMax = Math.max(curMax, nums[i])
                }
            }
        }
        return counter
    }
}