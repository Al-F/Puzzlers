package leetCode.january2021

fun main() {
    val f = NextPermutation()
    f.nextPermutation(intArrayOf(3, 2, 1))
}

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order
 * (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        var notFound = true
        for (i in nums.size - 1 downTo 1) {
            if (nums[i] > nums[i - 1]) {
                notFound = false
                var index = Pair(i, nums[i])
                for (j in i + 1 until nums.size) {
                    if (nums[j] < index.second && nums[j] > nums[i - 1]) {
                        index = j to nums[j]
                    }
                }
                nums[i - 1] = nums[index.first].also { nums[index.first] = nums[i - 1] }
                nums.sort(i, nums.size)
                break
            }
        }
        if (notFound) nums.sort()
    }
}