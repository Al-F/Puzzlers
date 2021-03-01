package leetCode.easy

import java.lang.StringBuilder

/**
 * You own a Goal Parser that can interpret a string command.
 * The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
 * The Goal Parser will interpret "G" as the string "G",
 * "()" as the string "o", and "(al)" as the string "al".
 *
 * The interpreted strings are then concatenated in the original order.
 * Given the string command, return the Goal Parser's interpretation of command.
 */
class GoalParcerInterpretation {
    fun interpret(command: String): String {
        val result = StringBuilder()
        var previous = ' '
        command.forEach {
            when(it){
                'G' -> result.append('G')
                ')' -> if (previous == '(') result.append("o") else result.append("al")
            }
            previous = it
        }
        return result.toString()
    }
}