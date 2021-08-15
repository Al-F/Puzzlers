package leetCode.easy

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var length = 0
        var started = false
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                started = true
                length++
            } else if (started) {
                return length
            }
        }
        return length
    }
}