package leetCode.may2021

class MaximumProductOfWordLengths {
    fun maxProduct(words: Array<String>): Int {
        var result = 0
        val wordsHash = HashMap<String, HashSet<Char>>()
        words.forEach{
            wordsHash.putIfAbsent(it, it.toCharArray().distinct().toHashSet())
        }
        words.forEachIndexed { index, s ->
            val first = wordsHash[s]
            for (j in index+1 until words.size){
                val second = wordsHash[words[j]]
                val intersection = first!!.intersect(second!!)
                if (intersection.isEmpty()){
                    result = Math.max(result, s.length * words[j].length)
                }
            }
        }
        return result
    }
}