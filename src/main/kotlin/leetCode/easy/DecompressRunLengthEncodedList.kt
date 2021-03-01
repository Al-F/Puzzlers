package leetCode.easy

class DecompressRunLengthEncodedList {
    fun decompressRLElist(nums: IntArray): IntArray {
        var size = 0
        for (friq in 0 .. nums.size-2 step 2){
            size += nums[friq]
        }
        val result = IntArray(size)
        var indexInResult = 0
        for (friq in 0 .. nums.size-2 step 2){
            val repeat = nums[friq]
            val value = nums[friq+1]
            for (i in 0 until repeat){
                result[indexInResult] = value
                indexInResult++
            }
        }
        return result
    }
}