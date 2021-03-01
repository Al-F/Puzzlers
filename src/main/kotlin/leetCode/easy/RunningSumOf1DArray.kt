package leetCode.easy

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 */
fun main() {
    val f = RunningSumOf1DArray()
    f.runningSum(intArrayOf(1,2,3,4))
}
class RunningSumOf1DArray {
    fun runningSum(nums: IntArray): IntArray {
        var currentSum = 0
        for (i in nums.indices){
            currentSum += nums[i]
            nums[i] = currentSum
        }
        return nums
    }
}