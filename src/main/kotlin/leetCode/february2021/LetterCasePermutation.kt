package leetCode.february2021

import java.util.*
import kotlin.collections.HashSet

fun main() {
    val f = LetterCasePermutation()
    f.letterCasePermutation("a1b2")
}

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. You can return the output in any order.
 */
class LetterCasePermutation {
    fun letterCasePermutation(S: String): List<String> {
        val result = HashSet<String>()
        val queue = LinkedList<CharArray>()
        val initialString = S.toLowerCase().toCharArray()
        queue.add(initialString)

        while (!queue.isEmpty()){
            val stringArr = queue.pollFirst()
            val string = stringArr.joinToString("")
            if (result.contains(string)) continue
            result.add(stringArr.joinToString(""))
            for (i in stringArr.indices){
                if (stringArr[i] in 'a'..'z'){
                    val newArray = stringArr.copyOf()
                    newArray[i] = stringArr[i].toUpperCase()
                    queue.add(newArray)
                }
            }
        }
        return result.toList()
    }
}