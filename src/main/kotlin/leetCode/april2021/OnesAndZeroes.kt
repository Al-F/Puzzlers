package leetCode.april2021

fun main() {
    val f = OnesAndZeroes()
    f.findMaxForm(arrayOf("10", "0", "1"), 1, 1)
}

class OnesAndZeroes {

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        strs.sortBy { it.length }

        val matrix = Array(strs[strs.size - 1].length + 1) { Array(strs[strs.size - 1].length + 1) { 0 } }

        strs.forEach { string ->
            if (string.length > m + n) return@forEach

            var zInner = 0
            var oInner = 0
            string.forEach {
                when (it) {
                    '0' -> zInner++
                    '1' -> oInner++
                }
                if (zInner > m || oInner > n) return@forEach
            }

            if (zInner <= m && oInner <= n) {
                val value = matrix[zInner][oInner]
                matrix[zInner][oInner] = value + 1
            }
        }

        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(0 to 0)
        var zeroLeft = m
        var oneLeft = n
        var counter = 0
        while (stack.isNotEmpty()) {
            val current = stack.removeFirst()
            var valueInMatrix = matrix[current.first][current.second]
            while (valueInMatrix > 0) {
                if (current.first <= zeroLeft && current.second <= oneLeft) {
                    counter++
                    zeroLeft -= current.first
                    oneLeft -= current.second
                }
                valueInMatrix--
            }
            matrix[current.first][current.second] = -1

            if (current.first < strs[strs.size - 1].length
                && matrix[current.first + 1][current.second] != -1
            ) {
                stack.addLast(current.first + 1 to current.second)
            }
            if (current.second < strs[strs.size - 1].length
                && matrix[current.first][current.second + 1] != -1
            ) {
                stack.addLast(current.first to current.second + 1)
            }
            if (current.first < strs[strs.size - 1].length
                && current.second < strs[strs.size - 1].length
                && matrix[current.first + 1][current.second + 1] != -1
            ) {
                stack.addLast(current.first + 1 to current.second + 1)
            }
        }
        return counter
    }
}