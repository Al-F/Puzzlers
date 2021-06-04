package leetCode.may2021

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val stack = ArrayDeque<Pair<Int, TreeNode>>()
        stack.addLast(0 to root)
        val hashMap = HashMap<Int, ArrayList<Int>>()
        while (stack.isNotEmpty()){
            val cur = stack.removeFirst()
            val hash = hashMap.getOrPut(cur.first, { arrayListOf() })
            hash.add(cur.second.`val`)
            hashMap[cur.first] = hash
            if (cur.second.left != null) stack.addLast(cur.first+1 to cur.second.left!!)
            if (cur.second.right != null) stack.addLast(cur.first+1 to cur.second.right!!)
        }
        return hashMap.values.toList()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}