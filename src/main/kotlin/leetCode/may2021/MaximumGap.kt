package leetCode.may2021

class MaximumGap {
    fun maximumGap(nums: IntArray): Int {
        if(nums.size==1) return 0
        nums.sort()
        var max = 0
        var prev = nums[0]
        for (i in 1 until nums.size){
            max = Math.max(max, nums[i] - prev)
            prev = nums[i]
        }
        return max
    }
}