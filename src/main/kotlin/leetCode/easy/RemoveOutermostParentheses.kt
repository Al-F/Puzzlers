package leetCode.easy

import java.lang.StringBuilder

class RemoveOutermostParentheses {
    fun removeOuterParentheses(S: String): String {
        val result = StringBuilder()
        var counter = 0
        S.forEach {
            when (it) {
                '(' -> {
                    if (counter > 0) {
                        result.append(it)
                    }
                    counter++

                }
                ')' -> {
                    if (counter > 1) {
                        result.append(it)
                    }
                    counter--
                }
            }
        }
        return result.toString()
    }
}