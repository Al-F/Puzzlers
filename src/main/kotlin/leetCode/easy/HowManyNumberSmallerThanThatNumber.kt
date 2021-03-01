package leetCode.easy

import java.util.*

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 */
class HowManyNumberSmallerThanThatNumber {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        for (i in nums.indices){
            var counter = 0
            for (j in nums.indices){
                if(nums[i] > nums[j]) counter++
            }
            result[i] = counter
        }
        return result
    }
}