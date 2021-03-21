package leetCode.march2021

fun main() {
    val f = BestTimeToBuyAndSellStockWithTransactionFee()
    f.maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2)
}

class BestTimeToBuyAndSellStockWithTransactionFee {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var result = 0
        var curMin = prices[0]
        var curMax = prices[0]
        for (price in prices) {
            if (price + fee < curMax || price < curMin) {
                result += Math.max(curMax - curMin - fee, 0)
                curMin = price
                curMax = price
            } else {
                curMax = Math.max(curMax, price)
                curMin = Math.min(curMin, price)
            }
        }

        result += Math.max(curMax - curMin - fee, 0)
        return result
    }
}