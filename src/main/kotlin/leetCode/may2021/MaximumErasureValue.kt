package leetCode.may2021

fun main() {
    val f = MaximumErasureValue()
    f.maximumUniqueSubarray(intArrayOf(4, 2, 4, 5, 4, 6))
}

class MaximumErasureValue {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val set = HashSet<Int>()
        var max = 0
        var beginning = 0
        var sum = 0
        for (i in nums.indices) {
            if (!set.contains(nums[i])) {
                set.add(nums[i])
                sum += nums[i]
            } else {
                max = Math.max(max, sum)
                while (set.contains(nums[i])) {
                    set.remove(nums[beginning])
                    sum-=nums[beginning]
                    beginning++
                }
                set.add(nums[i])
                sum+=nums[i]
            }
        }
        max = Math.max(max, sum)
        return max
    }
}