package leetCode.august2021

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val dictT = HashMap<Char, Int>()
        t.forEach {
            val value = dictT.getOrDefault(it, 0)
            dictT[it] = value - 1
        }

        var result = Int.MAX_VALUE
        var minStart = 0
        var start = 0

        s.forEachIndexed { index, c ->
            if (dictT.containsKey(c)) {
                val value = dictT.get(c)
                dictT[c] = value!! + 1
                if (dictT.values.all { it >= 0 }) {
                    while (!dictT.containsKey(s[start]) || dictT[s[start]]!! > 0){
                        if (dictT.containsKey(s[start])){
                            val value = dictT[s[start]]
                            dictT[s[start]] = value!! - 1
                        }
                        start++
                    }
                    if (result > index - start +1 ){
                        result = index - start + 1
                        minStart = start
                    }
                }
            }
        }
        if (result == Int.MAX_VALUE){
            return ""
        }

        return s.substring(minStart, minStart + result)
    }
}