package leetCode.easy

import java.util.*

/**
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with a value in the range [low, high].
 */
class RangeSumBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        var sum = 0
        val stack = Stack<TreeNode>()
        stack.add(root)
        while (stack.isNotEmpty()){
            val cur = stack.pop()
            if (cur.left != null) stack.push(cur.left)
            if (cur.right != null) stack.push(cur.right)
            val value = cur.`val`
            if (value in low..high) sum+= value
        }
        return sum
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}