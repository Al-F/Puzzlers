package leetCode.february2021

@ExperimentalUnsignedTypes
fun main() {
    val f = NumberOf1Bits()
    val myI = "11111111111111111111111111111101".toInt(2)
    f.hammingWeight(myI)
}
/**
 * Write a function that takes an unsigned integer and returns the number
 * of '1' bits it has (also known as the Hamming weight).
 */
@ExperimentalUnsignedTypes
class NumberOf1Bits {
    fun hammingWeight(n: Int): Int {
        return n.toUInt().toString(2).count { it == '1' }
    }

    fun hammingWeightBitSum(n: Int): Int {
        var nN = n
        var sum = 0
        while (nN != 0) {
            sum++
            nN = nN and nN - 1
        }
        return sum
    }
}