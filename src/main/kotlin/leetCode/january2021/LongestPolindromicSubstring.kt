package leetCode.january2021

fun main() {
    var findLongest = LongestPolindromicSubstring()
    findLongest.longestPalindrome("babad")
}

/**
 * Given a string s, return the longest palindromic substring in s.
 */
class LongestPolindromicSubstring {
    var longest = ""

    fun longestPalindrome(s: String): String {
        if (s.length == 1) {
            return s
        }
        for (i in s.indices) {
            if (i < s.length - 1 && s[i] == s[i + 1]) {
                loopThrough(i - 1, i + 2, s, 2)
            }
            if (i > 0) {
                loopThrough(i - 1, i + 1, s, 1)
            }
        }
        return longest
    }

    private fun loopThrough(a: Int, b: Int, s: String, current: Int){
        var start = a
        var end = b
        var countLength = current
        while (start >= 0 && end < s.length) {
            if (s[start] == s[end]) {
                start--
                end++
                countLength += 2
            } else {
                if (longest.length < countLength) {
                    longest = s.substring(start + 1, end)
                }
                countLength = 0
                break
            }
        }
        if (countLength != 0 && longest.length < countLength) {
            longest = if (end < s.length) {
                s.substring(start + 1, end)
            } else {
                s.substring(start + 1)
            }
        }
    }
}