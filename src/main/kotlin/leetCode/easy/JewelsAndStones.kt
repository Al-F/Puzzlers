package leetCode.easy

/**
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
class JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var counter = 0
        val hashSet = jewels.toHashSet()
        stones.forEach { if (hashSet.contains(it)) counter++ }
        return counter
    }

    fun numJewelsInStonesFilter(jewels: String, stones: String): Int {
        return stones.filter { jewels.toHashSet().contains(it) }.length
    }
}