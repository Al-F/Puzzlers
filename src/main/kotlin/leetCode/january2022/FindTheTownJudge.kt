package leetCode.january2022

fun main() {
    val f = FindTheTownJudge()
    //4
    //[[1,2],[1,3],[2,1],[2,3],[1,4],[4,3],[4,1]]
    f.findJudge(
        4, arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 1),
            intArrayOf(2, 3), intArrayOf(1, 4), intArrayOf(4, 3), intArrayOf(4, 1)
        )
    )
}

class FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1 && trust.isEmpty()) return 1
        val whom = HashMap<Int, ArrayList<Int>>()
        val who = Array(n) { true }
        trust.forEach {
            val tr = whom.getOrPut(it[1], { arrayListOf() })
            tr.add(it[0])
            whom[it[1]] = tr

            who[it[0]-1] = false
        }

        val potentialJudge = arrayListOf<Int>()
        whom.entries.forEach {
            if (it.value.size == n - 1) {
                potentialJudge.add(it.key)
            }
        }

        var judge = -1
        potentialJudge.forEach {
           if(who[it-1]) judge = it
        }

        return judge
    }
}