package leetCode.february2021

import java.util.*
import kotlin.math.max

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 */
fun main() {
    val f = ScoreOfParentheses()
    f.scoreOfParentheses("()")
}
class ScoreOfParentheses {
    fun scoreOfParentheses(S: String): Int {
        val stack = Stack<Int>()
        for (char in S) {
            if (stack.isEmpty() || char == '(') {
                stack.push(0)
            } else {
                val v = stack.pop()
                val w = if (stack.size != 0) {
                    stack.pop()
                } else {
                    0
                }
                stack.push(w + max(2 * v, 1))
            }
        }
        return stack.pop()
    }
}