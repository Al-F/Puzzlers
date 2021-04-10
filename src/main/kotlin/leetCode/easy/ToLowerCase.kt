package leetCode.easy

import java.lang.StringBuilder

class ToLowerCase {
    val dict = HashMap<Char, Char>()
    init {
        dict.put('A', 'a')
        dict.put('B', 'b')
        dict.put('C', 'c')
        dict.put('D', 'd')
        dict.put('E', 'e')
        dict.put('F', 'f')
        dict.put('G', 'g')
        dict.put('H', 'h')
        dict.put('I', 'i')
        dict.put('J', 'j')
        dict.put('K', 'k')
        dict.put('L', 'l')
        dict.put('M', 'm')
        dict.put('N', 'n')
        dict.put('O', 'o')
        dict.put('P', 'p')
        dict.put('Q', 'q')
        dict.put('R', 'r')
        dict.put('S', 's')
        dict.put('T', 't')
        dict.put('U', 'u')
        dict.put('V', 'v')
        dict.put('W', 'w')
        dict.put('X', 'x')
        dict.put('Y', 'y')
        dict.put('Z', 'z')
    }
    fun toLowerCase(str: String): String {
        val result = StringBuilder()
        str.forEach {
            result.append(dict.getOrDefault(it, it))
        }
        return result.toString()
    }
}