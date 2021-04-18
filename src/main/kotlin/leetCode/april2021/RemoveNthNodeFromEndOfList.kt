package leetCode.april2021

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var result = ListNode(0)
        var slow = head
        result.next = slow
        var fast = head
        var dif = n
        while (dif >= 0) {
            if (fast == null) {
                return head?.next
            } else {
                fast = fast.next
                dif--
            }
        }
        while (fast != null){
            fast = fast.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return result.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}