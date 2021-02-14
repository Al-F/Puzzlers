package leetCode.february2021

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list,
 * where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.va
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node
 * Your code will only be given the head of the original linked list.
 */
class CopyListWithRandomPointer {
    fun copyRandomList(node: NodeR?): NodeR? {
        if (node == null) return node
        var origin = node
        var tmp = NodeR(0)
        val root = tmp
        val oldNewWorld = HashMap<NodeR, NodeR>()
        while (origin != null){
            val nextCopy = oldNewWorld.getOrPut(origin, {NodeR(origin!!.`val`)})
            if (origin.random!=null) {
                nextCopy.random = oldNewWorld.getOrPut(origin.random!!, { NodeR(origin!!.random!!.`val`) })
            }
            tmp.next = nextCopy

            origin = origin.next
            tmp = tmp.next!!
        }
        return root.next
    }
}

class NodeR(var `val`: Int) {
    var next: NodeR? = null
    var random: NodeR? = null
}