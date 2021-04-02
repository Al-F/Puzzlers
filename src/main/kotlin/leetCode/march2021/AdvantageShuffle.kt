package leetCode.march2021

/**
 * Given two arrays A and B of equal size,
 * the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 */
class AdvantageShuffle {
    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val a = A.sorted().toMutableList()
        val result = IntArray(A.size)
        var i = 0
        B.forEach { b ->
            val index = a.indexOfFirst { it > b }
            if (index != -1) {
                result[i++] = a[index]
                a.removeAt(index)
            } else {
                result[i++] = a[0]
                a.removeAt(0)
            }
        }
        return result
    }
}