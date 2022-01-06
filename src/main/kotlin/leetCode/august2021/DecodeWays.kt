package leetCode.august2021

class DecodeWays {
    lateinit var dp: Array<Int>
    fun numDecodings(s: String): Int {
        dp = Array(s.length+1) { -1 }
        dp[s.length] = 1
        if (s.first() == '0') return 0
        if (s.length == 1) return 1
        decode(s, 0)
        return dp[0]
    }

    fun decode(s: String, ind: Int) {
        if (dp[ind] != -1) return
        if (s[ind] == '0') {
            dp[ind] = 0
            return
        }
        if (s.length - 1 == ind) {
            dp[ind] = 1
            return
        }
        if (ind<s.length-1 && s.substring(ind..ind + 1).toInt() < 27) {
            decode(s, ind + 1)
            decode(s, ind + 2)
            dp[ind] = dp[ind+1] + dp[ind+2]
        } else {
            decode(s, ind + 1)
            dp[ind] = dp[ind+1]
        }
    }
}