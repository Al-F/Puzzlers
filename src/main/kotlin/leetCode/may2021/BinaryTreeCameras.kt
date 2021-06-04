package leetCode.may2021

class BinaryTreeCameras {
    fun minCameraCover(root: TreeNode?): Int {
        if (root == null) return 0
        var counter = 0
        val deque = ArrayDeque<Pair<Int, TreeNode>>()
        deque.addLast(0 to root)
        while (deque.isNotEmpty()) {
            val cur = deque.removeFirst()
            if (cur.first % 2 != 0) counter++
            if (cur.second.left != null) deque.addLast(cur.first + 1 to cur.second.left!!)
            if (cur.second.right != null) deque.addLast(cur.first + 1 to cur.second.right!!)
        }
        return counter
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}