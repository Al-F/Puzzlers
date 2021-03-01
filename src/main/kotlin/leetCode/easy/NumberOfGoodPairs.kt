package leetCode.easy

/**
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 */
fun main() {
    val f = NumberOfGoodPairs()
    f.numIdenticalPairs(intArrayOf(1, 2, 3, 1, 1, 3))
}

class NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        var counter = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) counter++
            }
        }
        return counter
    }
}