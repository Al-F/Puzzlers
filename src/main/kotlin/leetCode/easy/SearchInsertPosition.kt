package leetCode.easy

fun main() {
    val f = SearchInsertPosition()
    f.searchInsert(intArrayOf(1), 0)
}
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (target == nums[nums.size / 2]) return nums.size / 2
        return if (nums[nums.size / 2] > target) {
            search(nums.copyOfRange(0, nums.size / 2 + 1), target, 0)
        } else {
            search(nums.copyOfRange(nums.size / 2, nums.size), target, nums.size / 2)
        }
    }

    private fun search(half: IntArray, target: Int, curInd: Int): Int {
        if (half.size == 1){
            if (half[0] >= target) {
                return curInd
            }
            if (half[0] < target) return curInd+1
        }
        if (half[half.size / 2] == target) return curInd + half.size / 2
        return if (half[half.size / 2] > target) {
            search(half.copyOfRange(0, half.size / 2), target, curInd)
        } else {
            search(half.copyOfRange(half.size / 2, half.size), target, curInd + half.size / 2)
        }
    }

}