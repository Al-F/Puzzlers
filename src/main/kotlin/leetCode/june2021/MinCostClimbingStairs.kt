package leetCode.june2021

fun main() {
    val f = MinCostClimbingStairs()
    f.minCostClimbingStairs(intArrayOf(0,2,2,1))
}

class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val sums = Array(cost.size){0}
        for (i in 2 until cost.size){
            sums[i] = Math.min(sums[i-2] + cost[i-2], sums[i-1] + cost[i-1])
        }
        return Math.min(sums.last() + cost.last(), sums[sums.size-2]+ cost[cost.size-2])
    }
}