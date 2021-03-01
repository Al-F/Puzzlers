package leetCode.february2021

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division, and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * Note:
 * Assume we are dealing with an environment that could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1].
 * For this problem, assume that your function returns 231 − 1
 * when the division result overflows.
 */
fun main() {
    val f = DivideTwoIntegers()
    f.divide(
        -2147483648, -1
    )
}

class DivideTwoIntegers {
    @ExperimentalUnsignedTypes
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 0) return 0
        if (divisor == Int.MIN_VALUE) return if (dividend == divisor) 1 else 0
        val sign = if ((dividend < 0) xor (divisor < 0)) -1 else 1
        var left = Math.abs(dividend.toLong())
        val div = Math.abs(divisor)
        var counter = 0.toLong()
        if (div == 1){
            counter = left
            left = 0
        }
        while (left >= div) {
            left -= div
            counter++
        }
        counter = if ((sign < 0 && counter > 0) || (sign > 0 && counter < 0)) sign * counter else counter
        if (counter >= Int.MAX_VALUE) return Int.MAX_VALUE
        if (counter <= Int.MIN_VALUE) return Int.MIN_VALUE
        return counter.toInt()
    }
}