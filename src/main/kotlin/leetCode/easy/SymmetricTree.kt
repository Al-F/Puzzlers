package leetCode.easy

import java.util.*

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        if (root.left == null && root.right == null) return true
        val left = Stack<TreeNode>()
        val right = Stack<TreeNode>()
        if (root.left?.`val` == root.right?.`val`){
            left.push(root.left)
            right.push(root.right)
        } else return false
        while (left.isNotEmpty()){
            val curL = left.pop()
            val curR = right.pop()
            if (curL.left?.`val` == curR.right?.`val`) {
                if (curL.left != null) left.push(curL.left)
                if (curR.right != null) right.push(curR.right)
            } else return false
            if (curL.right?.`val` == curR.left?.`val`) {
                if (curL.right != null) left.push(curL.right)
                if (curR.left != null) right.push(curR.left)
            } else return false
        }
        return true
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}