package leetCode.easy

import java.util.*

/**
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 * Return the maximum amount of split balanced strings.
 */
class SplitStringInBalancedStrings {
    fun balancedStringSplit(s: String): Int {
        var left = 0
        var right = 0
        var counter = 0
        s.forEach {
            if (it == 'L') left++
            if (it == 'R') right++
            if (left == right) {
                counter++
            }
        }
        return counter
    }

    /**
     * Make it a bit faster.
     */
    fun balancedStringSplitArray(s: String): Int {
        var left = 0
        var right = 0
        var counter = 0
        s.toCharArray().forEach {
            if (it == 'L') left++
            if (it == 'R') right++
            if (left == right) {
                counter++
            }
        }
        return counter
    }
}