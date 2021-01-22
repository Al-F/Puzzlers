package leetCode.january2021

import kotlin.math.max

/**
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 *
 * Return the maximum integer in the array nums.
 */
class MaximumInGeneratedArray {
    fun getMaximumGenerated(n: Int): Int {
        // First try
//        if (n == 0) {
//            return 0
//        }
//        val nums = IntArray(n + 1)
//        var max = 0
//        var maxOfEvenAndOdd = 0
//        nums[0] = 0
//        nums[1] = 1
//        var even = 0
//        var odd = 0
//        for (i in 1..n / 2) {
//            even = nums[i]
//            nums[2 * i] = even
//
//            if (2 * i + 1 <= n) {
//                odd = nums[i] + nums[i + 1]
//                nums[2 * i + 1] = odd
//            }
//
//            max = max(max, max(even, odd))
//        }
//        return max

        // Small memory optimisation
//        if (n == 0) {
//            return 0
//        }
//        if (n == 1){
//            return 1
//        }
//        val nums = IntArray(n + 1)
//        var max = 0
//        nums[0] = 0
//        nums[1] = 1
//        var odd = 0
//        for (i in 1..n / 2) {
//            nums[2 * i] = nums[i]
//
//            if (2 * i + 1 <= n) {
//                odd = nums[i] + nums[i + 1]
//                nums[2 * i + 1] = odd
//            }
//
//            max = max(max, max(nums[2 * i], odd))
//        }
//        return max

        // Another small optimization
//        if (n == 0) return 0
//        if (n == 1) return 1
//
//        val nums = IntArray(n / 2 + 1) { if (it % 2 == 0) 0 else 1 }
//        var max = 1
//        for (i in 1 until n) {
//            if (i%2 == 0){
//                nums[i] = nums[i / 2 + 1]
//            } else {
//                nums[i] = nums[i / 2]
//            }
//
//            max = max(max, nums[i])
//        }
//        return max
        /**
         * fast and furious
         */
        if (n == 0) return 0
        if (n == 1) return 1

        val nums = IntArray(n + 1) { if (it % 2 == 0) 0 else 1 }
        var max = 1
        for (i in 2..n) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2]
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1]
            }
            max = max(max, nums[i])
        }
        return max
    }
}