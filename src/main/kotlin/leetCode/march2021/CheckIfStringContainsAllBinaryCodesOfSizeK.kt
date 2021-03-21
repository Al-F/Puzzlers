package leetCode.march2021

import kotlin.math.pow

/**
 * Given a binary string s and an integer k.
 * Return True if every binary code of length k is a substring of s. Otherwise, return False.
 */
class CheckIfStringContainsAllBinaryCodesOfSizeK {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val hashSet = HashSet<String>()
        var j = k
        for (i in 0 .. s.length - k){
            if (j< s.length) {
                hashSet.add(s.substring(i, j))
                j++
            } else {
                hashSet.add(s.substring(i))
            }
        }
        return hashSet.size == 2.0.pow(k.toDouble()).toInt()
    }
}