package leetCode.easy

class SumOfAllSubsetXORTotals {
    lateinit var numsGlob: IntArray
    var sum = 0

    fun subsetXORSum(nums: IntArray): Int {
        numsGlob = nums
        allSubsets(0, 0)
        return sum
    }

    fun allSubsets(pos: Int, len: Int) {
        sum += len
        var _len = len

        for (i in pos until numsGlob.size) {
            _len = len xor numsGlob.get(i)
            allSubsets( i + 1, _len)
            _len = len xor numsGlob.get(i)
        }
    }
}