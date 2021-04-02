package leetCode.march2021

/**
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * Return a list of all universal words in A.  You can return the words in any order.
 */

fun main() {
    val f = WordSubset()
    f.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o"))
}

class WordSubset {
    fun wordSubsetsSlow(A: Array<String>, B: Array<String>): List<String> {
        val result = ArrayList<String>()
        for (a in A) {
            var universal = true
            for (b in B) {
                if (!universal) break
                val charAr = b.toCharArray()
                for (char in charAr) {
                    if (a.count { it == char } < b.count { it == char }) {
                        universal = false
                        break
                    }
                }
            }
            if (universal) result.add(a)
        }
        return result
    }

    // ab  a   aaa  fda  ewe
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
        val a_hashed = ArrayList<HashMap<Char, Int>>()
        val b_hashed = HashMap<Char, Int>()

        for (a in A) {
            val hashMap = HashMap<Char, Int>()
            for (char in a) {
                val value = hashMap.getOrPut(char, { 0 })
                hashMap[char] = value + 1
            }
            a_hashed.add(hashMap)
        }
        for (b in B) {
            val hashMap = HashMap<Char, Int>()
            for (char in b) {
                val value = hashMap.getOrPut(char, { 0 })
                hashMap[char] = value + 1
            }
            hashMap.forEach { (key, value) ->
                val stored = b_hashed.getOrDefault(key, 0)
                b_hashed[key] = Math.max(stored, value)
            }
        }

        val result = ArrayList<String>()
        a_hashed.forEachIndexed { index, a ->
            var universal = true
            b_hashed.forEach { (key, value) ->
                if (a.getOrDefault(key, 0) < value) {
                    universal = false
                    return@forEach
                }
            }
            if (universal) result.add(A[index])
        }
        return result
    }
}