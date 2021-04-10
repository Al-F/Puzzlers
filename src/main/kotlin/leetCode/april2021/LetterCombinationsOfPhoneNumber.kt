package leetCode.april2021

import java.lang.StringBuilder

fun main() {
    val f = LetterCombinationsOfPhoneNumber()
    f.letterCombinations("23")
}
class LetterCombinationsOfPhoneNumber {
    private val dict = HashMap<Char, CharArray>()

    init {
        dict['2'] = charArrayOf('a', 'b', 'c')
        dict['3'] = charArrayOf('d', 'e', 'f')
        dict['4'] = charArrayOf('g', 'h', 'i')
        dict['5'] = charArrayOf('j', 'k', 'l')
        dict['6'] = charArrayOf('m', 'n', 'o')
        dict['7'] = charArrayOf('p', 'q', 'r', 's')
        dict['8'] = charArrayOf('t', 'u', 'v')
        dict['9'] = charArrayOf('w', 'x', 'y', 'z')
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        var list = ArrayList<String>()
        list.add("")
        digits.toCharArray().forEach { key ->
            val value = dict[key]
            var tmp = ArrayList<String>()
            value!!.forEach { letter ->
                list.forEach { x ->
                    tmp.add(x + letter)
                }
            }
            list = tmp
        }
        return list
    }
}