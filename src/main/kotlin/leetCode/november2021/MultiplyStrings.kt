package leetCode.november2021

import java.lang.StringBuilder

fun main() {
    val f = MultiplyStrings()
    f.multiply("2378", "4599")
}

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        val indS = num1.length - 1
        val indB = num2.length - 1

        if ((num1.length == 1 && Character.getNumericValue(num1[0]) == 0)
            || (num2.length == 1 && Character.getNumericValue(num2[0]) == 0)) return "0"

        val first = num1.toCharArray().map { Character.getNumericValue(it) }
        val second = num2.toCharArray().map { Character.getNumericValue(it) }

        val result = IntArray(num1.length + num2.length)
        for (i in indS downTo 0) {
            var rem = 0
            for (j in indB downTo 0) {
                var cur = first[i] * second[j]
                cur += rem
                rem = cur / 10

                val mid = result[i + j+1] + cur % 10
                rem += mid / 10
                result[i + j + 1] = mid % 10
            }
            if (rem!=0) {
                result[i] = rem
            }
        }
        val finish = result.dropWhile { it == 0 }
        return finish.joinToString("")
    }
}