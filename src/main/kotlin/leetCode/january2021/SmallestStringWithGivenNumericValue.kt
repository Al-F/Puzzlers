package leetCode.january2021

fun main() {
    val f = SmallestStringWithGivenNumericValue()
    println(f.getSmallestStringAnotherTry(3, 27))
}

/**
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
 * so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters'
 * numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 *
 * You are given two integers n and k.
 * Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 *
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
 * that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i],
 * then x[i] comes before y[i] in alphabetic order.
 */
class SmallestStringWithGivenNumericValue {
    fun getSmallestString(n: Int, k: Int): String {
        val string = CharArray(n)
        var kResidual = k
        for (i in n - 1 downTo 0) {
            val maxForCurrent = kResidual - i
            if (maxForCurrent > 26) {
                string[i] = 'z'
                kResidual -= 26
            } else {
                val charCur = maxForCurrent - 1 + 'a'.toInt()
                string[i] = charCur.toChar()
                kResidual -= maxForCurrent
            }
        }
        return String(string)
    }

    fun getSmallestStringAnotherTry(n: Int, k: Int): String {
        val string = CharArray(n)
        var kResidual = k
        for (i in n - 1 downTo 0) {
            val maxForCurrent = kResidual - i
            val charCur = if (maxForCurrent > 26) 'z'.toInt() else maxForCurrent - 1 + 'a'.toInt()
            string[i] = charCur.toChar()
            kResidual -= charCur + 1 - 'a'.toInt()
        }
        return String(string)
    }
}