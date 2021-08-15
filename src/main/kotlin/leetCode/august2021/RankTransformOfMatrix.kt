package leetCode.august2021

fun main() {
    val f = RankTransformOfMatrix()
    f.matrixRankTransform(
        arrayOf(
            //[[-37,-50,-3,44],[-37,46,13,-32],[47,-42,-3,-40],[-17,-22,-39,24]]
            intArrayOf(-37, -50, -3, 44),
            intArrayOf(-37, 46, 13, -32),
            intArrayOf(47, -42, -3, -40),
            intArrayOf(-17, -22, -39, 24)
        )
    )
}

class RankTransformOfMatrix {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val dict = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                val list = dict.getOrPut(matrix[i][j]) { arrayListOf() }
                list.add(i to j)
                dict[matrix[i][j]] = list
            }
        }
        val result = Array(matrix.size) { IntArray(matrix[0].size) }
        val row = HashMap<Int, Pair<Int, Int>>()
        val column = HashMap<Int, Pair<Int, Int>>()
        dict.keys.sorted().forEach { key ->
            val indexes = dict[key]
            var dirty: Boolean
            do {
                dirty = false
                indexes?.forEach { indPair ->
                    val (i, j) = indPair
                    val (rowCurRank, rowCurVal) = row.getOrDefault(i, 0 to Int.MIN_VALUE)
                    val (colCurRank, colCurVal) = column.getOrDefault(j, 0 to Int.MIN_VALUE)
                    var tmp = when {
                        rowCurRank == colCurRank -> {
                            if (rowCurVal < key || colCurVal < key) rowCurRank + 1 else rowCurRank
                        }
                        rowCurRank > colCurRank -> {
                            if (rowCurVal == key) rowCurRank else rowCurRank + 1
                        }
                        else -> {
                            if (colCurVal == key) colCurRank else colCurRank + 1
                        }
                    }
                    if (result[i][j] != tmp){
                        result[i][j] = tmp
                        dirty = true
                        row[i] = result[i][j] to key
                        column[j] = result[i][j] to key
                    }
                }
            } while (dirty && indexes?.size!! > 1)
        }
//        dict.keys.sorted().forEach { key ->
//            val indexes = dict[key]
//            var resRank = 0
//            indexes?.forEach { indPair ->
//                val (i, j) = indPair
//                val (rowCurRank, rowCurVal) = row.getOrDefault(i, 0 to Int.MIN_VALUE)
//                val (colCurRank, colCurVal) = column.getOrDefault(j, 0 to Int.MIN_VALUE)
//                resRank = if (rowCurRank > colCurRank) {
//                    Math.max(if (rowCurVal == key) rowCurRank else rowCurRank + 1, resRank)
//                } else {
//                    Math.max(if (colCurVal == key) colCurRank else colCurRank + 1, resRank)
//                }
//            }
//            indexes?.forEach { indPair ->
//                val (i, j) = indPair
//                result[i][j] = resRank
//                row[i] = result[i][j] to key
//                column[j] = result[i][j] to key
//            }
//        }
        return result
    }

}