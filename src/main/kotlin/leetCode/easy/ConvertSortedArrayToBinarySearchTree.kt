package leetCode.easy

class ConvertSortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        if (nums.size == 1) return TreeNode(nums[0])

        val midIndex = nums.size/2
        val root = TreeNode(nums[midIndex])
        root.left = createLeaf(root, nums.sliceArray(0 until midIndex), true)
        root.right = createLeaf(root, nums.sliceArray(midIndex+1 until nums.size), false)
        return root
    }

    private fun createLeaf(root: TreeNode, nums: IntArray, isLeft: Boolean): TreeNode? {
        System.out.println("${nums}, $isLeft")
        if (nums.isEmpty()) return null
        if (nums.size == 1) return TreeNode(nums[0])
        val midIndex = nums.size/2
        val leaf = TreeNode(nums[midIndex])
        leaf.left = createLeaf(leaf, nums.sliceArray(0 until midIndex), true)
        leaf.right = createLeaf(leaf, nums.sliceArray(midIndex+1 until nums.size), false)
        return leaf
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}