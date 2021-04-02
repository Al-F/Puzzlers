package leetCode.april2021

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return false
        val arrayList = ArrayList<Int>()
        var cur = head
        while (cur != null) {
            arrayList.add(cur.`val`)
            cur = cur.next
        }
        var tail = arrayList.size - 1
        for (i in arrayList.indices) {
            if(i > tail) break
            if(arrayList[i] != arrayList[tail]) return false
            tail--
        }
        return true
    }

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}