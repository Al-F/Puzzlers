package leetCode.january2022

class InsertIntoABinarySearchTree {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)
        if (`val` < root.`val`) {
            val node = insertIntoBST(root.left, `val`)
            root.left = node
        } else {
            val node =  insertIntoBST(root.right, `val`)
            root.right = node
        }
        return root
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}