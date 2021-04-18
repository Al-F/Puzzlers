package leetCode.easy

class FindTheHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var max = 0
        var cur = 0
        gain.forEach {
            cur += it
            max = Math.max(max, cur)
        }
        return max
    }
}