package leetCode.may2021

class PrefixAndSuffixSearch {
    class WordFilter(words: Array<String>) {
        val dict = HashMap<Pair<String, String>, Int>()

        init {
            words.forEachIndexed { index, string ->
                for (i in 1..10) {
                    for (j in 1..10) {
                        if (i <= string.length && j<=string.length) {
                            val prefix = string.subSequence(0, i).toString()
                            val suffix = string.substring(string.length - j)
                            dict[prefix to suffix] = index
                            System.out.print(string+ "; " + prefix + "; " + suffix)
                            System.out.println(";")
                        } else break
                    }
                }
            }
        }

        fun f(prefix: String, suffix: String): Int {
            val value = dict.getOrDefault(prefix to suffix, -1)
            return if (value == -1) { -1 } else { value }
        }
    }
}