package leetCode.easy

class FlippingAnImage {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        image.forEach { row ->
            flipAndInvertRow(row)
        }
        return image
    }

    fun flipAndInvertRow(row: IntArray) {
        var end = row.size - 1
        var start = 0
        while (start <= end) {
            row[start] = if (row[end] ==1) {
                0.also { row[end] = if (row[start] == 1) 0 else 1 }
            } else {
                1.also { row[end] = if (row[start] == 1) 0 else 1 }
            }
            end--
            start++
        }
    }
}