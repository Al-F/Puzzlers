package leetCode.easy

class ClimbingStairs {
    fun climbStairs(n: Int): Int = (0..n).fold(1 to 1) { (first, second), _ -> second to first + second }.second
}