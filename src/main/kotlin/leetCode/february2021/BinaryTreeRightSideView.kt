package leetCode.february2021

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */

class BinaryTreeRightSideView {
    fun rightSideViewLookOnNext(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        val deque = ArrayDeque<Pair<TreeNode?, Int>>()
        if (root == null) return result
        deque.add(root to 0)
        while (deque.size > 0){
            val current = deque.removeFirst()
            if (current.first?.left != null) deque.add(current.first?.left to current.second + 1)
            if (current.first?.right != null) deque.add(current.first?.right to current.second + 1)

            val next = deque.firstOrNull()?.second
            if (next == null || next > current.second){
                result.add(current.first?.`val` ?: 0)
            }
        }
        return result
    }

    fun rightSideViewRewriteOnLevel(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        val deque = ArrayDeque<Pair<TreeNode?, Int>>()
        if (root == null) return result
        deque.add(root to 0)
        while (deque.size > 0){
            val current = deque.removeFirst()
            if (current.first?.left != null) deque.add(current.first?.left to current.second + 1)
            if (current.first?.right != null) deque.add(current.first?.right to current.second + 1)
            if (result.size == current.second) {
                result.add(current.second, current.first?.`val` ?: 0)
            } else {
                result[current.second] = current.first?.`val` ?: 0
            }
        }
        return result
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}