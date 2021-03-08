package leetCode.march2021

import leetCode.february2021.TreeNode

//[3,9,20,15,7]
class AverageLevelsInBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = ArrayList<Double>()
        if (root == null) return result.toDoubleArray()
        val deque = ArrayDeque<Pair<TreeNode, Int>>()
        deque.add(root to 0)
        var level = 0
        var acc: Long = 0
        var count = 0.0
        while (deque.isNotEmpty()) {
            val elem = deque.removeFirst()
            val first = elem.first
            val levelCur = elem.second
            if (first.left != null) deque.addLast(first.left!! to levelCur + 1)
            if (first.right != null) deque.addLast(first.right!! to levelCur + 1)
            if (level == levelCur) {
                acc += first.`val`.toLong()
                count++
            } else {
                result.add(acc / count)
                level = levelCur
                count = 1.0
                acc = first.`val`.toLong()
            }
        }
        result.add(acc / count)
        return result.toDoubleArray()
    }
}