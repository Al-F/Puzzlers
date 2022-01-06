package leetCode.easy

class MinimumDepthOfBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun minDepth(root: TreeNode?): Int {
        val deque = ArrayDeque<Pair<TreeNode, Int>>()
        if (root == null) return 0

        deque.addLast(root to 1)
        while (deque.size != 0){
            val current = deque.removeFirst()
            val node = current.first
            if (node.left == null && node.right == null) return current.second
            if (node.left != null) deque.addLast(node.left!! to current.second +1)
            if (node.right != null) deque.addLast(node.right!! to current.second +1)
        }
        return 0
    }
}