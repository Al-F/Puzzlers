package leetCode.january2022

fun main() {
    val f = PalindromePartitioning()
    f.partition("aabaccaaada")
}
class PalindromePartitioning {
    val dict = HashMap<Int, ArrayList<String>>()

    fun partition(s: String): List<List<String>> {
        for (index in s.indices){
            checkStringAndWriteToDict(index, index, s)
            if (index+1<s.length){
                checkStringAndWriteToDict(index,index+1, s)
            }
        }

        val result = arrayListOf<List<String>>()
        buildListOfPalindromes(result, 0, arrayListOf())
        return result
    }

    private fun checkStringAndWriteToDict(start: Int, end: Int, s: String) {
        var startTemp = start
        var endTemp = end
        while (startTemp>=0 && endTemp<s.length) {
            if (s[startTemp] == s[endTemp]) {
                val substrings = dict.getOrPut(startTemp, { arrayListOf() })
                substrings.add(s.substring(startTemp..endTemp))
                dict[startTemp] = substrings
            } else break
            startTemp--
            endTemp++
        }
    }

    private fun buildListOfPalindromes(result: ArrayList<List<String>>, index: Int, current: ArrayList<String>){
        if (!dict.containsKey(index)){
            result.add(current.toList())
            return
        }
        dict[index]?.forEach {
            current.add(it)
            buildListOfPalindromes(result, index+it.length, current)
            current.removeAt(current.size-1)
        }
    }
}