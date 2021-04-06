package leetCode.recursion

import java.util.*

class SearchInBinarySearchTree {
    fun searchBSTRec(root: TreeNode?, `val`: Int): TreeNode? {
        System.out.println(root?.`val`)
        if (root?.`val` == `val`) return root
        var left: TreeNode? = null
        var right: TreeNode? = null
        if (root?.right != null) {
            right = searchBSTRec(root.right, `val`)
        }
        if (root?.left != null) {
            left = searchBSTRec(root.left, `val`)
        }
        return left ?: right
    }

    fun searchBSTNoRec(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val current = stack.pop()
            if (current.`val` == `val`) return current
            if (current.left != null) stack.push(current.left)
            if (current.right != null) stack.push(current.right)
        }
        return null
    }

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` == `val`) return root

        return if (`val` > root.`val`)
            searchBST(root.right, `val`)
        else
            searchBST(root.left, `val`)
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}