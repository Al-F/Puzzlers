package leetCode.march2021

class DesignHashMap {
    class MyHashMap() {

        /** Initialize your data structure here. */
        val arr = Array<ArrayList<Pair<Int, Int>>>(10000){ arrayListOf() }

        /** value will always be non-negative. */
        fun put(key: Int, value: Int) {
            val mod = key.hashCode() / 10000
            remove(key)
            arr[mod].add(key to value)
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        fun get(key: Int): Int {
            val mod = key.hashCode() / 10000
            val values = arr[mod]
            return values.firstOrNull { it.first == key }?.second ?: -1
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        fun remove(key: Int) {
            val mod = key.hashCode() / 10000
            val values = arr[mod]
            val value = values.firstOrNull { it.first == key }?.second ?: -1
            if (value != -1) {
                values.remove(key to value)
            }
        }
    }
}
