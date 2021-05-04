package leetCode.april2021

import java.util.*
import kotlin.math.log
import kotlin.math.roundToInt

fun main() {
    val f = FurthestBuildingYouCanReach()
    f.furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1)
}

class FurthestBuildingYouCanReach {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        var bricksLeft = bricks
        var laddersLeft = ladders
        val priority = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 1 until heights.size) {
            val need = Math.max(heights[i] - heights[i - 1], 0)
            bricksLeft -= need
            priority.add(need)
            while (bricksLeft < 0) {
                if (laddersLeft > 0) {
                    bricksLeft += priority.poll()
                    laddersLeft--
                } else {
                    return i - 1
                }
            }
        }
        return heights.size - 1
    }
}