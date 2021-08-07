package leetCode.easy

import java.lang.StringBuilder

fun main() {
    val f  = LongestCommonPrefix()
    f.longestCommonPrefix(arrayOf("ab", "a"))
}
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]
        strs.sortBy { it.length }
        var i = 0
        val shortest = strs[0]
        val result = StringBuilder()
        while (i < strs[0].length) {
            var candidate: Char? = shortest[i]
            for (j in 1 until strs.size) {
                if (strs[j][i] != candidate) {
                    candidate = null
                    break
                }
            }
            if (candidate != null) {
                result.append(candidate)
                i++
            } else {
                return result.toString()
            }
        }
        return result.toString()
    }
}