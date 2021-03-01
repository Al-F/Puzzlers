package leetCode.easy

import java.lang.StringBuilder

fun main() {
    val f = SuffleString()
    f.restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3))
}
/**
 *  Given a string s and an integer array indices of the same length.
 *  The string s will be shuffled such that the character at the ith position
 *  moves to indices[i] in the shuffled string.
 *  Return the shuffled string.
 */
class SuffleString {
    fun restoreString(s: String, indices: IntArray): String {
        val charString = s.toCharArray()
        val stringRes = CharArray(indices.size)
        for (i in indices.indices){
            stringRes[indices[i]] = (charString[i])
        }
        return stringRes.joinToString()
    }
}