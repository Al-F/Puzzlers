package leetCode.april2021

class PowerOfThree {

    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && 1162261467 % n == 0
    }
}