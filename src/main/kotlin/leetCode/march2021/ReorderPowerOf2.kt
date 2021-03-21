package leetCode.march2021

fun main() {
    val f = ReorderPowerOf2()
    f.reorderedPowerOf2(268341)
}

/**
 * Starting with a positive integer N, we reorder the digits in any order (including the original order)
 * such that the leading digit is not zero.
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 */
class ReorderPowerOf2 {
    val hashMap = HashMap<Int, Array<ArrayList<Int>>>()

    init {
        hashMap[10] = arrayOf(
            arrayListOf(8, 5, 8, 9, 9, 3, 4, 5, 9, 2),
            arrayListOf(4, 2, 9, 4, 9, 6, 7, 2, 9, 6),
            arrayListOf(2, 1, 4, 7, 4, 8, 3, 6, 4, 8),
            arrayListOf(1, 0, 7, 3, 7, 4, 1, 8, 2, 4)
        )
        hashMap[9] = arrayOf(
            arrayListOf(5, 3, 6, 8, 7, 0, 9, 1, 2),
            arrayListOf(2, 6, 8, 4, 3, 5, 4, 5, 6),
            arrayListOf(1, 3, 4, 2, 1, 7, 7, 2, 8)
        )
        hashMap[8] = arrayOf(
            arrayListOf(6, 7, 1, 0, 8, 8, 6, 4),
            arrayListOf(3, 3, 5, 5, 4, 4, 3, 2),
            arrayListOf(1, 6, 7, 7, 7, 2, 1, 6)
        )
        hashMap[7] = arrayOf(
            arrayListOf(8, 3, 8, 8, 6, 0, 8),
            arrayListOf(4, 1, 9, 4, 3, 0, 4),
            arrayListOf(2, 0, 9, 7, 1, 5, 2),
            arrayListOf(1, 0, 4, 8, 5, 7, 6)
        )
        hashMap[6] = arrayOf(
            arrayListOf(5, 2, 4, 2, 8, 8), arrayListOf(2, 6, 2, 1, 4, 4), arrayListOf(1, 3, 1, 0, 7, 2)
        )
        hashMap[5] = arrayOf(
            arrayListOf(6, 5, 5, 3, 6), arrayListOf(3, 2, 7, 6, 8), arrayListOf(1, 6, 3, 8, 4)
        )
        hashMap[4] = arrayOf(
            arrayListOf(8, 1, 9, 2), arrayListOf(4, 0, 9, 6), arrayListOf(2, 0, 4, 8), arrayListOf(1, 0, 2, 4)
        )
        hashMap[3] = arrayOf(
            arrayListOf(5, 1, 2), arrayListOf(2, 5, 6), arrayListOf(1, 2, 8)
        )
        hashMap[2] = arrayOf(
            arrayListOf(6, 4), arrayListOf(3, 2), arrayListOf(1, 6)
        )
        hashMap[1] = arrayOf(
            arrayListOf(8), arrayListOf(4), arrayListOf(2), arrayListOf(1)
        )
    }

    fun reorderedPowerOf2(N: Int): Boolean {
        var n = N
        val nArr = arrayListOf<Int>()
        while (n != 0) {
            nArr.add(n % 10)
            n /= 10
        }
        hashMap[nArr.size]?.forEach { powOfTwo ->
            if (nArr.containsAll(powOfTwo) && powOfTwo.containsAll(nArr)) return true
        }
        return false
    }
}