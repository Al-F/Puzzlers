package leetCode.recursion

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
fun main() {
    val tail = ListNd(3)
    val middle = ListNd(2)
    middle.next = tail
    val head = ListNd(1)
    head.next = middle

    val f = ReverseLinkedList()
    f.reverseList(head)
}

class ReverseLinkedList {
    fun reverseList(head: ListNd?): ListNd? {
        if (head == null) return null
        if (head.next == null) return head

        var result = head
        while (result?.next != null) {
            result = result.next
        }
        relink(head, head.next)
        return result
    }

    private fun relink(first: ListNd, second: ListNd?): ListNd {
        if (second == null) return first
        val resNode = relink(second, second.next)
        resNode.next = first
        resNode.next?.next = null
        return resNode.next!!
    }
}

class ListNd(var `val`: Int) {
    var next: ListNd? = null
}