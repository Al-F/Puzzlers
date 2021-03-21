package leetCode.recursion

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        head.`val` = head.next!!.`val`.also { head.next!!.`val` = head.`val` }
        swapPairs(head.next?.next)

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}