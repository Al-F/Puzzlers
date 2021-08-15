package leetCode.august2021

fun main() {
    val f = ArrayOfDoubledPairs()
    f.canReorderDoubled(intArrayOf(10,20,40,80))
}

class ArrayOfDoubledPairs {
    fun canReorderDoubled(arr: IntArray): Boolean {
        val dictionary = HashMap<Int, Int>()
        arr.forEach {
            val count = dictionary.getOrPut(it, { 0 })
            dictionary[it] = count + 1
        }
        dictionary.keys.sortedBy { Math.abs(it) }.forEach {
            val first = dictionary.getOrDefault(it,0)
            val double = dictionary.getOrDefault(it * 2, 0)
            if (first != 0) {
                if (first <= double){
                    dictionary[it] = 0
                    dictionary[it*2] = double - first
                } else return false
            }
        }
        return true
    }
}