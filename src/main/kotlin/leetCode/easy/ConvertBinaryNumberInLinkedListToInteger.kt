package leetCode.easy

class ConvertBinaryNumberInLinkedListToInteger {
    fun getDecimalValue(head: ListNode?): Int {
        if (head == null) return 0
        var start = head
        val resultStr = StringBuilder()
        while (start != null){
            resultStr.append(start.`val`)
            start = start.next
        }
        return resultStr.toString().toInt(2)
    }

    fun getDecimalValueBitwise(head: ListNode?): Int {
        var start = head
        var num = start!!.`val`
        while (start!!.next != null) {
            num = num shl 1 or start.next!!.`val`
            start = start.next
        }
        return num
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}