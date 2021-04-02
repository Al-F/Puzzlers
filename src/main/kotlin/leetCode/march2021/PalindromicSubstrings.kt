package leetCode.march2021

fun main() {
    val f = PalindromicSubstrings()
    f.countSubstrings("aaa")
}

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted
 * as different substrings even they consist of same characters.
 */

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        var result = s.length
        for (center in s.indices) {
            val counter = countThemAll(center - 1, center + 1, s)
            result += counter
            if (center < s.length - 1) {
                if (s[center] == s[center + 1]) {
                    result += 1
                    val doubleDecker = countThemAll(center - 1, center + 2, s)
                    result += doubleDecker
                }
            }
        }
        return result
    }

    private fun countThemAll(start: Int, end: Int, s: String): Int {
        var start1 = start
        var end1 = end
        var result1 = 0
        while (start1 >= 0 && end1 < s.length) {
            if (s[start1] == s[end1]) {
                result1 += 1
                start1 -= 1
                end1 += 1
            } else {
                break
            }
        }
        return result1
    }
}