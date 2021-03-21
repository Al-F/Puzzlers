package leetCode.march2021

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning
 * and the kth node from the end (the list is 1-indexed).
 */
class SwappingNodesInLinkedList {
    fun swapNodes(head: ListNd?, k: Int): ListNd? {
        if (head == null) return null
        val arr = arrayListOf(head.`val`)
        var curr = head
        while (curr?.next != null) {
            curr = curr.next
            arr.add(curr?.`val` ?: 0)
        }
        val endPosition = arr.size - k
        arr[k - 1] = arr[endPosition].also { arr[endPosition] = arr[k - 1] }

        curr = head
        arr.forEach {
            if (curr?.`val` != it) {
                curr?.`val` = it
            }
            curr = curr?.next
        }
        return head
    }
}

class ListNd(var `val`: Int) {
    var next: ListNd? = null
}