package leetCode.january2022

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val cur = StringBuilder()
        val dict = HashMap<String, Char>()
        val taken = HashSet<Char>()
        var indP = 0
        s.forEach {
            if(it == ' '){
                if (indP == pattern.length) return false
                val word = cur.toString()
                cur.clear()
                val value = dict.getOrPut(word, {'-'})
                if (value == '-'){
                    if (taken.contains(pattern[indP])){
                        return false
                    } else {
                        dict[word] = pattern[indP]
                        taken.add(pattern[indP])
                        indP++
                    }
                } else {
                    if (value == pattern[indP]){
                        indP++
                    } else {
                        return false
                    }
                }
            }else{
                cur.append(it)
            }
        }
        val word = cur.toString()
        val value = dict.getOrPut(word, {'-'})
        if (indP == pattern.length) return false
        if (value == '-'){
            if (taken.contains(pattern[indP])){
                return false
            } else {
                dict[word] = pattern[indP]
                taken.add(pattern[indP])
                indP++
            }
        } else {
            if (value == pattern[indP]){
                indP++
            } else {
                return false
            }
        }
        if (indP < pattern.length) return false
        return true
    }
}