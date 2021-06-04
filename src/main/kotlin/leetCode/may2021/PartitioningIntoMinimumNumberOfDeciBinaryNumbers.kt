package leetCode.may2021

class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    fun minPartitions(n: String): Int {
        var max = 0
        n.toCharArray().forEach {
            max = Math.max(max, Character.getNumericValue(it))
        }
        return max
    }
}