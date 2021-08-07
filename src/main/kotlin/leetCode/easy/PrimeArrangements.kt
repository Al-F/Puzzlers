package leetCode.easy

import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val f = PrimeArrangements()
    f.numPrimeArrangements(20)
}
class PrimeArrangements {
    companion object{
        const val MOD = 1000000007
    }
    fun numPrimeArrangements(n: Int): Int {
        val primes = (1 until n).count { it.isPrime() }
        val nonPrimes = n - primes
        val init = factorial(primes, 1)
        val res = factorial(nonPrimes, init)
        println("init = $init, res = $res")
        return res
    }

    private fun Int.isPrime(): Boolean {
        val ceiling: Int = Math.ceil(Math.sqrt(this.toDouble())).toInt()
        return this == 2 || (2..ceiling).none { delimeter -> this % delimeter == 0 }
    }

    fun factorial(number: Int, initial: Int) =
        (1..number).fold(initial) {acc, i ->
            (acc.toLong() * i.toLong() % MOD).toInt().also {
                println("acc = $acc, i = $i")
            }
        }
}