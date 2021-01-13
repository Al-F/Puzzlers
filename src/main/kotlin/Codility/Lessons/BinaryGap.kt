package Codility.Lessons

import kotlin.math.max

class BinaryGap {
    fun solution(N: Int): Int {
        var maxGap = 0
        var binary = N.toString(2)
        var wasOne = false
        var zeroCounter = 0
        for (char in binary) {
            if (char == '1') {
                if (!wasOne) {
                    maxGap = if (maxGap < zeroCounter) zeroCounter else maxGap
                    zeroCounter = 0
                }
                wasOne = true
            } else {
                if (wasOne || zeroCounter != 0) {
                    zeroCounter++
                }
                wasOne = false
            }
        }
        return maxGap
    }
}