package leetCode.easy

import java.math.BigDecimal

fun main() {
    val f = Sqrt()
    f.mySqrt(114)
}
class Sqrt {
    fun mySqrt(x: Int): Int {
        var i: BigDecimal = BigDecimal.ZERO
        val _x = BigDecimal(x)
        while (i*i<=_x){
            i++
        }
        return i.toInt()-1
    }
}