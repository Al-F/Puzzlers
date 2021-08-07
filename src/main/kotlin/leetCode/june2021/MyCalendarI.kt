package leetCode.june2021

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val f = MyCalendarI()
    f.book(904811797, 914979569)
    f.book(994764979, 1000000000)
    f.book(128727076, 148660879)
}

class MyCalendarI {
    val priorityQueue = PriorityQueue<Int>()
    fun bookTooLong(start: Int, end: Int): Boolean {
        val range = start until end
        return if (priorityQueue.none { it in range }) {
            priorityQueue.addAll(range)
            true
        } else false
    }

    val array = ArrayList<Pair<Int, Int>>()
    fun book(start: Int, end: Int): Boolean {
        array.forEach {
            if (start >= it.first && start < it.second
                || end > it.first && end < it.second
                || start <= it.first && end >= it.second
            ) {
                return false
            }
        }
        array.add(start to end)
        return true
    }
}