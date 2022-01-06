package leetCode.january2022

fun main() {
    val f = PairsOfSongsWithTotalDurationsDivisibleBy60()
    System.out.println(f.numPairsDivisibleBy60(intArrayOf(60,60)))
}

class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val residuals = time.map { it % 60 }
        val dict = HashMap<Int, Int>()
        residuals.forEach { key ->
            val amount = dict.getOrPut(key, { 0 })
            dict[key] = amount+1
        }
        var pairsAmount = 0
        dict.keys.forEach {
            val lacking = 60 - it
            val amount = dict.getOrDefault(it, 0)

            pairsAmount += if (lacking == it || lacking == 60){
                amount*(amount-1)/2
            } else {
                val amountOfLac = dict.getOrDefault(lacking, 0)
                amount*amountOfLac
            }

            dict[it] = 0
        }
        return pairsAmount
    }
}