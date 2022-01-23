package leetCode.january2022

import java.util.*

fun main() {
    val f = SequentialDigits()
    f.sequentialDigits(100, 300)
}
class SequentialDigits {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = arrayListOf<Int>()
        for (i in 1 .. 9){
            var cur = 0
            var next = i
            while (cur <= high){
                if (cur>=low) result.add(cur)
                cur = cur*10 + next
                if(next < 10) next++ else break
            }
        }
        return result.sorted()
    }
}