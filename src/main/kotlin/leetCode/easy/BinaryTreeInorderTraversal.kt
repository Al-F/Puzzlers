package leetCode.easy

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = ArrayList<Int>()
        traverse(root, result)
        return result
    }

    //1
       //2
    //3
    fun traverse(root: TreeNode, list: ArrayList<Int>) {
        if (root.left != null) traverse(root.left!!, list)
        list.add(root.`val`)
        if (root.right != null) traverse(root.right!!, list)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}