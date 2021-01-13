package LeetCode;

import java.util.Stack;

/**
 * Question: Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * <p>
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * The cloned tree is a copy of the original tree.
 * Return a reference to the same node in the cloned tree.
 * Note that you are not allowed to change any of the two trees or the target node and the answer
 * must be a reference to a node in the cloned tree.
 */
public class CorrespondingNode {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    /**
     * No recursive solution
     */
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cloned);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.val == target.val) {
                return current;
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return null;

        /**
         * Recursive Solution
         */
//        TreeNode found = null;
//        TreeNode leftRec = null;
//        TreeNode rightRec = null;
//        if (cloned != null) {
//            if (cloned.val != target.val) {
//                leftRec = getTargetCopy(original, cloned.left, target);
//                rightRec = getTargetCopy(original, cloned.right, target);
//                if (leftRec != null){
//                    found = leftRec;
//                }
//                if (rightRec != null){
//                    found = rightRec;
//                }
//            } else {
//                found = cloned;
//            }
//        }
//        return found;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}