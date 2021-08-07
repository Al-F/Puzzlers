package leetCode.july2021

class ReshapeMatrix {

    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (r * c != mat.size * mat[0].size) return mat
        var row = 0
        var column = 0
        val result = Array(r){ IntArray(c) }
        for (i in 0 until result.size){
            for (j in 0 until result[0].size){
                if (row>=mat.size){
                    return mat
                }
                if (column>=mat[0].size){
                    row++
                    column = 0
                }
                result[i][j] = mat[row][column]
                column++
            }
        }
        return result
    }
}