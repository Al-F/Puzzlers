package leetCode.march2021

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    val f = ReconstructOriginalDigitsFromEnglish()
    f.originalDigits("ereht")
}
class ReconstructOriginalDigitsFromEnglish {
    fun originalDigits(s: String): String {
        val numbers = ArrayList<Pair<CharArray, Int>>()
        numbers.add(charArrayOf('z', 'e', 'r', 'o') to 0)
        numbers.add(charArrayOf('t', 'w', 'o') to 2)
        numbers.add(charArrayOf('s', 'i', 'x') to 6)
        numbers.add(charArrayOf('i', 'e', 'g', 'h', 't') to 8)
        numbers.add(charArrayOf('t', 'h', 'r', 'e', 'e') to 3)
        numbers.add(charArrayOf('s', 'e', 'v', 'e', 'n') to 7)
        numbers.add(charArrayOf('f', 'i', 'v', 'e') to 5)
        numbers.add(charArrayOf('f', 'u', 'r', 'o') to 4)
        numbers.add(charArrayOf('n', 'i', 'n', 'e') to 9)
        numbers.add(charArrayOf('o', 'e', 'n') to 1)

        val hashedStr = s.toHashMap()
        val result = ArrayList<Int>()
        numbers.forEachIndexed { index, chars ->
            var contains = true
            while (contains) {
                chars.first.forEach {
                    val value = hashedStr.getOrDefault(it, 0)
                    if (value <= 0 || (chars.second == 3 && it == 'e' && value < 2)) {
                        contains = false
                        return@forEachIndexed
                    }
                }
                chars.first.forEach {
                    val value = hashedStr.getOrDefault(it, 0)
                    if (value > 0) {
                        hashedStr[it] = value - 1
                    }
                }
                result.add(chars.second)
            }
        }

        result.sort()

        return result.joinToString("")
    }

    private fun String.toHashMap(): HashMap<Char, Int> {
        val hashMap = HashMap<Char, Int>()
        this.forEach {
            val value = hashMap.getOrPut(it, { 0 })
            hashMap[it] = value + 1
        }
        return hashMap
    }
}