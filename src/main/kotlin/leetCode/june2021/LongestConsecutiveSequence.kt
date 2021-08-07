package leetCode.june2021

fun main() {
    val f = LongestConsecutiveSequence()
    f.longestConsecutive(intArrayOf(0,1,2,3,100,101,102,103,104,105,106,107,108,109,110,111,112))
}
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        nums.sort()
        var max = 1
        var cur = 1
        for (i in 1 until nums.size) {
            if (nums[i] - nums[i-1] == 1){
                cur++
            } else if (nums[i] - nums[i-1] != 0) {
                max = Math.max(max, cur)
                cur = 1
            }
        }
        max = Math.max(max, cur)
        return max
    }
}