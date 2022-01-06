package leetCode.easy

fun main() {
    val f = BestTimeToBuyAndSellStockII()
    f.maxProfit(intArrayOf(2, 4, 1))
}
class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var max = Int.MIN_VALUE
        var result = 0

        for (i in 1 until prices.size) {
            when {
                prices[i] < min && max == Int.MIN_VALUE-> min = prices[i]
                prices[i] > max -> max = prices[i]
                prices[i] < max -> {
                    result += max - min
                    min = prices[i]
                    max = Int.MIN_VALUE
                }
            }
        }
        if (max != Int.MIN_VALUE && min < max) result += max - min
        return result
    }
}