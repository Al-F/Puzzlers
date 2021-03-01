package leetCode.february2021

import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap


/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * FreqStack has two functions:
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element,
 * the element closest to the top of the stack is removed and returned.
 */

fun main() {
    val friq = MaximumFrequencyStack.FreqStackSecondTry()
    friq.push(4)
    friq.push(0)
    friq.push(9)
    friq.push(3)
    friq.push(4)
    friq.push(2)
    friq.pop()
    friq.push(6)
    friq.pop()
    friq.push(1)
    friq.pop()
    friq.push(1)
    friq.pop()
    friq.push(4)
    friq.pop()
    friq.pop()
    friq.pop()
    friq.pop()
    friq.pop()
    friq.pop()
}
class MaximumFrequencyStack {
    class FreqStackSecondTry() {
        var freq = mutableMapOf<Int, Int>()
        var group = mutableMapOf<Int, Stack<Int>>()
        var maxfreq = 0

        fun push(x: Int) {
            val f = freq.getOrDefault(x, 0) + 1
            freq[x] = f
            if (f > maxfreq) maxfreq = f
            group.computeIfAbsent(f) { Stack<Int>() }.push(x)
        }

        fun pop(): Int {
            val x = group[maxfreq]?.pop()
            return if (x != null) {
                freq[x] = freq[x]!!.minus(1)
                if (group[maxfreq]!!.size == 0) maxfreq--
                x
            } else 0
        }
    }
}