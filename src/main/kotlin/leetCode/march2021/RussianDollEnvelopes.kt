package leetCode.march2021

fun main() {
    val f = RussianDollEnvelopes()
    f.maxEnvelopes(
        arrayOf(
            intArrayOf(2, 100),
            intArrayOf(3, 200), intArrayOf(4, 300),
            intArrayOf(5, 500), intArrayOf(5, 400),
            intArrayOf(5, 250), intArrayOf(6, 370),
            intArrayOf(6, 360), intArrayOf(7, 380)
        )
    )
}

class RussianDollEnvelopes {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) return 0
        val sorted = envelopes.sortedWith(compareBy({ it[0] }, { it[1] }))
        var counter = 1
        var current = sorted[0]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] > current[0] && sorted[i][1] > current[1]) {
                counter++
                current = sorted[i]
            }
        }
        return counter
    }

    fun maxEnvelopes2(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) return 0
        val sorted = envelopes.sortedWith(compareBy({ it[0] }, { it[1] }))

        val n: Int = envelopes.size
        val dp = IntArray(n)

        var ret = 0
        for (i in 0 until n) {
            dp[i] = 1
            for (j in 0 until i) {
                if (sorted[i][0] > sorted[j][0]
                    && sorted[i][1] > sorted[j][1]
                ) {
                    dp[i] = Math.max(dp[i], 1 + dp[j])
                }
            }
            ret = Math.max(ret, dp[i])
        }
        return ret
    }
}