package leetCode.july2021

fun main() {
    val f = ReduceArraySizeToTheHalf()
    f.minSetSize(intArrayOf(3,7))
}
class ReduceArraySizeToTheHalf {

    fun minSetSize(arr: IntArray): Int {
        var acc = 0
        var res = 0

        arr.groupBy { it }.mapValues { it.value.size }.values.sortedDescending().forEach {
            if (acc<arr.size/2){
                acc+=it
                res++
            } else return@forEach
        }
        return res
    }
}