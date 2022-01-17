package leetCode.january2022

import java.util.*


class SumOfRootToLeafBinaryNumbers {
    var sum = 0
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0
        val str = StringBuilder()
        goDown(root, str)
        goDownBinary(root, 0)
        return sum
    }

    private fun goDown(node: TreeNode, str: StringBuilder) {
        str.append(node.`val`)
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(str.toString())
            str.deleteCharAt(str.lastIndex)
            return
        }
        if (node.left != null) goDown(node.left!!, str)
        if (node.right != null) goDown(node.right!!, str)
        str.deleteCharAt(str.lastIndex)
    }

    private fun goDownBinary(node: TreeNode, cur: Int) {
        var temp = cur shl 1 + node.`val`
        if (node.left == null && node.right == null) {
            sum += temp
            return
        }
        if (node.left != null) goDownBinary(node.left!!, temp)
        if (node.right != null) goDownBinary(node.right!!, temp)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}