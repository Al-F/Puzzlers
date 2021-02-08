package leetCode.february2021

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element
 * that will be returned by the next call to next().
 */
class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {
    private val iter = iterator
    private var isPeeked = false
    private var peekedElement: Int? = null
    fun peek(): Int {
        if (!isPeeked) {
            peekedElement = iter.next()
            isPeeked = true
        }
        return peekedElement ?: Int.MIN_VALUE
    }

    override fun next(): Int {
        val next: Int?
        if (isPeeked) {
            isPeeked = false
            next = peekedElement
            peekedElement = null
        } else next = iter.next()
        return next ?: Int.MIN_VALUE
    }

    override fun hasNext(): Boolean {
        return if (isPeeked && peekedElement != null) {
            true
        } else {
            iter.hasNext()
        }
    }
}