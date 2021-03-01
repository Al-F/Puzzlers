package leetCode.easy

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
fun main() {
    val f = ShuffleTheArray()
    f.shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3)
}

class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(nums.size)
        nums.forEachIndexed { index, i -> if (index < n) result[index * 2] = i else result[index % n * 2 + 1] = i }
        return result
    }
}