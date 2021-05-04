package leetCode.may2021

import java.util.*

fun main() {
    val f = CourseScheduleIII()
    f.scheduleCourse(
        arrayOf(
            intArrayOf(1, 200),
            intArrayOf(1299, 1300),
            intArrayOf(1000, 1250),
            intArrayOf(2000, 3200)
        )
    )
}

class CourseScheduleIII {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        val sorted = ArrayList<Pair<Int, Int>>(courses.size)
        courses.forEach { course ->
            sorted.add(course[0] to course[1])
        }

        sorted.sortBy { it.second }
        var curDuration = 0
        val prev = PriorityQueue<Int>(Collections.reverseOrder())
        sorted.forEachIndexed { index, pair ->
            if (curDuration + pair.first <= pair.second) {
                curDuration += pair.first
                prev.add(pair.first)
            } else {
                val pr = prev.peek() ?: 0
                if (pr > pair.first) {
                    curDuration = curDuration - pr + pair.first
                    prev.poll()
                    prev.add(pair.first)
                }
            }
        }
        return prev.size
    }
}
