package leetCode.june2021

fun main() {
    var f = MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts()
    f.maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1, 3))
}

const val mod = 1000000007
class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        var arH = 0
        var prH = 0
        horizontalCuts.sort()
        for (i in horizontalCuts.indices) {
            arH = Math.max(arH, horizontalCuts[i] - prH)
            prH = horizontalCuts[i]
        }
        arH = Math.max(arH, h - prH)

        var arV = 0
        var prV = 0
        verticalCuts.sort()
        for (i in verticalCuts.indices) {
            arV = Math.max(arV, verticalCuts[i] - prV)
            prV = verticalCuts[i]
        }
        arV = Math.max(arV, w - prV)

        return ((arH.toLong() * arV.toLong()) % mod).toInt()
    }
}