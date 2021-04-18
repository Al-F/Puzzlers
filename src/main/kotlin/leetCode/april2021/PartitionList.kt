package leetCode.april2021

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var leftHead = ListNode(0)
        val resLeft = leftHead
        var rightHead = ListNode(0)
        val resRight = rightHead

        var theHead = head
        while (theHead != null) {
            if (theHead.`val` < x) {
                leftHead.next = theHead
                leftHead = leftHead.next!!
            } else {
                rightHead.next = theHead
                rightHead = rightHead.next!!
            }
            theHead = theHead.next
        }

        rightHead.next = null
        leftHead.next = resRight.next
        return resLeft.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}