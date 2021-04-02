package leetCode.easy

/**
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer
 * between 1 and n and value is a string. No two pairs have the same id.
 * Design a stream that returns the values in increasing order of their IDs by returning a chunk (list)
 * of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.
 * Implement the OrderedStream class:
 * OrderedStream(int n) Constructs the stream to take n values.
 * String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream,
 * then returns the largest possible chunk of currently inserted values that appear next in the order.
 */
class OrderedStream(n: Int) {
    val hashMap = HashMap<Int, String>()
    var startKey = 1

    init {
        for (i in 1..n) {
            hashMap[i] = ""
        }
    }

    fun insert(idKey: Int, value: String): List<String> {
        hashMap[idKey] = value
        val result = ArrayList<String>()

        for (i in startKey .. hashMap.size) {
            val current = hashMap.getOrDefault(i,  "")
            if (current != "") {
                result.add(current)
            } else {
                startKey = i
                break
            }
        }
        return result
    }

}