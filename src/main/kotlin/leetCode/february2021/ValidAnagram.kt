package leetCode.february2021

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val hash = HashMap<Char, Int>()
        for (i in s.indices) {
            val cur = hash.getOrPut(s[i], { 0 })
            hash[s[i]] = cur + 1
        }
        for (i in t.indices){
            val cur = hash.getOrDefault(t[i], 0)
            if (cur <= 0) return false
            hash[t[i]] = cur - 1
        }
        if (hash.values.count { it > 0 } > 0) return false
        return true
    }
}