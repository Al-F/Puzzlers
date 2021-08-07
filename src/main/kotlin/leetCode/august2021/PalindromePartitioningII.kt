package leetCode.august2021

fun main() {
    val f = PalindromePartitioningII()
    print(f.minCut("aabbacbbc"))
}

class PalindromePartitioningII {
    fun minCut(s: String): Int {
        if (s == s.reversed()) return 0
        val cuts = IntArray(s.length)
        val matrix = Array(s.length) { BooleanArray(s.length) }
        for (i in s.indices) {
            var min = i
            for (j in 0..i) {
                if (s[i] == s[j] && (j + 1 > i - 1 || matrix[j + 1][i - 1])) {
                    matrix[j][i] = true
                    min = if (j == 0) 0 else Math.min(min, cuts[j - 1] + 1)
                }
            }
            cuts[i] = min
        }
        return cuts.last()
    }
}