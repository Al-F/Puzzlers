package LeetCode.January2021

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
class RemoveDuplicatesFromListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var first = head
        var second = head?.next
        var isCopy = false
        var lastNode = ListNode(-1)
        val root = lastNode
        while (first != null){
            if (first.value() == second?.value()){
                first = second
                second = second.next
                isCopy = true
            } else {
                if (isCopy){
                    first = second
                    second = second?.next
                    isCopy = false
                } else{
                    lastNode.next = first
                    lastNode = lastNode.next!!
                    first = second
                    second = second?.next
                    lastNode.next = null
                }
            }
        }
        return root.next
    }
}

fun ListNode.value() = this.`val`