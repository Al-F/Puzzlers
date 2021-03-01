package leetCode.february2021

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val f = MinimalRemoveToMakeValidStrign()
    print(f.minRemoveToMakeValid("))(("))
}

class MinimalRemoveToMakeValidStrign {
    fun minRemoveToMakeValid(s: String): String {
        val chars = ArrayList<Char>()
        val stack = Stack<Char>()
        s.forEach { char ->
            when (char) {
                '(' -> {
                    stack.push(char)
                    chars.add(char)
                }
                ')' -> {
                    if (stack.size > 0) {
                        stack.pop()
                        chars.add(char)
                    }
                }
                else -> chars.add(char)
            }
        }
        var toRemove = stack.size
        for (i in chars.size - 1 downTo 0) {
            if (toRemove == 0) return chars.joinToString("")
            if (chars[i] == '(') {
                chars.removeAt(i)
                toRemove--
            }
        }
        return chars.joinToString("")
    }
}