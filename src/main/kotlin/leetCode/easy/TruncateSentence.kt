package leetCode.easy

import java.lang.StringBuilder

class TruncateSentence {
    fun truncateSentence(s: String, k: Int): String {
        var whitespaces = 0
        val result = StringBuilder()
        var i = 0
        while (whitespaces < k) {
            if (i<s.length) {
                when (s[i]) {
                    ' ' -> {
                        whitespaces++
                        if (whitespaces < k) {
                            result.append(s[i])
                        }
                    }
                    else -> result.append(s[i])
                }
                i++
            } else return result.toString()
        }
        return result.toString()
    }
}