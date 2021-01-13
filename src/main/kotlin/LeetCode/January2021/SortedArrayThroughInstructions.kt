package LeetCode.January2021

/**
 * Given an integer array instructions, you are asked to create a sorted array from the elements in instructions.
 * You start with an empty container nums. For each element from left to right in instructions, insert it into nums.
 * The cost of each insertion is the minimum of the following:
 *
 * The number of elements currently in nums that are strictly less than instructions[i].
 * The number of elements currently in nums that are strictly greater than instructions[i].
 *
 * For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1)
 * (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].
 *
 * Return the total cost to insert all elements from instructions into nums.
 * Since the answer may be large, return it modulo 109 + 7
 */
class SortedArrayThroughInstructions {

        // Exceed time limits in some test cases
//        val m = 1000000007
//        var counter = 0
//        val array = Array(instructions.size) { 0 }
//        for (i in instructions.indices) {
//            counter += min(
//                array.filter { it != 0 }.count { it < instructions[i] },
//                array.filter { it != 0 }.count { it > instructions[i] }) % m
//            array[i] = instructions[i]
//        }
//        return counter

//          Same here
//        val m = 1000000007
//        var counter = 0
//        val array = arrayListOf<Int>()
//        for (i in instructions.indices) {
//            counter += min(
//                array.count { it < instructions[i] },
//                array.count { it > instructions[i] }) % m
//            array.add(instructions[i])
//        }
//        return counter


        // Time Limit Exceeds
//        val m = 1000000007
//        var counter = 0
//        var inv_count = 0
//        var cov_count = 0
//        for (n in instructions.indices) {
//            for (i in 0 until n) {
//                if (instructions[i] > instructions[n]) {
//                    inv_count++
//                }
//                if (instructions[i] < instructions[n]) {
//                    cov_count++
//                }
//            }
//            counter += min(inv_count, cov_count) % m
//            inv_count = 0
//            cov_count = 0
//        }
//
//        return counter

    fun createSortedArray(instructions: IntArray): Int {
        val tree = Fenwick(100002)
        var cost: Long = 0
        val MOD: Long = 1000000007
        for (i in instructions.indices) {
            val leftCost = tree.query(instructions[i] - 1)
            val rightCost = i - tree.query(instructions[i])
            cost += Math.min(leftCost, rightCost).toLong()
            tree.add(instructions[i], 1)
        }
        return (cost % MOD).toInt()
    }

    internal class Fenwick(size: Int) {
        var tree: IntArray
        var m: Int
        fun add(index: Int, value: Int) {
            var index = index
            while (index < m) {
                tree[index] += value
                index += index and -index
            }
        }

        fun query(index: Int): Int {
            var index = index
            var result = 0
            while (index > 0) {
                result += tree[index]
                index -= index and -index
            }
            return result
        }

        init {
            tree = IntArray(size)
            m = size
        }
    }
}