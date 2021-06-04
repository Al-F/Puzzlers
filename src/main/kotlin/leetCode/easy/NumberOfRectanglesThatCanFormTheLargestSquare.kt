package leetCode.easy

class NumberOfRectanglesThatCanFormTheLargestSquare {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        var max = 0
        var counter = 0

        rectangles.forEach {
            val first = it[0]
            val second = it[1]
            val square = Math.min(first, second)
            if (max < square) {
                max = square
                counter = 1
            } else if (max == square) {
                counter++
            }
        }
        return counter
    }
}