package leetCode.easy

class UniqueMorseCodeWords {
    val dict = HashMap<Char, String>()
    init {
        dict.put('a', ".-")
        dict.put('b', "-...")
        dict.put('c', "-.-.")
        dict.put('d', "-..")
        dict.put('e', ".")
        dict.put('f', "..-.")
        dict.put('g', "--.")
        dict.put('h', "....")
        dict.put('i', "..")
        dict.put('j', ".---")
        dict.put('k', "-.-")
        dict.put('l', ".-..")
        dict.put('m', "--")
        dict.put('n', "-.")
        dict.put('o', "---")
        dict.put('p', ".--.")
        dict.put('q', "--.-")
        dict.put('r', ".-.")
        dict.put('s', "...")
        dict.put('t', "-")
        dict.put('u', "..-")
        dict.put('v', "...-")
        dict.put('w', ".--")
        dict.put('x', "-..-")
        dict.put('y', "-.--")
        dict.put('z', "--..")

    }
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val set = HashSet<String>()
        words.forEach {  word ->
            val str = StringBuilder()
            word.forEach {
                str.append(dict[it])
            }
            set.add(str.toString())
        }
        return set.count()
    }
}