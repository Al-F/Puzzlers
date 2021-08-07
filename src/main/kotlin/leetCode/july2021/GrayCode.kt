package leetCode.july2021

class GrayCode {
    fun grayCode(n: Int): List<Int> {
        val amount = Math.pow(2.0, n.toDouble()).toInt()
        val arr = ArrayList<String>()
        arr.add("0")
        arr.add("1")
        var mirror = ArrayList<String>()

        while (arr.size != amount) {
            for (i in arr.size - 1 downTo 0) {
                mirror.add(arr[i])
                arr[i] = "0" + arr[i]
            }
            for (j in 0 until mirror.size) {
                mirror[j] = "1" + mirror[j]
            }
            arr += mirror
            mirror = arrayListOf()
        }
        return arr.map { it.toInt(2) }
    }
}