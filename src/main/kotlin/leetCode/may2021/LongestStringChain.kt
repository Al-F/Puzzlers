package leetCode.may2021

import java.util.*


fun main() {
    val f = LongestStringChain()
    f.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca"))
}

class LongestStringChain {

    fun longestStrChain(words: Array<String>): Int {
        val dp = HashMap<String, Int>()
        Arrays.sort(words) { a, b -> a.length - b.length }
        var result = 1
        for (word in words) {
            var presentLength = 1
            for (i in word.indices) {
                val temp = StringBuilder(word)
                temp.deleteCharAt(i)
                val predecessor = temp.toString()
                val previousLength = dp.getOrDefault(predecessor, 0)
                presentLength = Math.max(presentLength, previousLength + 1)
            }
            dp[word] = presentLength
            result = Math.max(result, presentLength)
        }
        return result
    }
}