package leetCode.may2021

import java.util.*

class FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        var current = root
        if (root.right != null) stack.push(root.right)
        if (root.left != null) stack.push(root.left)
        while (stack.isNotEmpty()){
            val elem = stack.pop()
            current!!.right = elem
            current.left = null
            current = current.right

            if (elem.right != null) stack.push(elem.right)
            if (elem.left != null) stack.push(elem.left)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}