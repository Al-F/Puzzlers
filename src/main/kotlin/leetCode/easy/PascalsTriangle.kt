package leetCode.easy

class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf(listOf(1))
        if (numRows == 1) return result

        val cur = 0
        while (cur < numRows) {
            val line = result[cur]
            val newLine = Array(cur + 2) { 1 }
            for (i in 0 until line.size - 1) {
                newLine[i + 1] = line[i] + line[i + 1]
            }
            result.add(newLine.toList())
        }
        return result
    }
}