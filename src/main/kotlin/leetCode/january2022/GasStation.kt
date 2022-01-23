package leetCode.january2022

fun main() {
    val f = GasStation()
    f.canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3, 4, 3))
}

class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val sum = gas.zip(cost) { g, c -> g - c }
        var start = sum.indexOfFirst { it >= 0 }
        if (start < 0) return -1
        var journey = sum[start]
        var end = if (start == sum.size - 1) 0 else start + 1
        while (start < sum.size && end != start) {
            journey += sum[end]
            while (journey < 0 && start < sum.size && start <= end) {
                if (start<end){
                    journey -= sum[start]
                    start++
                } else {
                    start = if (start == sum.size - 1) return -1 else start + 1
                    journey = sum[start]
                    end = start
                }
            }
            end = if (end == sum.size - 1) 0 else end + 1
        }
        return if (journey < 0) -1 else start
    }
}