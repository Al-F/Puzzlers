package leetCode.easy

import java.util.*

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        var max = 0
        if (root == null) return 0
        val stack = Stack<Pair<TreeNode, Int>>()
        stack.push(root to 1)
        while (stack.isNotEmpty()) {
            val (cur, level) = stack.pop()
            max = Math.max(max, level)
            if (cur.left != null) stack.push(cur.left!! to level + 1)
            if (cur.right != null) stack.push(cur.right!! to level + 1)
        }
        return max
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}