package leetCode.january2022

import kotlin.random.Random

class LinkedListRandomNode(val head: ListNode?) {
    fun getRandom(): Int {
        var size = 0
        var random = Random.nextInt(1, 10000)
        var current = head
        while (random > 0 && current != null) {
            if (random == 1) {
                return current.`val`
            } else {
                current = current.next
                random--
                size++
            }
        }

        var rand = if (size > 1) {
            Random.nextInt(1, size)
        } else {
            return head!!.`val`
        }
        current = head
        while (rand > 0) {
            current = current!!.next
            rand--
        }
        return current!!.`val`
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}