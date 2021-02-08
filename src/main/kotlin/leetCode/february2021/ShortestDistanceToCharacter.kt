package leetCode.february2021

import kotlin.math.min

fun main() {
    val f = ShortestDistanceToCharacter()
    f.shortestToChar("aaba", 'b')
}

/**
 * Given a string s and a character c that occurs in s, return an array of integers answer
 * where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 */
class ShortestDistanceToCharacter {
    fun shortestToChar(s: String, c: Char): IntArray {
        val result = IntArray(s.length)
        var index = 0
        while (index < s.length) {
            val next = s.indexOf(c, index, true)
            val end = if (next == -1) s.length-1 else next
            for (i in index .. end) {
                when {
                    index == 0 -> {
                        result[i] = next - i
                    }
                    next == -1 -> {
                        result[i] = i - (index-1)
                    }
                    else -> {
                        result[i] = min(i - (index-1), next - i)
                    }
                }
            }
            index = if (next != -1) {
                next + 1
            } else {
                s.length
            }
        }
        return result
    }
}