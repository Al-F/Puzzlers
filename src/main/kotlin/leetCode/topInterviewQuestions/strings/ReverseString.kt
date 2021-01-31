package leetCode.topInterviewQuestions.strings

/**
 * Question: 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 */
class Solution {
    fun reverseString(s: CharArray): Unit {
        /** Simple one liner code
         * It is not very good in speed or memory
         * 432ms / 59.5MB
         */
        s.reverse()

        /** Reverse with 2 pointers
         * 236ms / 48.5 MB
         */

        var firstIndex = 0
        var second = s.size - 1
        while (firstIndex < second){
            val swapElement = s[firstIndex]
            s[firstIndex] = s[second]
            s[second] = swapElement
            firstIndex++
            second--
        }

        /**
         * Small optimization in memory
         * 240ms / 43.1Mb
         */
        var left = 0
        var right = s.size - 1
        while (left < right){
            s[left] = s[right].also {s[right] = s[left]}
            left++
            right--
        }
    }
}