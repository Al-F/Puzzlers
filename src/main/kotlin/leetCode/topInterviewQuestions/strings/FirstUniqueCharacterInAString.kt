package leetCode.topInterviewQuestions.strings

fun main() {
    val f = FirstUniqueCharacterInAString()
    println(f.firstUniqChar("a"))
}
/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 */
class FirstUniqueCharacterInAString {
    fun firstUniqChar(s: String): Int {
        val hashMap = HashMap<Char, Int>()

        s.forEachIndexed { index, c ->
            val value = hashMap.getOrDefault(c, -1)
            if (value == -1) {
                hashMap[c] = index
            } else {
                hashMap[c] = s.length + 1
            }
        }
        val min = hashMap.values.min() ?: s.length + 1
        return if (min < s.length) min else -1
    }

    fun firstUniqCharLinear(s: String): Int {
        val cache = IntArray(26)
        for (c in s) cache[c-'a']++
        return s.indexOfFirst{ cache[it - 'a'] == 1}
    }
}