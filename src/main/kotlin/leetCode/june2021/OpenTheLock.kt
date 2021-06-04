package leetCode.june2021

import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet

fun main() {
    val f = OpenTheLock()
    f.openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202")
}

class OpenTheLock {
    val deadendsList = HashSet<Node>()
    val visited = HashSet<Node>()
    val stack = ArrayDeque<Pair<Node, Int>>()
    private lateinit var targetNode: Node

    fun openLock(deadends: Array<String>, target: String): Int {
        if (deadends.contains("0000")) return -1
        if (target == "0000") return 0
        deadends.forEach {
            deadendsList.add(
                Node(
                    Character.getNumericValue(it[0]),
                    Character.getNumericValue(it[1]),
                    Character.getNumericValue(it[2]),
                    Character.getNumericValue(it[3])
                )
            )
        }
        targetNode = Node(
            Character.getNumericValue(target[0]),
            Character.getNumericValue(target[1]),
            Character.getNumericValue(target[2]),
            Character.getNumericValue(target[3])
        )

        val startNode = Node(0, 0, 0, 0)
        visited.add(startNode)
        stack.addLast(startNode to 0)

        while (stack.isNotEmpty()) {
            val poped = stack.removeFirst()
            val maybeAnswer = generate(poped.first, poped.second)
            if (maybeAnswer != null) {
                System.out.println(maybeAnswer)
                return maybeAnswer
            }
        }

        return -1
    }

    fun generate(cur: Node, level: Int): Int? {
        val f1 = cur.copy(f = if (cur.f < 9) cur.f + 1 else 0)
        val f1r = checkOrPush(f1, level)
        if (f1r != null) return f1r

        val s1 = cur.copy(s = if (cur.s < 9) cur.s + 1 else 0)
        val s1r = checkOrPush(s1, level)
        if (s1r != null) return s1r

        val t1 = cur.copy(t = if (cur.t < 9) cur.t + 1 else 0)
        val t1r = checkOrPush(t1, level)
        if (t1r != null) return t1r

        val fo1 = cur.copy(fo = if (cur.fo < 9) cur.fo + 1 else 0)
        val fo1r = checkOrPush(fo1, level)
        if (fo1r != null) return fo1r

        val f2 = cur.copy(f = if (cur.f > 0) cur.f - 1 else 9)
        val f2r = checkOrPush(f2, level)
        if (f2r != null) return f2r

        val s2 = cur.copy(s = if (cur.s > 0) cur.s - 1 else 9)
        val s2r = checkOrPush(s2, level)
        if (s2r != null) return s2r

        val t2 = cur.copy(t = if (cur.t > 0) cur.t - 1 else 9)
        val t2r = checkOrPush(t2, level)
        if (t2r != null) return t2r

        val fo2 = cur.copy(fo = if (cur.fo > 0) cur.fo - 1 else 9)
        val fo2r = checkOrPush(fo2, level)
        if (fo2r != null) return fo2r

        return null
    }

    fun checkOrPush(cur: Node, level: Int): Int? {
        if (!visited.contains(cur) && !deadendsList.contains(cur)) {
            if (targetNode == cur) {
                return level + 1
            } else {
                stack.addLast(cur to level + 1)
                visited.add(cur)
            }
        }
        return null
    }

    data class Node(val f: Int, val s: Int, val t: Int, val fo: Int)
}

