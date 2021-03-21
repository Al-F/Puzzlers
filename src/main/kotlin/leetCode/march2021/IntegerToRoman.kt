package leetCode.march2021

import java.lang.StringBuilder

/**
 * Given an integer, convert it to a roman numeral.
 */

fun main() {
    val f = IntegerToRoman()
    println(f.intToRoman(1992))
}

class IntegerToRoman {
    private val map = listOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I",
    )

    fun intToRoman(num: Int): String {
        var res = num
        val result = StringBuilder()
        for (p in map) {
            val symbol = p.second
            var amount = res / p.first
            res %= p.first
            while (amount != 0) {
                result.append(symbol)
                amount--
            }
        }
        return result.toString()
    }
}