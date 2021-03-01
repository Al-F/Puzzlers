package leetCode.february2021

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer.
 */
fun main() {
    var f = RomanToInteger()
    f.romanToInt("MCMXCIV")
}
class RomanToInteger {
    fun romanToInt(s: String): Int {
        val chars = s.toCharArray()
        var previous = chars[s.length - 1]
        var sum = 0
        for (index in chars.size-1 downTo 0) {
            when (chars[index]) {
                'V' -> sum += 5
                'X' -> if (previous == 'L' || previous == 'C') sum -= 10 else sum += 10
                'L' -> sum += 50
                'C' -> if (previous == 'D' || previous == 'M') sum -= 100 else sum += 100
                'D' -> sum += 500
                'M' -> sum += 1000
                else -> if (previous == 'V' || previous == 'X') sum -= 1 else sum += 1
            }
            previous = chars[index]
        }
        return sum
    }
}