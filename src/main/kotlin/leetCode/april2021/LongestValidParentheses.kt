package leetCode.april2021

import java.util.*

fun main() {
    val f = LongestValidParentheses()
    f.longestValidParentheses("(()(((()")
}

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        var maxStr = 0
        stack.push(-1)
        s.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(index)
            } else {
                stack.pop()
                if (stack.empty()) {
                    stack.push(index);
                } else {
                    maxStr = Math.max(maxStr, index - stack.peek());
                }
            }
        }
        return maxStr
    }
}