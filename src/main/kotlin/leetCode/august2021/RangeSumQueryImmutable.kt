package leetCode.august2021

class RangeSumQueryImmutable {
    class NumArray(private val nums: IntArray) {
        val sums = Array(nums.size){0}
        init {
            var sum = 0
            nums.forEachIndexed { index, i ->
                sum+=nums[i]
                sums[i] = sum
            }
        }

        fun sumRange(left: Int, right: Int): Int {
            return if (left!=0){sums[right]-sums[left-1]} else sums[right]
        }

    }
}