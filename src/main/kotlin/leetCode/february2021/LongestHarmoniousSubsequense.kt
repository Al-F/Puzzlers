package leetCode.february2021

fun main() {
    var f = LongestHarmoniousSubsequense()
    f.findLHS(intArrayOf(1,4,1,3,1,-14,1,-13))
}

/**
 * We define a harmonious array as an array where the difference
 * between its maximum value and its minimum value is exactly 1.
 * Given an integer array nums, return the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements
 * without changing the order of the remaining elements.
 */
class LongestHarmoniousSubsequense {
    fun findLHS(nums: IntArray): Int {
        nums.sort()

        var max = 0
        var smaler = 0
        var bigger = 0
        var isSmall = true
        for (i in 1 until nums.size) {
            if (nums[i] - nums[i-1] > 1) {
                if (isSmall) {
                    smaler = 0
                } else {
                    max = maxOf(max, smaler + bigger)
                    smaler = 0
                    bigger = 0
                    isSmall = true
                }
            } else if (nums[i] - nums[i-1] == 0) {
                if (isSmall) {
                    smaler++
                } else {
                    bigger++
                }
            } else if (nums[i] - nums[i-1] == 1) {
                if (isSmall) {
                    if (smaler==0){
                        smaler=1
                        bigger=1
                        isSmall=false
                    }else{
                        smaler++
                        bigger++
                        isSmall=false
                    }
                } else {
                    max= maxOf(max, smaler+bigger)
                    smaler=bigger
                    bigger=1
                    isSmall=false
                }
            }
        }
        return if (smaler!=0 && bigger!=0) maxOf(smaler+bigger,max) else max
    }
}