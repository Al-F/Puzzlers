package leetCode.easy

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var max = Integer.MIN_VALUE
        for (i in nums.indices){
            var midMax= Integer.MIN_VALUE
            var sum = 0
            for (j in i until nums.size){
                sum += nums[j]
                midMax = Math.max(sum, midMax)
            }
            max = Math.max(max, midMax)
        }
        return max
    }
}