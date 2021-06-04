package leetCode.may2021

import java.lang.StringBuilder

class ToLowerCase {
    fun toLowerCase(s: String): String {
        val dict = HashMap<Char, Char>()
        dict.put('Z', 'z')
        dict.put('X', 'x')
        dict.put('C', 'c')
        dict.put('V', 'v')
        dict.put('B', 'b')
        dict.put('N', 'n')
        dict.put('M', 'm')
        dict.put('A', 'a')
        dict.put('S', 's')
        dict.put('D', 'd')
        dict.put('F', 'f')
        dict.put('G', 'g')
        dict.put('H', 'h')
        dict.put('J', 'j')
        dict.put('K', 'k')
        dict.put('L', 'l')
        dict.put('Q', 'q')
        dict.put('W', 'w')
        dict.put('E', 'e')
        dict.put('R', 'r')
        dict.put('T', 't')
        dict.put('Y', 'y')
        dict.put('U', 'u')
        dict.put('I', 'i')
        dict.put('O', 'o')
        dict.put('P', 'p')

        val sb = StringBuilder()
        s.forEach {
            if (dict.containsKey(it)) {
                sb.append(dict[it])
            } else {
                sb.append(it)
            }
        }
        return sb.toString()
    }

    fun toLowerCaseEasy(s: String): String {
        return s.toLowerCase()
    }

    fun toLowerCaseIntRep(str: String): String {
        val sb = StringBuilder()
        str.forEach { c ->
            when (c.toInt()) {
                in 65..90 -> sb.append(c.plus(32))
                else -> sb.append(c)
            }
        }
        return sb.toString()
    }
}