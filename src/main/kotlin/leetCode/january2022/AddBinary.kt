package leetCode.january2022

import java.lang.StringBuilder

fun main() {
    val f = AddBinary()
    f.addBinary("1000100011100",
        "11001")
}
class AddBinary {
    fun addBinary(a: String, b: String): String {
        var rem = 0
        val small = if (a.length < b.length) a else b
        val big = if (a.length >= b.length) a else b

        val result = StringBuilder()
        var ind = big.length - 1
        for (i in small.length - 1 downTo 0) {
            val cur = if (small[i] == '1' && big[ind] == '1') {
                if (rem == 0) {
                    rem++
                    '0'
                } else {
                    '1'
                }
            } else {
                if (rem == 0) {
                    if (small[i] == '1' || big[ind] == '1') {
                        '1'
                    } else {
                        '0'
                    }
                } else {
                    if (small[i] == '1' || big[ind] == '1') {
                        '0'
                    } else {
                        rem--
                        '1'
                    }
                }
            }
            ind--
            result.insert(0, cur)
        }
        if (ind >= 0) {
            for (i in ind downTo 0) {
                var cur = if (rem != 0) {
                    if (big[i] == '0') {
                        rem--
                        '1'
                    } else {
                        '0'
                    }
                } else {
                    big[i]
                }
                result.insert(0, cur)
            }
        }
        if (rem != 0) result.insert(0, '1')
        return result.toString()
    }
}