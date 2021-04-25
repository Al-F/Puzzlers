package leetCode.april2021

fun main() {
    val f = RotateImage()
    f.rotate(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))
}
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        var leftTopC = 0 to 0
        var rightTopC = 0 to matrix.size - 1
        var rightBotC = matrix.size - 1 to matrix.size - 1
        var leftBotC = matrix.size - 1 to 0
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
        System.out.println("")
    }
}

fun Pair<Int, Int>.x() = this.first
fun Pair<Int, Int>.y() = this.second