package leetCode.march2021

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        if (coins.size == 1) {
            return if (coins[0] > amount || amount % coins[0] != 0) {
                -1
            } else amount / coins[0]
        }
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        arrayDeque.addLast(amount to 0)
        while (arrayDeque.isNotEmpty()) {
            val rem = arrayDeque.removeFirst()
            coins.forEachIndexed { _, i ->
                if (rem.first - i == 0) return rem.second + 1
                if (rem.first - i > 0 && arrayDeque.find { it.first == i } == null) {
                    arrayDeque.addLast(rem.first - i to rem.second + 1)
                }
            }
        }
        return -1
    }

    fun coinChangeOptimized(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        if (coins.size == 1) {
            return if (coins[0] > amount || amount % coins[0] != 0) {
                -1
            } else amount / coins[0]
        }
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        val seenValues = hashSetOf(amount)
        arrayDeque.addLast(amount to 0)
        while (arrayDeque.isNotEmpty()) {
            val rem = arrayDeque.removeFirst()
            coins.forEachIndexed { _, i ->
                val new = rem.first - i
                if (new == 0) return rem.second + 1
                if (new > 0 && !seenValues.contains(new)) {
                    seenValues.add(new)
                    arrayDeque.addLast(new to rem.second + 1)
                }
            }
        }
        return -1
    }
}