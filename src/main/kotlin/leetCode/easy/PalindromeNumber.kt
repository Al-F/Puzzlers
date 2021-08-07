package leetCode.easy

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val arr = x.toString().toCharArray()
        var j = arr.size - 1
        for (i in 0 until arr.size / 2) {
            if (arr[i] != arr[j]) return false
            j--
        }
        return true
    }
}