package leetCode.january2021

fun main() {
    val f = If1IsAtLeastKAway()
    f.kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2)
}

/**
 * Given an array nums of 0s and 1s and an integer k,
 * return True if all 1's are at least k places away from each other, otherwise return False.
 */
class If1IsAtLeastKAway {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var countZero = 0
        var indexOfOne = -1
        nums.forEachIndexed { index, num ->
            when (num) {
                0 -> countZero++
                1 -> {
                    if (indexOfOne == -1) {
                        indexOfOne = index
                        countZero = 0
                    } else {
                        if (countZero < k) {
                            return false
                        }
                        countZero = 0
                    }
                }
            }
        }
        return true
    }

    fun kLengthApartNoCounting(nums: IntArray, k: Int): Boolean {
        var indexOfOne = -k - 1
        nums.forEachIndexed { index, num ->
            if (num == 1) {
                if (index - indexOfOne <= k) {
                    return false
                }
                indexOfOne = index
            }
        }
        return true
    }
}