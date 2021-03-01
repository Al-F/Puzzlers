package leetCode.february2021

import java.util.*

fun main() {
    val f = ValidateStackSequences()
    f.validateStackSequences(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(4, 5, 3, 2, 1)
    )
}

/**
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result
 * of a sequence of push and pop operations on an initially empty stack.
 */
class ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var index = 0
        var pushedInd = 0
        while (index < popped.size) {
            if (stack.isEmpty() && pushedInd < pushed.size) {
                stack.push(pushed[pushedInd])
                pushedInd++
            } else {
                if (popped[index] != stack.peek()) {
                    if (pushedInd < pushed.size) {
                        stack.push(pushed[pushedInd])
                        pushedInd++
                    } else {
                        return false
                    }
                } else {
                    stack.pop()
                    index++
                }
            }
        }
        return stack.isEmpty()
    }

    fun validateStackSequencesRefactor(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var index = 0
        var pushedInd = 0
        while (index < popped.size) {
            if (stack.isEmpty() && pushedInd < pushed.size) {
                stack.push(pushed[pushedInd])
                pushedInd++
            } else if (popped[index] != stack.peek()) {
                if (pushedInd < pushed.size) {
                    stack.push(pushed[pushedInd])
                    pushedInd++
                } else {
                    return false
                }
            } else {
                stack.pop()
                index++
            }
        }
        return stack.isEmpty()
    }
}