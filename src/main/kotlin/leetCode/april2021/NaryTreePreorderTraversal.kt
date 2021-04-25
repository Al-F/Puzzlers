package leetCode.april2021

class NaryTreePreorderTraversal {
    fun preorder(root: Node?): List<Int> {
        if (root == null) return emptyList()
        val result = ArrayList<Int>()
        val deque = ArrayDeque<Node>()
        deque.addLast(root)
        while (deque.isNotEmpty()) {
            val cur = deque.removeLast()
            result.add(cur.`val`)
            for (i in cur.children.size - 1 downTo 0) {
                val child = cur.children[i]
                if (child != null) {
                    deque.add(child)
                }
            }
        }
        return result
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}