package leetCode.april2021

fun main() {
    val f = RotateImage()
    f.rotate(arrayOf(intArrayOf(5,1,9,11), intArrayOf(2,4,8,10), intArrayOf(13,3,6,7), intArrayOf(15,14,12,16)))
}

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        var leftTopC = 0 to 0
        var rightTopC = 0 to matrix.size - 1
        var rightBotC = matrix.size - 1 to matrix.size - 1
        var leftBotC = matrix.size - 1 to 0
        while (leftTopC.x()<matrix.size/2) {
            var slide = 0
            while (rightTopC.y() - leftTopC.y() > slide) {
                var cur = matrix[leftTopC.x()][leftTopC.y() + slide]
                matrix[rightTopC.x() + slide][rightTopC.y()] = cur.also {
                    cur = matrix[rightTopC.x() + slide][rightTopC.y()]
                }

                matrix[rightBotC.x()][rightBotC.y() - slide] = cur.also {
                    cur = matrix[rightBotC.x()][rightBotC.y() - slide]
                }

                matrix[leftBotC.x() - slide][leftBotC.y()] = cur.also {
                    cur = matrix[leftBotC.x() - slide][leftBotC.y()]
                }

                matrix[leftTopC.x()][leftTopC.y() + slide] = cur
                slide++
            }
            leftTopC = leftTopC.x() + 1 to leftTopC.y() + 1
            rightTopC = rightTopC.x() + 1 to rightTopC.y() - 1
            rightBotC = rightBotC.x() - 1 to rightBotC.y() - 1
            leftBotC = leftBotC.x() - 1 to leftBotC.y() + 1
        }
    }
}

fun Pair<Int, Int>.x() = this.first
fun Pair<Int, Int>.y() = this.second