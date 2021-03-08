package leetCode.march2021

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * You are given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
class SetMismatch {
    fun findErrorNums(nums: IntArray): IntArray {
        val result = IntArray(2) { 1 }
        nums.sort()
        for (i in 1 until nums.size) {
            if (nums[i] - nums[i - 1] == 0) {
                result[0] = nums[i]
            }
            if (nums[i] - nums[i - 1] == 2) {
                result[1] = nums[i] - 1
            }
        }
        if (nums[nums.size-1] != nums.size) result[1] = nums.size
        return result
    }
}