package leetCode.easy

/**
 * Given an integer n and an integer start.
 * Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
 * Return the bitwise XOR of all elements of nums.
 */
fun main() {
    val f = XorOperationInAnArray()
    f.xorOperation(5, 0)
}
class XorOperationInAnArray {
    fun xorOperation(n: Int, start: Int): Int {
        var cntDwn = n - 1
        var res = start
        var i = 1
        while (cntDwn > 0) {
            res = res xor (start + 2*i)
            i++
            cntDwn--
        }
        return res
    }
}