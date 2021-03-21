package leetCode.recursion

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */
fun main() {
    val f = PascalsTriangleII()
    f.getRow(3)
}

class PascalsTriangleII {
    val hashMap = HashMap<Pair<Int, Int>, Int>()
    fun getRow(rowIndex: Int): List<Int> {
        val result = ArrayList<Int>(rowIndex + 1)
        var current = 0
        while (current <= rowIndex){
            result.add(getNumber(rowIndex, current))
            current++
        }
        return result
    }

    private fun getNumber(row: Int, column: Int): Int {
        if (column == 0 || column == row) return 1
        var first = hashMap.getOrDefault(row - 1 to column - 1, -1)
        var second = hashMap.getOrDefault(row - 1 to column, -1)
        if (first == -1) {
            first = getNumber(row - 1, column - 1)
            hashMap[row - 1 to column - 1] = first
        }
        if (second == -1) {
            second = getNumber(row - 1, column)
            hashMap[row - 1 to column] = second
        }
        return first + second
    }

    fun getRowOther(rowIndex: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0..rowIndex) {
            list.add(1)
            for(j in i - 1 downTo 1) {
                if (j >= 1) {
                    list[j] = list[j-1] + list[j]
                }
            }
        }

        return list
    }
}