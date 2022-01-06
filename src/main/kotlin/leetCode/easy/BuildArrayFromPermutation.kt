package leetCode.easy

class BuildArrayFromPermutation {
    fun buildArray(nums: IntArray): IntArray {
        return (nums.indices).mapIndexed { index, _ ->
            nums[nums[index]]
        }.toIntArray()
    }
}