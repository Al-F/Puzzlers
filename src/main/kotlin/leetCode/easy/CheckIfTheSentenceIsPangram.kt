package leetCode.easy

class CheckIfTheSentenceIsPangram {
    fun checkIfPangram(sentence: String): Boolean {
        val chars = sentence.toCharArray()
        chars.sort()
        if (chars.last()!='z'||chars.first()!='a')return false
        for (i in 1 until chars.size) {
            if (chars[i] - chars[i-1] > 1) return false
        }
        return true
    }

    fun checkIfPangram2(sentence: String): Boolean{
        val allLetters = Array<Int>(26) { 0 }
        sentence.forEach {
            allLetters[it - 'a']++
        }
        allLetters.forEach {
            if (it<1) return false
        }
        return true
    }
}