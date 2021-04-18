package leetCode.april2021

class DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.addLast(root to 0)
        var sum = root.`val`
        var curLevel = 0

        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            if (curLevel < level) {
                curLevel = level
                sum = node.`val`
            } else {
                sum += node.`val`
            }

            val left = node.left
            if (left != null) queue.addLast(left to level + 1)
            val right = node.right
            if (right != null) queue.addLast(right to level + 1)
        }
        return sum
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}