package leetCode.easy

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, i ->
            val tr = target - i
            for (j in index+1 until nums.size){
                if (tr == nums[j]) return intArrayOf(tr, j)
            }
        }
        return intArrayOf()
    }
}