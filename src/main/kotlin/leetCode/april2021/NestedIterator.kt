package leetCode.april2021

import kotlin.math.sign

class NestedIterator(nestedList: List<NestedInteger>) {
    var index = 0
    var flatten = arrayListOf<Int>()

    init {
        flattenList(nestedList)
    }

    private fun flattenList(nestedList: List<NestedInteger>) {
        nestedList.forEach {
            if (it.isInteger()){
                flatten.add(it.getInteger()!!)
            } else {
                flattenList(it.getList()!!)
            }
        }
    }

    fun next(): Int {
        return if (index < flatten.size) flatten[index++] else -1
    }

    fun hasNext(): Boolean {
        return index < flatten.size - 1
    }
}

class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return true
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return null
    }

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? {
        return null
    }
}