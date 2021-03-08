package leetCode.march2021

import leetCode.february2021.ListNode

//1 9 1 0 2

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null
        var lengthFirst = 1
        var lengthSecond = 1
        var start = headA
        while (start?.next != null) {
            start = start.next
            lengthFirst++
        }
        var bStart = headB
        while (bStart?.next != null) {
            bStart = bStart.next
            lengthSecond++
        }


        start = headA
        bStart = headB
        if (lengthFirst > lengthSecond) {
            var dif = lengthFirst - lengthSecond
            while(dif > 0){
                start = start?.next
                dif--
            }
        } else {
            var dif = lengthSecond - lengthFirst
            while(dif > 0){
                bStart = bStart?.next
                dif--
            }
        }
        return if (start != bStart) {
            while (start != bStart) {
                start = start?.next
                bStart = bStart?.next
            }
            start
        } else {
            start
        }
    }
}