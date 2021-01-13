package LeetCode.January2021

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var lastNode = ListNode(0)
        val root = lastNode
        var tmpL1 = l1
        var tmpL2 = l2

        var value = 0
        var residual = 0
        var mod = 0
        while (tmpL1 != null && tmpL2 != null) {
            value = tmpL1.value() + tmpL2.value() + residual
            mod = value % 10
            residual = value / 10

            lastNode.next = ListNode(mod)
            tmpL1 = tmpL1.next
            tmpL2 = tmpL2.next
            lastNode = lastNode.next!!
        }
        while (tmpL1 != null) {
            value = tmpL1.value() + residual
            mod = value % 10
            residual = value / 10

            lastNode.next = ListNode(mod)
            lastNode = lastNode.next!!
            tmpL1 = tmpL1.next
        }
        while (tmpL2 != null) {
            value = tmpL2.value() + residual
            mod = value % 10
            residual = value / 10

            lastNode.next = ListNode(mod)
            lastNode = lastNode.next!!
            tmpL2 = tmpL2.next
        }

        if (residual != 0){
            lastNode.next = ListNode(residual)
        }

        return root.next
    }
}