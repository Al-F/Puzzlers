package leetCode.august2021

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val dict = HashMap<String, ArrayList<String>>()
        strs.forEach { str ->
            val key = str.toCharArray().sort().toString()
            val value = dict.getOrDefault(key, arrayListOf())
            value.add(str)
            dict[key] = value
        }
        return dict.values.toList()

    }
}