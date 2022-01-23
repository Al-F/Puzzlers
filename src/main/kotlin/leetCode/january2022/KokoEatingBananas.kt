package leetCode.january2022

import java.util.*

fun main() {
    val f = KokoEatingBananas()
    f.minEatingSpeed(intArrayOf(3,6,7,11), 8)
}
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        if (h - piles.size == 0) return piles.maxOrNull() ?: 0

        val feeder = PriorityQueue<Int>(piles.size, Collections.reverseOrder())
        piles.forEach { feeder.add(it) }

        while (feeder.size < h){
            val max = feeder.poll()
            val min = feeder.minOrNull() ?: 0
            val newPileSize = if (max - min < max/2+1 && max - min != 0){
                min
            } else {
                max/2
            }
            feeder.add(newPileSize)
            feeder.add(max - newPileSize)
        }
        return feeder.poll()
    }
}