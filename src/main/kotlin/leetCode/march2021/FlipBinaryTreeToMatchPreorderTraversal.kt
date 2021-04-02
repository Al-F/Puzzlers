package leetCode.march2021

import java.util.*

class FlipBinaryTreeToMatchPreorderTraversal {
    lateinit var flipped: MutableList<Int>
    var index = 0
    lateinit var voyage: IntArray

    fun flipMatchVoyageSecondTry(root: TreeNode?, voyage: IntArray): List<Int>? {
        flipped = ArrayList<Int>()
        this.voyage = voyage
        depthFirstSearch(root)
        if (!flipped.isEmpty() && flipped[0] == -1) {
            flipped.clear()
            flipped.add(-1)
        }
        return flipped
    }

    private fun depthFirstSearch(node: TreeNode?) {
        if (node != null) {
            if (node.`val` != voyage[index++]) {
                flipped.clear()
                flipped.add(-1)
                return
            }
            if (index < voyage.size && node.left != null && node.left?.`val` != voyage[index]) {
                flipped.add(node.`val`)
                depthFirstSearch(node.right)
                depthFirstSearch(node.left)
            } else {
                depthFirstSearch(node.left)
                depthFirstSearch(node.right)
            }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}