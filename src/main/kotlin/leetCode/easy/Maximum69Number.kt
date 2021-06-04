package leetCode.easy

import java.lang.StringBuilder

class Maximum69Number {
    fun maximum69Number (num: Int): Int {
        val sb = StringBuilder()
        var changed = false
        num.toString().toCharArray().forEach {
            when(it) {
                '6' -> {
                    if (!changed){
                        changed = true
                        sb.append('9')
                    } else sb.append(it)
                }
                '9' -> sb.append(it)
            }
        }
        return sb.toString().toInt()
    }
}