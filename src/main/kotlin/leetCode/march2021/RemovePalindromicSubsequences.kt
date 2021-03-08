package leetCode.march2021

class RemovePalindromicSubsequences {
    fun removePalindromeSub(s: String): Int {
        if(s.isEmpty()) return 0
        if(s == s.reversed()) return 1
        return 2
    }
}