package leetCode.easy

class SortingTheSentence {
    fun sortSentence(s: String): String {
        val list = s.split(" ")
        val array = Array(9) { "" }
        list.forEach {
            array[it.substring(it.length - 1).toInt() - 1] = it.substring(0, it.length - 1)
        }
        return array.filter { it.isNotEmpty() }.joinToString(" ")
    }
}