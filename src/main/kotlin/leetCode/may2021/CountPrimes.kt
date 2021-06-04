package leetCode.may2021

fun main() {
    val f = CountPrimes()
    f.countPrimes(10)
}
class CountPrimes {
    fun countPrimes(n: Int): Int {
        if (n<2) return 0
        val numbers = Array(n) { true }
        val sqrt = Math.sqrt(n.toDouble()).toInt()
        numbers[0] = false
        numbers[1] = false
        for (i in 2..sqrt) {
            if (numbers[i]) {
                var j = i * i
                while (j < n) {
                    numbers[j] = false
                    j += i
                }
            }
        }
        return numbers.count { it }
    }
}