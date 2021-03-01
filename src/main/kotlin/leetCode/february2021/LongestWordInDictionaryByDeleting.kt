package leetCode.february2021

/**
 * Given a string and a string dictionary,
 * find the longest string in the dictionary that can be formed by deleting some characters
 * of the given string. If there are more than one possible results,
 * return the longest word with the smallest lexicographical order.
 *
 * If there is no possible result, return the empty string.
 */
fun main() {
    val f = LongestWordInDictionaryByDeleting()
    f.findLongestWord("bab",
            arrayListOf("ba","ab","a","b"))
}
class LongestWordInDictionaryByDeleting {
    fun findLongestWord(s: String, d: List<String>): String {
        val lengthComparator = compareByDescending<String> { it.length }
        val lexicographicalComparator = lengthComparator.thenBy { it }
        val sortedDictionary = d.sortedWith(lexicographicalComparator)
        for (word in sortedDictionary) {
            val charArr = word.toCharArray()
            var currIndex = 0
            var isValid = true
            charArr.forEach { char ->
                val indexInStr = s.indexOf(char, currIndex, true)
                if (indexInStr == -1) {
                    isValid = false
                    return@forEach
                }
                currIndex = indexInStr
            }
            if (isValid) return word
        }
        return ""
    }
}