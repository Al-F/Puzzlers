package leetCode.february2021

import java.lang.Integer.min
import kotlin.math.log
import kotlin.math.pow

/**
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 * Return the minimum number of operations needed to display the number Y.
 */
fun main() {
    val f = BrokenCalculator()
    f.brokenCalcSolution(68, 71)
}
class BrokenCalculator {
    fun brokenCalc(X: Int, Y: Int): Int {
        if (X > Y) return X - Y
        if (X == Y) return 0
        var start = X
        var count = 0
        while (start < Y) {
            start *= 2
            count++
        }
        if (start == Y) return count
        var overshoot = start - Y
        var countPows = 0
        while (overshoot != 0) {
            val tmp = 2.0.pow(log(overshoot.toDouble(), 2.0).toInt()).toInt()
            overshoot -= min(tmp, 2.0.pow(count).toInt())
            countPows++
        }
        return count + countPows
    }

    fun brokenCalcSolution(X: Int, Y: Int): Int {
        var end = Y
        var ans = 0
        while (end > X) {
            ans++
            if (end % 2 == 1) end++ else end /= 2
        }
        return ans + X - end
    }
}