package leetCode.easy

/**
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 */
fun main() {
    val f = SubtractProductAndSumOfDigits()
    f.subtractProductAndSum(234)
}

class SubtractProductAndSumOfDigits {
    fun subtractProductAndSum(n: Int): Int {
        var number = n
        var sum = 0
        var prod = 1
        while (number != 0){
            val current = number % 10
            sum+=current
            prod*=current
            number /= 10
        }
        return prod - sum
    }
}