package leetCode.easy

class BinaryTreePostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = arrayListOf<Int>()
        visitSubTree(root, result)
        return result
    }

    private fun visitSubTree(root: TreeNode?, result: ArrayList<Int>) {
        if (root == null) return
        visitSubTree(root.left, result)
        visitSubTree(root.right, result)
        result.add(root.`val`)
    }

    fun postorderTraversalRec(root: TreeNode?): List<Int> {
        val listNodes = mutableListOf<Int>()

        root?.let{
            listNodes.addAll(postorderTraversalRec(root.left))
            listNodes.addAll(postorderTraversalRec(root.right))
            listNodes.add(root.`val`)
        }

        return listNodes
    }
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}