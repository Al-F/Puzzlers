package leetCode.april2021

fun main() {
    val f = BeautifulArrangementII()
    f.constructArray(10, 3)
}

class BeautifulArrangementII {
    fun constructArray(n: Int, k: Int): IntArray {
        var _k = k
        val res = IntArray(n) { it + 1 }
        if (k == 1) return res
        var index = 1
        while (_k != 0) {
            res[index] = res[index - 1] + _k
            _k = if (_k < 0) -(_k + 1) else -(_k - 1)
            index++
        }
        return res
    }
}