package leetCode.april2021

fun main() {
    val f = CountBinarySubstrings()
    f.countBinarySubstrings("00110")
}

class CountBinarySubstrings {
    fun countBinarySubstrings(s: String): Int {
        var zeros = 0
        var ones = 0
        var prev = s[0]
        var result = 0
        s.forEach {
            when (it) {
                '0' -> {
                    if (prev == '1' && zeros > 0 && ones > 0) {
                        result += minOf(zeros, ones)
                        zeros = 0
                    }
                    prev = '0'
                    zeros++
                }
                '1' -> {
                    if (prev == '0' && zeros > 0 && ones > 0) {
                        result += minOf(zeros, ones)
                        ones = 0
                    }
                    prev = '1'
                    ones++
                }
            }
        }
        result += minOf(zeros, ones)
        return result
    }
}