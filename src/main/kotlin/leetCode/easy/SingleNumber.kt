package leetCode.easy

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            if (set.contains(it)) {
                set.remove(it)
            } else set.add(it)
        }
        return set.first()
    }

    fun singleNumberXor(nums: IntArray): Int {
        var xsum = 0
        nums.forEach {
            xsum = xsum.xor(it)
        }
        return xsum
    }
}