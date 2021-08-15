package leetCode.august2021

import java.util.*

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true

        val first = Stack<TreeNode>()
        val second = Stack<TreeNode>()

        if (p?.`val` == q?.`val`) {
            first.push(p)
            second.push(q)
        } else return false
        while (first.isNotEmpty()) {
            val curF = first.pop()
            val curS = second.pop()
            val leftF = curF.left
            val leftS = curS.left
            val rightF = curF.right
            val rightS = curS.right
            if (leftF?.`val` == leftS?.`val`) {
                if (leftF != null && leftS != null) {
                    first.push(leftF)
                    second.push(leftS)
                }
            } else return false
            if (rightF?.`val` == rightS?.`val`) {
                if (rightF != null && rightS != null) {
                    first.push(rightF)
                    second.push(rightS)
                }
            } else return false
        }
        return true
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}