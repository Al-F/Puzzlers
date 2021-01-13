package LeetCode.January2021

class MergeLinkedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var lastNode = ListNode(0)
        val root = lastNode
        var tmpL1 = l1
        var tmpL2 = l2

        while (tmpL1 != null && tmpL2 != null) {
            if (tmpL1.`val` < tmpL2.`val`) {
                lastNode.next = tmpL1
                tmpL1 = tmpL1.next
            } else {
                lastNode.next = tmpL2
                tmpL2 = tmpL2.next
            }
            lastNode = lastNode.next!!
        }
        while (tmpL1 != null) {
            lastNode.next = tmpL1
            lastNode = lastNode.next!!
            tmpL1 = tmpL1.next
        }
        while (tmpL2 != null) {
            lastNode.next = tmpL2
            lastNode = lastNode.next!!
            tmpL2 = tmpL2.next
        }

        return root.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

