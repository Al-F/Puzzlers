package LeetCode.January2021

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
//        val unique: HashSet<Char> = HashSet()
//        var start = 0
//        var max = 0
//        for (i in s.indices)
//            if (!unique.contains(s[i])) {
//                unique.add(s[i])
//            } else {
//                max = max(unique.size, max)
//                while (unique.contains(s[i])){
//                    unique.remove(s[start])
//                    start++
//                }
//                unique.add(s[i])
//            }
//        max = max(unique.size, max)
//        return max

        val unique = Array(128-32) { false }

        var start = 0
        var max = 0
        var counter = 0
        for (i in s.indices)
            if (!unique.contains(s[i])) {
                unique.add(s[i])
                counter++
            } else {
                max = max(counter, max)
                while (unique.contains(s[i])) {
                    unique.remove(s[start])
                    counter--
                    start++
                }
                unique.add(s[i])
                counter++
            }
        max = max(counter, max)
        return max
    }

    fun Array<Boolean>.add(elem: Char) {
        val tmp = elem.toInt() - 32
        this[tmp] = true
    }

    fun Array<Boolean>.contains(elem: Char): Boolean {
        val tmp = elem.toInt() - 32
        return this[tmp]
    }

    fun Array<Boolean>.remove(elem: Char) {
        val tmp = elem.toInt() - 32
        this[tmp] = false
    }
}