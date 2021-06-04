package leetCode.may2021

fun main() {
    val f = JumpGameII()
    f.jump(intArrayOf(2,3,1,1,4))
}
class JumpGameII {
    fun jump(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        map[0] = 0
        nums.forEachIndexed { index, i ->
            for (j in index + 1..index + i) {
                if (j < nums.size) {
                    val value = map.getOrPut(j, { 0 })
                    val prevValue = map[index]
                    if (value == 0) {
                        map[j] = prevValue!! + 1
                    } else {
                        map[j] = Math.min(prevValue!! + 1, value)
                    }
                } else {
                    break
                }
            }
        }
        return map.getOrDefault(nums.size - 1, 0)
    }
}