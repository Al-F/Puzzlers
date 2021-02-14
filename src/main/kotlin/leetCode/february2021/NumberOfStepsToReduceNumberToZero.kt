package leetCode.february2021

/**
 * Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even,
 * you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
class NumberOfStepsToReduceNumberToZero {
    fun numberOfSteps(num: Int): Int {
        var counter = 0
        var newNum = num
        while (newNum != 0) {
            newNum = if (newNum % 2 == 0)  newNum / 2 else newNum - 1
            counter++
        }
        return counter
    }
}