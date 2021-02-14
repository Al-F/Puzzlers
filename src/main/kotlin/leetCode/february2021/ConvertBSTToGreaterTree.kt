package leetCode.february2021

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * The left subtree of a node contains only nodes with keys less than the node's key
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
class ConvertBSTToGreaterTree {
    private var counter = 0
    fun convertBST(root: TreeNodeGT?): TreeNodeGT? {
        countRec(node = root)
        return root
    }

    private fun countRec(node: TreeNodeGT?) {
        if (node == null) return
        countRec(node.right)
        counter += node.`val`
        node.`val` = counter
        countRec(node.left)
    }

    fun convertBSTOneFun(root: TreeNodeGT?): TreeNodeGT? {
        if (root != null) {
            convertBSTOneFun(root.right)
            counter += root.`val`
            root.`val` = counter
            convertBSTOneFun(root.left)
        }
        return root
    }
}

class TreeNodeGT(var `val`: Int) {
    var left: TreeNodeGT? = null
    var right: TreeNodeGT? = null
}