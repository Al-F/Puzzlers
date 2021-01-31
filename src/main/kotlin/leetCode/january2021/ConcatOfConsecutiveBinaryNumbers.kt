package leetCode.january2021

import kotlin.math.pow

fun main() {
    val f = ConcatOfConsecutiveBinaryNumbers()
    f.concatenatedBinary(43)
}
/**
 * Given an integer n, return the decimal value of the binary string formed
 * by concatenating the binary representations of 1 to n in order, modulo 10^9 + 7.
 */
class ConcatOfConsecutiveBinaryNumbers {
    fun concatenatedBinary(n: Int): Int {
        val MOD = 1000000007
        var sum: Long = 0
        for (i in 1..n) {
            sum = (sum * 2.0.pow(Integer.toBinaryString(i).length.toDouble()).toInt() + i) % MOD
        }
        return sum.toInt()
    }
}