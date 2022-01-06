package leetCode.october2021

class NthTribonachiNumber {
    fun tribonacci(n: Int): Int =
        (3..n).fold(Triple(0, 1, 1)) { (first, second, third), _ ->
            Triple(second, third, first + second + third) }.third
}