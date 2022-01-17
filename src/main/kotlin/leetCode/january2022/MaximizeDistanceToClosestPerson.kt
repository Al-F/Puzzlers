package leetCode.january2022

fun main() {
    val f = MaximizeDistanceToClosestPerson()
    f.maxDistToClosest(intArrayOf(0,0,0,1,0,0,0,0,1))
}
class MaximizeDistanceToClosestPerson {
    fun maxDistToClosest(seats: IntArray): Int {
        var empty = 0 to 0
        var temp = 0 to 0
        var started = false
        seats.forEachIndexed { index, i ->
            if (i == 0) {
                if (!started) {
                    started = true
                    temp = index to index
                }
            } else {
                if (started) {
                    started = false
                    temp = temp.first to index - 1
                    if (empty.first == 0) {
                        if (empty.second - empty.first < (temp.second - temp.first)/2 + 1){
                            empty = temp
                        }
                    } else if (empty.second - empty.first < temp.second - temp.first) {
                        empty = temp
                    }
                }
            }
        }
        if (started){
            temp = temp.first to seats.size - 1
            if (empty.first != 0) {
                if ((empty.second - empty.first) / 2 <= temp.second - temp.first) {
                    empty = temp
                }
            } else {
                if (empty.second - empty.first <= temp.second - temp.first) {
                    empty = temp
                }
            }
        }

        return when {
            empty.first == 0 || empty.second == seats.size - 1 -> empty.second - empty.first + 1
            else -> (empty.second - empty.first) / 2 + 1
        }
    }
}