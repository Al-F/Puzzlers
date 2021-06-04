package leetCode.may2021

import java.lang.StringBuilder

fun main() {
    val f = FindAndReplacePattern()
    f.findAndReplacePattern(arrayOf("eem", "aqq", "dkd", "ccc"), "abb")
}

class FindAndReplacePattern {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val result = ArrayList<String>()
        val converted = pattern.convert()

        words.forEach { word ->
            if (word.convert() == converted) result.add(word)
        }
        return result
    }

    fun String.convert(): String {
        val map = HashMap<Char, Char>()
        var cur = 'a'
        val sb = StringBuilder()
        forEach {
            if (!map.containsKey(it)) {
                map[it] = cur
                sb.append(cur)
                cur++
            } else sb.append(map[it])
        }
        return sb.toString()
    }
}