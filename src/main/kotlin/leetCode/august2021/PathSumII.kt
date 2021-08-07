package leetCode.august2021

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val f = PathSumII()
    f.pathSum(
        PathSumII.TreeNode(
            1
        ).also {
            it.left = PathSumII.TreeNode(2).also {
                it.left = null
                it.right = null
            }
            it.right = PathSumII.TreeNode(3).also {
                PathSumII.TreeNode(4)
                PathSumII.TreeNode(5).also { it.right = PathSumII.TreeNode(6) }
            }
        },
        3
    )
}

class PathSumII {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        var result = mutableListOf<List<Int>>()
        val stack = Stack<Pair<TreeNode, List<Int>>>()
        stack.push(root to emptyList())
        while (stack.isNotEmpty()) {
            val (cur, path) = stack.pop()
            if (cur.left == null && cur.right == null) {
                val endGame = path.plus(cur.`val`)
                if (endGame.sum() == targetSum) {
                    result.add(endGame)
                }
            }
            if (cur.left != null) {
                stack.push(cur.left!! to path.plus(cur.`val`))
            }
            if (cur.right != null) {
                stack.push(cur.right!! to path.plus(cur.`val`))
            }
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}