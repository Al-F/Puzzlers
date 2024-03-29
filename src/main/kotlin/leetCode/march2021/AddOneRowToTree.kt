package leetCode.march2021

/**
 * Given the root of a binary tree, then value v and depth d,
 * you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root.
 * And N's original left subtree should be the left subtree of the new left subtree root,
 * its original right subtree should be the right subtree of the new right subtree root.
 * If depth d is 1 that means there is no depth d-1 at all,
 * then create a tree node with value v as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 */
class AddOneRowToTree {
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (root == null) return null

        if (d == 1) {
            return TreeNode(v).apply { left = root }
        }
        if (d == 2) {
            root.left = TreeNode(v).apply { left = root.left }
            root.right = TreeNode(v).apply { right = root.right }

            return root
        }

        addOneRow(root.left, v, d - 1)
        addOneRow(root.right, v, d - 1)

        return root
    }

    public class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}