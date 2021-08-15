package leetCode.easy

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        var min = Int.MAX_VALUE
        for (i in prices.indices){
            if (prices[i] < min){
                min = prices[i]
            } else if (prices[i] - min > max){
                max = prices[i] - min
            }
        }
        return max
    }
}