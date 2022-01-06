package leetCode.january2022

fun main() {
    val f = CarPooling()
    f.carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,5,7)), 3)
}
class CarPooling {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val road = IntArray(10000000) { capacity }

        trips.forEach {trip ->
            for (i in trip[1] until trip[2]) {
                road[i]-=trip[0]
            }
        }
        return !road.any { it < 0 }
    }
}