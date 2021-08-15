package leetCode.easy

fun main() {
    val f = ValidPalindrome()
    f.isPalindrome(".,")
}

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        //race a car
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while ((s[i] !in 'A'..'Z' && s[i] !in 'a'..'z' && s[i] !in '0'..'9') && i < j) {
                i++
            }
            while ((s[j] !in 'A'..'Z' && s[j] !in 'a'..'z' && s[j] !in '0'..'9') && j > i) {
                j--
            }
            if (!s[i].equals(s[j], true)) return false
            i++
            j--
        }
        return true
    }
}