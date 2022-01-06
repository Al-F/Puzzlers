package leetCode.august2021

class FlipStringToMonotoneIncreasing {
    fun minFlipsMonoIncr(s: String): Int {
        val flips = ArrayList<Pair<Int, Int>>()
        var flipToOne = 0
        var flipToZero = 0
        for (i in 1 until s.length) {
            if (s[i] == '0') flipToOne++
        }
        flips.add(flipToZero to flipToOne)
        for (i in 1 until s.length) {
            flipToZero = flips[i - 1].first
            flipToOne = flips[i - 1].second
            if (s[i - 1] == '1') {
                flipToZero++
            }
            if (s[i] == '0') {
                flipToOne--
            }
            flips[i] = flipToZero to flipToOne
        }
        return flips.map { it.first + it.second }.minOrNull() ?: 0
    }
}