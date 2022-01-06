package leetCode.october2021

import leetCode.april2021.NaryTreePreorderTraversal
import leetCode.easy.ConvertSortedArrayToBinarySearchTree

class ConstructBinarySearchTreeFromPreorderTraversal {

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val root = TreeNode(preorder.first())
        if (preorder.size == 1) return root
        val nextBigThing = preorder.indexOfFirst { it > root.`val` }
        if (nextBigThing > 0) {
            root.left = createLeaf(root, preorder.sliceArray(1 until nextBigThing), true)
            root.right = createLeaf(
                root,
                preorder.sliceArray(nextBigThing until preorder.size),
                false
            )
        } else {
            root.left = createLeaf(root, preorder.sliceArray(1 until preorder.size), true)
        }
        return root
    }

    private fun createLeaf(root: TreeNode, nums: IntArray, isLeft: Boolean): TreeNode? {
        //System.out.println("${nums}, $isLeft")
        if (nums.isEmpty()) return null
        if (nums.size == 1) return TreeNode(nums[0])
        val leaf = TreeNode(nums[0])
        val nextBigThing = nums.indexOfFirst { it > leaf.`val` }
        if (nextBigThing > 0) {
            leaf.left = createLeaf(leaf, nums.sliceArray(1 until nextBigThing), true)
            leaf.right = createLeaf(leaf, nums.sliceArray(nextBigThing until nums.size), false)
        } else {
            leaf.left = createLeaf(leaf, nums.sliceArray(1 until nums.size), true)
        }

        return leaf
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
