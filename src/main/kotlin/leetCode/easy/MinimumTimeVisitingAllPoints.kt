package leetCode.easy

class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        if (points.size < 2) return 0
        var time = 0
        for (i in 1 until points.size) {
            time += Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1]))
        }
        return time
    }
}