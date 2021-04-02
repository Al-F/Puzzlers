package leetCode.march2021

fun main() {
    val f = ThreeSumWithMultiplicity()
    f.threeSumMulti(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5), 8)
}

class ThreeSumWithMultiplicity {
    private val MOD: Long = 1000000007
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val sumList = HashMap<Int, Long>()
        var counter = 0L

        for (k in arr.indices) {
            val sum = sumList.getOrDefault(target - arr[k], -1L)
            if (sum != -1L) counter += sum

            for (i in 0 until k) { // k => j
                val key = arr[k] + arr[i]
                val value = sumList.getOrPut(key) { 0L }
                sumList[key] = value + 1L
            }
        }
        return (counter % MOD).toInt()
    }
}