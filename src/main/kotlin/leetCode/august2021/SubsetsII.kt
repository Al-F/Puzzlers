package leetCode.august2021

import java.util.*
import kotlin.collections.HashSet

fun main() {
    val f = SubsetsII()
    f.shorterVersion(intArrayOf(1, 2, 2))
}

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>(emptyList())
        val stack = Stack<Pair<List<Int>, Int>>()
        for (i in nums.indices) {
            stack.push(listOf(nums[i]) to i)
        }
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            result.add(cur.first.sorted())
            for (i in cur.second + 1 until nums.size) {
                val copy = cur.first.toMutableList()
                copy.add(nums[i])
                stack.push(copy to i)
            }
        }
        return result.toList()
    }

    fun shorterVersion(nums: IntArray): List<List<Int>>{
        val res = mutableSetOf<List<Int>>(emptyList())
        for (n in nums.sorted()) {
            res += res.map { it + n }
        }
        return res.toList()
    }
}