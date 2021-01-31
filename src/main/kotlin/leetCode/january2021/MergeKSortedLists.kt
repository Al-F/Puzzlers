package leetCode.january2021

import java.util.*

fun main() {
    val f = MergeKSortedLists()
    f.mergeKLists(arrayOf(ListNodeA(1), ListNodeA(2), ListNodeA(5)))
}
/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNodeA?>): ListNodeA? {
        if (lists.isEmpty()) {
            return null
        }
        if (lists.size == 1) {
            return lists[0]
        }
        var lastNode = ListNodeA(0)
        val root = lastNode

        var index = 0
        var size = 0
        val priorityQueue = PriorityQueue<Int>()
        while (index<=500) {
            for (node in lists.indices) {
                if (lists[node]?.`val` != null) {
                    priorityQueue.add(lists[node]?.`val`)
                    lists[node] = lists[node]?.next
                }
            }
            index++
            if (size == priorityQueue.size){
                break
            }
            size = priorityQueue.size
        }
        while (priorityQueue.isNotEmpty()){
            lastNode.next = ListNodeA(priorityQueue.poll())
            lastNode = lastNode.next!!
        }
        return root.next
    }
}

class ListNodeA(var `val`: Int) {
    var next: ListNodeA? = null
}