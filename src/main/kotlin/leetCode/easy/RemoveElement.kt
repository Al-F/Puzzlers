package leetCode.easy

fun main() {
    val f = RemoveElement()
    f.removeElement(intArrayOf(1, 2, 3, 4, 5, 4, 3, 2, 3, 3, 3), 3)
}
class RemoveElement {
    fun removeElement(nums: IntArray, value: Int): Int {
        var indexDif = 0
        for (i in 0 until nums.size) {
            if (nums[i] == value) {
                indexDif++
            }

            while (i + indexDif < nums.size && nums[i + indexDif] == value) {
                indexDif++
            }
            if (i + indexDif < nums.size) {
                nums[i] = nums[i + indexDif]
            } else return nums.size - indexDif
        }
        return nums.size - indexDif
    }
}

// 1 2 3 4 5 4 3 2 3 2 3
// 1 2 4 5 4 2 2