package leetCode.may2021

import java.lang.StringBuilder

fun main() {
    val f = AmbiguousCoordinates()
    f.ambiguousCoordinates("(012345)")
}

class AmbiguousCoordinates {
    fun ambiguousCoordinates(s: String): List<String> {
        val result = ArrayList<String>()
        for (i in 1..s.length - 3) {
            val firstArr = ArrayList<String>()
            val first = s.substring(1, i + 1)
            for (j in 0 until i) {
                if (first.length == 1) {
                    firstArr.add(first)
                } else {
                    val changed = if (j == 0) first else StringBuilder(first).insert(j, ".").toString()
                    if (validate(changed)) {
                        firstArr.add(changed)
                    }
                }
            }

            val secondArr = ArrayList<String>()
            val second = s.substring(i + 1, s.length - 1)
            for (j in second.indices) {
                if (second.length == 1) {
                    secondArr.add(second)
                } else {
                    val changed = if (j == 0) second else StringBuilder(second).insert(j, ".").toString()
                    if (validate(changed)) secondArr.add(changed)
                }
            }
            firstArr.forEach { one ->
                secondArr.forEach { two ->
                    result.add("($one, $two)")
                }
            }
        }
        return result
    }

    private fun validate(str: String): Boolean {
        var hadDot = false
        str.forEachIndexed { index, c ->
            if (c == '.') hadDot = true
            if (c == '0') {
                if (index == 0 && str[index + 1] != '.') return false
                if (hadDot && index == str.length - 1) return false
            }
        }
        return true
    }
}