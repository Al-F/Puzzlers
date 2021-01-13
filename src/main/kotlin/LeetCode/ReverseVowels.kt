package LeetCode

/**
 * Question: 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
class ReverseVowels {
    fun reverseVowels(s: String): String {
        var left = 0
        var right = s.length - 1
        val chars = s.toCharArray()

        while(left < right) {
            if(chars[left].isVowel() && chars[right].isVowel()) {
                chars[left] = chars[right].also {chars[right] = chars[left]}
                left+= 1
                right-=1
            }

            if(!chars[left].isVowel()) {
                left+= 1
            }

            if(!chars[right].isVowel()) {
                right-=1
            }
        }

        return String(chars)
    }

    fun Char.isVowel(): Boolean =  "aeiouAEIOU".contains(this)
}