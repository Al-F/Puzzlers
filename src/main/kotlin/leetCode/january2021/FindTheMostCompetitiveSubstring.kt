package leetCode.january2021

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val arr = FindTheMostCompetitiveSubstring()
    println(arr.mostCompetitive(intArrayOf(71,18,52,29,55,73,24,42,66,8,80,2), 3))
}

/**
 * Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
 * An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
 * We define that a subsequence a is more competitive than a subsequence b (of the same length)
 * if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b.
 * For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number,
 * and 4 is less than 5.
 */
class FindTheMostCompetitiveSubstring {
    fun mostCompetitiveCorrectButExceedsTimeLimit(nums: IntArray, k: Int): IntArray {
        val arr = ArrayDeque<Int>()
        for (i in nums.indices) {
            while (arr.size > 0 && arr.last() > nums[i] && k - arr.size < nums.size - i) {
                arr.removeLast()
            }
            if (arr.size < k) {
                arr.addLast(nums[i])
            }
        }
        return arr.toIntArray()
    }

    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val arr = LinkedList<Int>()
        for (i in nums.indices) {
            while (arr.size > 0 && arr.last() > nums[i] && k - arr.size < nums.size - i) {
                arr.removeLast()
            }
            if (arr.size < k) {
                arr.addLast(nums[i])
            }
        }
        return arr.toIntArray()
    }
}