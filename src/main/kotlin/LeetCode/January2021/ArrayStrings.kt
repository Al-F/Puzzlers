package LeetCode.January2021

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */
class ArrayStrings {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
//        val str1 = StringBuilder()
//        val str2 = StringBuilder()
//        word1.forEach { str1.append(it) }
//        word2.forEach { str2.append(it) }
//        return str1.toString() == str2.toString()
        var x1 = 0
        var y1 = 0
        var x2 = 0
        var y2 = 0
        while (x1 < word1.size && x2 < word2.size) {
            if (word1[x1][y1] != word2[x2][y2]) {
                return false
            }
            if (y1 < word1[x1].length-1) {
                y1++
            } else {
                x1++
                y1 = 0
            }
            if (y2 < word2[x2].length-1) {
                y2++
            } else {
                x2++
                y2 = 0
            }
        }
        return x1 == word1.size && x2 == word2.size
    }
}