package leetCode.easy

class FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int {
        return nums.map { it.toString() }.count { it.length % 2 == 0 }
    }
}