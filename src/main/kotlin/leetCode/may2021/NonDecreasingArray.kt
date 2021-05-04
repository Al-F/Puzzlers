package leetCode.may2021

fun main() {
    val f = NonDecreasingArray()
    f.checkPossibility(intArrayOf(-1,4,2,3))
}
class NonDecreasingArray {
    fun checkPossibility(nums: IntArray): Boolean {
        var prev = nums[0]
        var changed = false
        for (i in 1 until nums.size) {
            if (nums[i] < prev) {
                if (changed) return false
                if (i == 1 || i == nums.size - 1 || nums[i-2]<=nums[i] || nums[i-1] <= nums[i+1]){
                    changed = true
                } else return false
            }
            prev = nums[i]
        }
        return true
    }
}