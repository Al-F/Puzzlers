package leetCode.january2022

import java.math.BigInteger

fun main() {
    val f = StringToInteger()
    f.myAtoi2("-91283472332")
}
class StringToInteger {
    fun myAtoi(s: String): Int {
        val result = StringBuilder()
        var sign = +1
        val clearedS = StringBuilder(s)
        while (clearedS.isNotEmpty() && clearedS[0] == ' '){
            clearedS.deleteCharAt(0)
        }
        if (clearedS[0] == '-'){
            sign = -1
            clearedS.deleteCharAt(0)
        } else if (clearedS[0] == '+'){
            clearedS.deleteCharAt(0)
        }
        val range = '0' .. '9'
        var started = false
        if (clearedS[0] in range){
            started = true
        } else return 0
        var index = 0
        while (started && index<clearedS.length){
            if (clearedS[index] in range) {
                result.append(clearedS[index])
                index++
            } else {
                started = false
            }
        }

        val resultLong = if (result.length > 10){
            Int.MAX_VALUE.toLong()
        } else result.toString().toLong()

        return when {
            sign * resultLong >= Int.MAX_VALUE -> {
                Int.MAX_VALUE
            }
            sign * resultLong <= Int.MIN_VALUE -> {
                Int.MIN_VALUE
            }
            else -> {
                sign * resultLong.toInt()
            }
        }
    }

    fun myAtoi2(s: String): Int {
        var result = BigInteger.ZERO
        var sign = +1
        val clearedS = StringBuilder(s)
        while (clearedS.isNotEmpty() && clearedS[0] == ' '){
            clearedS.deleteCharAt(0)
        }
        if (clearedS.isNotEmpty() && clearedS[0] == '-'){
            sign = -1
            clearedS.deleteCharAt(0)
        } else if (clearedS.isNotEmpty() && clearedS[0] == '+'){
            clearedS.deleteCharAt(0)
        }

        val range = '0' .. '9'
        var started: Boolean
        if (clearedS.isNotEmpty() && clearedS[0] in range){
            started = true
        } else return 0

        var index = 0
        while (started && index<clearedS.length){
            if (clearedS[index] in range) {
                result = result*BigInteger.valueOf(10) + BigInteger.valueOf(clearedS[index].toString().toLong())
                index++
            } else {
                started = false
            }
        }

        return when {
            sign.toBigInteger() * result >= Int.MAX_VALUE.toBigInteger() -> {
                Int.MAX_VALUE
            }
            sign.toBigInteger() * result <= Int.MIN_VALUE.toBigInteger() -> {
                Int.MIN_VALUE
            }
            else -> {
                sign * result.toInt()
            }
        }
    }
}