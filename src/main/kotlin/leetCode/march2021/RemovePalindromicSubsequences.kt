package leetCode.march2021

/**
 * Given a string s consisting only of letters 'a' and 'b'.
 * In a single step you can remove one palindromic subsequence from s.
 * Return the minimum number of steps to make the given string empty.
 * A string is a subsequence of a given string, if it is generated
 * by deleting some characters of a given string without changing its order.
 * A string is called palindrome if is one that reads the same backward as well as forward.
 */
class RemovePalindromicSubsequences {
    fun removePalindromeSub(s: String): Int {
        if(s.isEmpty()) return 0
        if(s == s.reversed()) return 1
        return 2
    }
}