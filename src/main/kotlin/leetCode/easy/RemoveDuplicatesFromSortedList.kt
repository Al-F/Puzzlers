package leetCode.easy

class RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null

        var node = head
        while (node?.next!= null){
            if (node.next?.`val` == node.`val`){
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }
        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}