package leetCode.april2021

object DetermineIfStringHalvesAreAlike {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        return s.subSequence(0, s.length / 2).count { it in vowels } == s.subSequence(s.length / 2, s.length)
            .count { it in vowels }

    }
}