package leetCode.january2022

class LinkedListCycleII {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        val set = HashSet<ListNode>()
        set.add(head)
        var fast = head.next
        while(fast != null){
            if (set.contains(fast)){
                return fast
            } else {
                set.add(fast)
                fast = fast.next
            }
        }
        return null
    }

    fun detectCycleConstMemory(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                slow = head
                while (slow != fast) {
                    slow = slow?.next
                    fast = fast?.next
                }
                return slow
            }
        }

        return null
    }
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}