package leetCode.may2021

import java.lang.StringBuilder

fun main() {
    val f = SuperPalindromes()
    f.superpalindromesInRange("4", "1000")
}

class SuperPalindromes {
    fun superpalindromesInRange(left: String, right: String): Int {
        val leftL = left.toLong()
        val rightL = right.toLong()
        var counter = 0

        //even
        for (i in 1..10000) {
            val sb = StringBuilder(i.toString())
            for (j in sb.length - 2 downTo 0) {
                sb.append(sb[j])
            }
            val polindr = sb.toString().toLong()
            val sqr = polindr * polindr
            if (sqr > rightL) break
            if (isPalindrom(sqr) && sqr >= leftL) {
                counter++
            }
        }

        //odd
        for (i in 1..10000) {
            val sbOdd = StringBuilder(i.toString())
            for (j in sbOdd.length - 1 downTo 0) {
                sbOdd.append(sbOdd[j])
            }
            val polindrOdd = sbOdd.toString().toLong()
            val sqr = polindrOdd * polindrOdd
            if (sqr > rightL) break
            if (isPalindrom(sqr) && sqr >= leftL) {
                counter++
            }
        }
        return counter
    }

    private fun isPalindrom(number: Long): Boolean {
        return number == reverse(number)
    }

    fun reverse(xL: Long): Long {
        var x = xL
        var ans: Long = 0
        while (x > 0) {
            ans = 10 * ans + x % 10
            x /= 10
        }
        return ans
    }
}