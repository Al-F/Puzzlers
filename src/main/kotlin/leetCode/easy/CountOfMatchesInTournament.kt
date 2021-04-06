package leetCode.easy

class CountOfMatchesInTournament {
    fun numberOfMatches(n: Int): Int {
        var residue = n
        var matches = 0
        while (residue > 1) {
            matches += residue / 2
            residue = if (residue % 2 == 0) residue / 2 else residue / 2 + 1
        }
        return matches
    }
}