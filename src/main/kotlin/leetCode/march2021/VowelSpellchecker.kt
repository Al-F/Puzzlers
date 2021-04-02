package leetCode.march2021

fun main() {
    val f = VowelSpellchecker()
    f.spellchecker(
        arrayOf("KiTe", "kite", "hare", "Hare"),
        arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")
    )
}

class VowelSpellchecker {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val result = arrayListOf<String>()
        val fullMatch = wordlist.toHashSet()
        val capMatch = createDecap(wordlist)
        val dictionary = createDictionary(wordlist)
        queries.forEach { word ->
            if (fullMatch.contains(word)) {
                result.add(word)
                return@forEach
            }
            val decap = capMatch.getOrDefault(word.toLowerCase(), "")
            if (decap != "") {
                result.add(decap)
                return@forEach
            }
            result.add(dictionary
                .getOrDefault(word.replace(Regex("[aeiouAEIOU]"), "*").toLowerCase(), ""))
        }
        return result.toTypedArray()
    }

    private fun createDecap(wordlist: Array<String>): HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        wordlist.forEach { word ->
            hashMap.putIfAbsent(word.toLowerCase(), word)
        }
        return hashMap
    }

    private fun createDictionary(wordList: Array<String>): HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        wordList.forEach { word ->
            hashMap.putIfAbsent(word.replace(Regex("[aeiouAEIOU]"), "*").toLowerCase(), word)
        }
        return hashMap
    }
}