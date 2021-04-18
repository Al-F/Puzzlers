package leetCode.april2021

import kotlin.math.roundToInt

class FibonacciNumber {
    fun fib(n: Int): Int {
        return ((Math.pow((1 + Math.sqrt(5.0)) / 2, n.toDouble()) + Math.pow(
            (1 - Math.sqrt(5.0)) / 2,
            n.toDouble()
        )) / Math.sqrt(5.0)).roundToInt()
    }
}