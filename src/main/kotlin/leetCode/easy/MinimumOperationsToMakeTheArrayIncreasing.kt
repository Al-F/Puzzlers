package leetCode.easy

class MinimumOperationsToMakeTheArrayIncreasing {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        var cur = nums[0]
        for (i in 1 until nums.size) {
            if (cur + 1 > nums[i]) {
                result += cur + 1 - nums[i]
                cur += 1
            } else {
                cur = nums[i]
            }
        }
        return result
    }
}