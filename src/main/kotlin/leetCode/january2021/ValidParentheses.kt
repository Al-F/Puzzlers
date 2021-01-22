package leetCode.january2021

fun main() {
    val main = ValidParentheses()
    System.out.println(main.isValid("()[]{}"))
}
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val openPar = listOf('(', '{', '[')
        val closePar = listOf(')', '}', ']')

        val stack = ArrayDeque<Char>()
        s.forEach {
            if (stack.isEmpty() && closePar.contains(it)) {
                return false
            }
            if (openPar.contains(it)) {
                stack.addLast(it)
            } else {
                if (it.match(stack.last())) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

    fun Char.match(openChar: Char): Boolean {
        return (this == ')' && openChar == '(')
                || (this == '}' && openChar == '{')
                || (this == ']' && openChar == '[')
    }
}