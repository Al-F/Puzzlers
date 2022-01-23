package leetCode.january2022

fun main() {
    val f = StoneGameIV()
    f.winnerSquareGame(15)
}
class StoneGameIV {
    fun winnerSquareGame(n: Int): Boolean {
        val dict = HashMap<Int, Boolean>()
        dict[0] = false
        dict[1] = true
        return dfs(dict, n)
    }

    private fun dfs(dict: HashMap<Int, Boolean>, remain: Int) : Boolean {
        if (dict.contains(remain)) return dict[remain] ?: false
        val end = Math.sqrt(remain.toDouble())
        for (i in 1 .. end.toInt()){
            if (!dfs(dict, remain - i*i)){
                dict[remain] = true
                return true
            }
        }
        dict[remain] = false
        return false
    }
}