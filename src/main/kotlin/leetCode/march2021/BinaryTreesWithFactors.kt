package leetCode.march2021

fun main() {
    val f = BinaryTreesWithFactors()
    f.numFactoredBinaryTrees(intArrayOf(2, 4, 5, 10))
}

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * Return the number of binary trees we can make.
 * The answer may be too large so return the answer modulo 109 + 7.
 */
const val mod = 1000000007
class BinaryTreesWithFactors {

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val hashMap = HashMap<Int, Long>()
        arr.forEach {
            hashMap[it] = 1
        }

        arr.sort()
        for (i in arr.indices) {
            for (j in 0 until i) {
                if (arr[i] % arr[j] != 0) continue
                val div = arr[i] / arr[j]
                val f = hashMap[arr[j]] ?: 1
                val s = hashMap[div] ?: 0
                val value = hashMap[arr[i]] ?: 1
                hashMap[arr[i]] = value + f * s
            }
        }

        var res = 0L
        hashMap.values.forEach {
            res = (res + it) % mod
        }
        return res.toInt()
    }
}