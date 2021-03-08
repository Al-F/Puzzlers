package leetCode.march2021

fun main() {
    val f = ShortestEncodingOfWords()
    f.minimumLengthEncoding(arrayOf("atime", "aatime", "btime"))
}
/**
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 * words.length == indices.length
 * The reference string s ends with the '#' character.
 * For each index indices[i], the substring of s starting from indices[i] and up to (but not including)
 * the next '#' character is equal to words[i].
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 */
class ShortestEncodingOfWords {
    fun minimumLengthEncoding(words: Array<String>): Int {
        if (words.isEmpty()) return 0
        words.sortByDescending { it.length }
        var resLength = 0
        val hash = HashSet<String>()
        for (i in words.indices) {
            if (!hash.contains(words[i])) {
                for (j in words[i].indices) {
                    hash.add(words[i].substring(j))
                }
                resLength += words[i].length + 1
            }
        }
        return resLength
    }
}