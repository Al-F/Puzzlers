package leetCode.easy

class CountGoodTriplets {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var counter = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                for (k in j + 1 until arr.size) {
                    val first = Math.abs(arr[i] - arr[j]) <= a
                    val second = Math.abs(arr[j] - arr[k]) <= b
                    val third = Math.abs(arr[i] - arr[k]) <= c
                    if (first&& second && third) counter++
                }
            }
        }
        return counter
    }
}