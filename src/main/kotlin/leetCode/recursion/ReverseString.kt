package leetCode.recursion

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 */
class ReverseString {
    private lateinit var array: CharArray
    fun reverseString(s: CharArray): Unit {
        array = s
        reverse(0, s.size - 1)
    }

    private fun reverse(start: Int, end: Int) {
        if (start >= end) return
        array[start] = array[end].also { array[end] = array[start] }
        reverse(start + 1, end - 1)
    }
}