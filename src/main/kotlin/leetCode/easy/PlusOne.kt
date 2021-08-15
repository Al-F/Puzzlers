package leetCode.easy

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size-1 downTo 0){
            if (digits[i]<9){
                digits[i] = digits[i]+1
                return digits
            } else {
                digits[i] = 0
            }
        }
        val result = IntArray(digits.size+1)
        result[0] = 1
        return result
    }
}