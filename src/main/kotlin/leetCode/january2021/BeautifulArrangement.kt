package leetCode.january2021

/**
 * Suppose you have n integers labeled 1 through n.
 * A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement
 * if for every i (1 <= i <= n), either of the following is true:
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 */
class BeautifulArrangement {
    //        var countArrangements = 1 //always can be at least one: simply in order
//        val array = mutableListOf<Int>()
//        for (i in 1..n) {
//            array.add(i)
//        }
//        array.any { it % array.indexOf(it) != 0 || array.indexOf(it) % it != 0}
//        return countArrangements

    var count = 0
    fun countArrangement(N: Int): Int {
        val visited = BooleanArray(N + 1)
        calculate(N, 1, visited)
        return count
    }

    fun calculate(N: Int, pos: Int, visited: BooleanArray) {
        if (pos > N) count++
        for (i in 1..N) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true
                calculate(N, pos + 1, visited)
                visited[i] = false
            }
        }
    }

}
