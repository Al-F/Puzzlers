package leetCode.january2021

fun main() {
    val str=DetermineIfTwoStringsAreClose()
    println(str.closeStrings("abbzzca",
        "babzzcz"))
}

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
class DetermineIfTwoStringsAreClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        val mapW1 = HashMap<Char, Int>()
        word1.forEach {
            mapW1[it] = mapW1.getOrDefault(it, 0)+1
        }
        val mapW2 = HashMap<Char, Int>()
        word2.forEach {
            mapW2[it] = mapW2.getOrDefault(it, 0) + 1
        }
        mapW1.entries.forEach {
            if (mapW2.getOrDefault(it.key, 0) == 0 || !mapW2.containsValue(it.value)){
                return false
            }
        }
        mapW2.entries.forEach {
            if (mapW1.getOrDefault(it.key, 0) == 0|| !mapW1.containsValue(it.value)){
                return false
            }
        }
        return true
    }
}