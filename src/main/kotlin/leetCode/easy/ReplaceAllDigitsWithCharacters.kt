package leetCode.easy

import java.lang.StringBuilder
import javax.xml.stream.events.Characters

fun main() {
    val f = ReplaceAllDigitsWithCharacters()
    f.replaceDigits("a1c1e1")
}
class ReplaceAllDigitsWithCharacters {
    fun replaceDigits(s: String): String {
        val strBd = StringBuilder()
        for (i in 1 until s.length step 2){
            val prev = s[i-1]
            strBd.append(prev).append((prev.toInt() + Character.getNumericValue(s[i])).toChar())
        }
        if (s.length % 2 != 0) strBd.append(s.last())
        return strBd.toString()
    }
}