package leetCode.august2021

class NaryTreeLevelOrderTraversal {
    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<Pair<Node, Int>>()
        queue.addLast(root to 0)
        var curLevel = 0
        var midResult = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            if (level == curLevel) {
                midResult.add(node.`val`)
            } else {
                result.add(midResult)
                midResult = mutableListOf()
                curLevel++
                midResult.add(node.`val`)
            }
            node.children.forEach { child ->
                if (child != null) {
                    queue.addLast(child to level + 1)
                }
            }
        }
        result.add(midResult)
        return result
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}