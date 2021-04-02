package leetCode.march2021

import java.util.*
import kotlin.collections.ArrayDeque


class StampingTheSequence {
    fun movesToStampTLE(stamp: String, target: String): IntArray {
        val m = stamp.length
        val n = target.length
        val queue = ArrayDeque<Int>()
        val done = BooleanArray(n)
        val ans = Stack<Int>()
        val a = mutableListOf<Node?>()
        for (i in 0..n - m) {
            // For each window [i, i+M), A[i] will contain
            // info on what needs to change before we can
            // reverse stamp at this window.
            val made = HashSet<Int>()
            val todo = HashSet<Int>()
            for (j in 0 until m) {
                if (target[i + j] == stamp[j]) made.add(i + j) else todo.add(i + j)
            }
            a.add(Node(made, todo))

            // If we can reverse stamp at i immediately,
            // enqueue letters from this window.
            if (todo.isEmpty()) {
                ans.push(i)
                for (j in i until i + m) if (!done[j]) {
                    queue.add(j)
                    done[j] = true
                }
            }
        }

        // For each enqueued letter (position),
        while (!queue.isEmpty()) {
            val i = queue.first()

            // For each window that is potentially affected,
            // j: start of window
            for (j in Math.max(0, i - m + 1)..Math.min(n - m, i)) {
                if (a[j]!!.todo.contains(i)) {  // This window is affected
                    a[j]!!.todo.remove(i)
                    if (a[j]!!.todo.isEmpty()) {
                        ans.push(j)
                        for (m in a[j]!!.made) if (!done[m]) {
                            queue.add(m)
                            done[m] = true
                        }
                    }
                }
            }
        }
        for (b in done) if (!b) return IntArray(0)
        val ret = IntArray(ans.size)
        var t = 0
        while (!ans.isEmpty()) ret[t++] = ans.pop()!!
        return ret
    }

    fun movesToStamp(stamp: String, target: String): IntArray? {
        val reverseIndexList: MutableList<Int> = ArrayList()
        val len = target.length
        val curr = target.toCharArray()
        val targetStr = CharArray(len)
        Arrays.fill(targetStr, '*')
        while (!curr.contentEquals(targetStr)) {
            val stampIndex = fetchStampIndex(curr, stamp)
            println(stampIndex)
            if (stampIndex < 0) {
                return IntArray(0)
            } else {
                update(curr, stampIndex, stamp)
            }
            reverseIndexList.add(stampIndex)
        }
        val ans = IntArray(reverseIndexList.size)
        for (i in reverseIndexList.indices) {
            ans[i] = reverseIndexList[reverseIndexList.size - 1 - i]
        }
        return ans
    }

    private fun fetchStampIndex(curr: CharArray, stamp: String): Int {
        println(String(curr))
        for (i in 0..curr.size - stamp.length) {
            var j = 0
            var s = i
            var isNonStarChar = false
            while (j < stamp.length && s < curr.size && (curr[s] == '*' || curr[s] == stamp[j])) {
                if (curr[s] != '*') {
                    isNonStarChar = true /// ******** , ab
                }
                s++
                j++
            }
            if (j == stamp.length && isNonStarChar) {
                return i
            }
        }
        return -1
    }

    private fun update(curr: CharArray, i: Int, stamp: String) {
        for (j in stamp.indices) {
            curr[j + i] = '*'
        }
    }
    internal class Node(var made: HashSet<Int>, var todo: MutableSet<Int>)
}