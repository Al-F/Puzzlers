package leetCode.may2021

import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.roundToInt


class MinimumMovesToEqualArrayElementsII {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val median = if (nums.size % 2 == 0) {
            ((nums[nums.size / 2].toDouble() + nums[nums.size / 2 - 1].toDouble()) / 2).roundToInt()
        } else nums[nums.size / 2]

        return nums.sumBy { (median - it).absoluteValue }
    }
}