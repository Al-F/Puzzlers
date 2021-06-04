package leetCode.may2021

fun main() {
    val f = MaximumPointsYouCanObtainFromCards()
    f.maxScore(intArrayOf(100,40,17,9,73,75), 3)
}
class MaximumPointsYouCanObtainFromCards {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        if (k >= cardPoints.size) return cardPoints.sum()
        var max = 0
        var sumA = 0
        for (i in 0 until k) {
            sumA += cardPoints[i]
        }
        max = sumA

        for (j in 1 .. k) {
            sumA -= cardPoints[k-j]
            sumA += cardPoints[cardPoints.size - j]
            max = Math.max(sumA, max)
        }
        return max
    }
}