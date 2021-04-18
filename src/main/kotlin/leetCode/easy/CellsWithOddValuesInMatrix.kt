package leetCode.easy

fun main() {
    val f = CellsWithOddValuesInMatrix()
    f.oddCells(2, 3, arrayOf(intArrayOf(0,1), intArrayOf(1,1),intArrayOf(0,1), intArrayOf(1,1),intArrayOf(0,1), intArrayOf(1,1),intArrayOf(0,1), intArrayOf(1,1),intArrayOf(0,1), intArrayOf(1,1)))
}
class CellsWithOddValuesInMatrix {
    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        val rows = HashMap<Int, Int>()
        val column = HashMap<Int, Int>()

        indices.forEach { pair ->
            val rValue = rows.getOrPut(pair[0], { 0 })
            rows[pair[0]] = rValue + 1
            val cValue = column.getOrPut(pair[1], { 0 })
            column[pair[1]] = cValue + 1
        }
        var counter = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if ((rows.getOrDefault(i, 0) + column.getOrDefault(j, 0)) % 2 != 0) counter++

            }
        }
        return counter
    }
}