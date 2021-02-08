package leetCode.february2021
/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element
 * that will be returned by the next call to next().
 */
class PeekingIteratorGeneric<T: Any>(iterator: Iterator<T>) : Iterator<T> {
    private val iter = iterator
    private var isPeeked = false
    private lateinit var peekedElement: T
    fun peek(): T {
        if (!isPeeked) {
            peekedElement = iter.next()
            isPeeked = true
        }
        return peekedElement
    }

    override fun next(): T {
        val next: T
        if (isPeeked) {
            isPeeked = false
            next = peekedElement
        } else next = iter.next()
        return next
    }

    override fun hasNext(): Boolean {
        return if (isPeeked) true else iter.hasNext()
    }
}