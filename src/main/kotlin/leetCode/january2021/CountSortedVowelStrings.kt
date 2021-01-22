package leetCode.january2021

fun main() {
    val counter = CountSortedVowelStrings()
    println(counter.countVowelStrings(2))
}

/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u)
 * and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 */
class CountSortedVowelStrings {
    fun countVowelStrings(n: Int): Int {
        return count(n, 5)
    }

    private fun count(n: Int, lastChar: Int): Int {
        if (n == 1) {
            return lastChar
        }

        var tmp = 0
        for (char in lastChar downTo 1) {
            tmp += count(n - 1, char)
        }
        return tmp
    }
}
