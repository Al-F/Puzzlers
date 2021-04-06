package leetCode.april2021

fun main() {
    val f = MinimumOperationsToMakeArrayEqual()
    f.minOperations(6)
}

class MinimumOperationsToMakeArrayEqual {
    fun minOperations(n: Int): Int {
        var sum = 0
        for (i in 0 until n / 2) {
            sum += n - (i * 2 + 1)
        }

        return sum
    }
    fun minConstant(n: Int): Int {
        return n*n/4
    }
}