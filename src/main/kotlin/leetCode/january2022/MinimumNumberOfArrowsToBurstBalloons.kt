package leetCode.january2022

fun main() {
    val f = MinimumNumberOfArrowsToBurstBalloons()
    f.findMinArrowShots(arrayOf(intArrayOf(10,16), intArrayOf(2,8), intArrayOf(1,6), intArrayOf(7,12)))
}
class MinimumNumberOfArrowsToBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[0] }

        val arrows = HashSet<Pair<Int, Int>>()
        points.forEach { ballon ->
            val arrow = arrows.find { Math.max(ballon[0], it.first) <= Math.min(ballon[1], it.second) }
            if (arrow != null) {
                arrows.remove(arrow)
                arrows.add(Math.max(ballon[0], arrow.first) to Math.min(ballon[1], arrow.second))
            } else {
                arrows.add(ballon[0] to ballon[1])
            }
        }

        return arrows.size
    }
}