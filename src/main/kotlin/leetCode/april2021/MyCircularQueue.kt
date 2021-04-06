package leetCode.april2021

class MyCircularQueue(k: Int) {
    val myQueue = Array<Int?>(k) { null }
    var end = 0
    var start = 0
    fun enQueue(value: Int): Boolean {
        val newEnd = end % myQueue.size
        return if (myQueue[newEnd] == null) {
            myQueue[newEnd] = value
            end++
            true
        } else false
    }

    fun deQueue(): Boolean {
        return if (!isEmpty()) {
            val newStart = start % myQueue.size
            myQueue[newStart] = null
            start++
            true
        } else false
    }

    fun Front(): Int {
        return myQueue[start % myQueue.size] ?: -1
    }

    fun Rear(): Int {
        val newEnd = if (end % myQueue.size == 0) myQueue.size - 1 else end % myQueue.size - 1
        return myQueue[newEnd] ?: Int.MIN_VALUE
    }

    fun isEmpty(): Boolean {
        return myQueue.all { it == null }
    }

    fun isFull(): Boolean {
        return myQueue.all { it != null }
    }
}