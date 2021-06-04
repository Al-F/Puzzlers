package leetCode.easy

class MaximumPopulationYear {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        logs.sortBy { it[0] }
        var max = Pair(0, 0)
        logs.forEach { that ->
            val population = logs.count { it[0] <= that[0] && it[1] > that[0]}
            if (population>max.first){
                max = population to that[0]
            }
        }
        return max.second
    }
}