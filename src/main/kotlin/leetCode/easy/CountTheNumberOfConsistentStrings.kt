package leetCode.easy

/**
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 */
class CountTheNumberOfConsistentStrings {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        return words.count { it.containsOnly(allowed.toCharArray()) }
    }
}
fun String.containsOnly(allowed: CharArray) : Boolean {
    this.forEach {
        if (it !in allowed) return false
    }
    return true
}