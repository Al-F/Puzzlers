package leetCode.medium

import java.util.*

class MinimumTimeDifference {
    fun findMinDifference(timePoints: List<String>): Int {
        val priorityQueue = PriorityQueue<Int>()
        timePoints.forEach {
            val minutes = it.substringBefore(":").toInt() * 60 + it.substringAfter(":").toInt()
            if (minutes == 0) {
                priorityQueue.add(minutes)
                priorityQueue.add(1440)
            } else {
                priorityQueue.add(minutes)
            }
        }
        var prev = priorityQueue.poll()
        val first = prev
        var dif = Int.MAX_VALUE
        var cur: Int? = null
        while (priorityQueue.isNotEmpty()) {
            cur = priorityQueue.poll()
            dif = Math.min(dif, cur - prev)
            prev = cur
        }
        if (cur != null) {
            dif = Math.min(dif, first + 1440 - cur)
        }
        return dif
    }
}